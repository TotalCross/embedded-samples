// Copyright (C) 2003-2004 Johannes Wallroth (www.programming.de)
// Copyright (C) 2004-2013 SuperWaba Ltda.
// Copyright (C) 2014-2020 TotalCross Global Mobile Platform Ltda.
//
// SPDX-License-Identifier: LGPL-2.1-only

package com.totalcross.sample.game.breakout;

import com.totalcross.sample.game.breakout.device.NumberDisplayUpdate;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

final class GameOver extends Container {
  private Breakout game;
  private Button button;
  private Label label;

  protected GameOver(Breakout game) {
    this.game = game;
  }

  @Override
  public void initUI() {
    setRect(game.getRect());

    int bgColor = 0x999900;
    label.setBackForeColors(bgColor, Color.YELLOW);
    Font bigFont = Font.getFont(font.name, true, Font.BIG_SIZE);
    label.setFont(bigFont);

    add(label, CENTER, CENTER); // same bug: fonts must be set before placing the control on screen
    add(button);
    button.setRect(CENTER, AFTER + 10, PREFERRED + Breakout.screenPosition / 16,
        PREFERRED + Breakout.screenPosition / 16);
    setBackColor(bgColor);
    button.setBackForeColors(bgColor, Color.WHITE);

  }

  public void announce(int nextLevel) {
    if (nextLevel > 0) {
      label = new Label("Level " + nextLevel);
      button = new Button("Start Game");
    } else {
      label = new Label("GAME OVER");
      button = new Button("New Game");
    }

    NumberDisplayUpdate.getInstance().updateNumber(0);

    game.swap(this);
  }

  @Override
  public void onEvent(Event event) {
    if (event.type == ControlEvent.PRESSED && event.target == button) {
      game.blankScreen();
      game.start();
    }
  }
}
