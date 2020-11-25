// Copyright (C) 2003-2004 Johannes Wallroth (www.programming.de)
// Copyright (C) 2004-2013 SuperWaba Ltda.
// Copyright (C) 2014-2020 TotalCross Global Mobile Platform Ltda.
//
// SPDX-License-Identifier: LGPL-2.1-only

package com.totalcross.sample.game.breakout;

import totalcross.game.GameEngine;
import totalcross.game.TextRenderer;
import totalcross.sys.Settings;
import totalcross.sys.Vm;
import totalcross.ui.Container;
import totalcross.ui.MainWindow;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Graphics;

public class Breakout extends GameEngine {
  public int currentLevel = 1;
  private int racketY;

  private Racket racket;
  private Ball ball;
  private Level level;

  private TextRenderer levelRenderer, tilesRenderer;
  private static final int BACKG = 0x000099;

  private boolean levelChanged = true;

  public static int screenPosition = 0;

  public Breakout() {
    setUIStyle(Settings.FLAT_UI);
    gameName = "Breakout";
    gameCreatorID = "tCbA";
    gameVersion = 140;
    gameRefreshPeriod = (Settings.keyboardFocusTraversable ? 70 : 50);
    gameDoClearScreen = false;
    gameHasUI = true;

    MainWindow.setDefaultFont(MainWindow.getDefaultFont().asBold());
    if (Settings.screenWidth < Settings.screenHeight) {
      screenPosition = Settings.screenWidth;
    } else {
      screenPosition = Settings.screenHeight;
    }
  }

  private static final int PERC = 10;
  private int levelX, tilesX;

  @Override
  public void onGameInit() {
    setBackColor(BACKG);

    try {
      levelRenderer = createTextRenderer(getFont(), 0x9999FF, "Level: ", 1, true);
      tilesRenderer = createTextRenderer(getFont(), 0x9999FF, "Remaining: ", 2, true);
      racket = new Racket();
      level = new Level(2 + levelRenderer.getHeight());
      ball = new Ball(this, racket, level);
    } catch (Exception e) {
      MessageBox.showException(e, true);
      MainWindow.exit(0);
    }

    levelX = Settings.screenWidth * PERC / 100;
    tilesX = Settings.screenWidth - tilesRenderer.getWidth() - levelX;
    racketY = Settings.screenHeight - racket.height - 2;

    Introduction.swapTo(this);
  }

  @Override
  public void onGameStart() {
    racket.setPos(Settings.screenWidth / 2, racketY, false);
    if (levelChanged) {
      level.set(currentLevel);
    }
    ball.reinit(level);
    levelChanged = true;
  }

  @Override
  public void onGameStop() {
    if (level.tilesLeft == 0) {
      if (currentLevel < Level.MAX_LEVELS) {
        currentLevel++;
      } else {
        currentLevel = 1;
      }
      levelChanged = true;
    }

    Vm.sleep(350);
    GameOver go = new GameOver(this);
    go.announce(currentLevel);
  }

  @Override
  public final void onPaint(Graphics gfx) {
    if (gameIsRunning) {
      gfx.backColor = BACKG;
      gfx.fillRect(0, 0, Settings.screenWidth, Settings.screenHeight);
      levelRenderer.display(levelX, 2, currentLevel);
      tilesRenderer.display(tilesX, 2, level.tilesLeft);
      level.show();
      if (level.tilesLeft == 0) {
        stop();
      } else {
        if (!levelChanged) {
          ball.show();
        }
        levelChanged = false; // don't remove this from here or the racket will get dirty by the ball when the
                              // game inits
        racket.show();
        ball.move();
      }
    }
  }

  @Override
  public final void onPenDown(PenEvent evt) {
    if (gameIsRunning) {
      racket.setPos(evt.x, racketY, true);
    }
  }

  @Override
  public final void onPenDrag(PenEvent evt) {
    if (gameIsRunning) {
      racket.setPos(evt.x, racketY, true);
    }
  }

  Container blankContainer;

  public void blankScreen() {
    if (blankContainer == null) {
      blankContainer = new Container();
      blankContainer.setRect(10000, 0, 0, 0); // guich@512_7: we don't want this to overwrite the game's window, so just
                                              // set all to 0.
      blankContainer.setBackColor(backColor);
    }
    swap(blankContainer);
  }
}
