// Copyright (C) 2003-2004 Johannes Wallroth (www.programming.de)
// Copyright (C) 2004-2013 SuperWaba Ltda.
// Copyright (C) 2014-2020 TotalCross Global Mobile Platform Ltda.
//
// SPDX-License-Identifier: LGPL-2.1-only

package com.totalcross.sample.game.breakout;

import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

final class Introduction extends Container {
  private Breakout game;
  private Button button;
  private static Introduction singleton;

  static void swapTo(Breakout game) {
    if (singleton == null) {
      singleton = new Introduction(game);
    }
    game.swap(singleton);
  }

  protected Introduction(Breakout game) {
    this.game = game;
  }

  @Override
  public void initUI() {
    setRect(game.getRect());

    int bgColor = 0x999900;
    Label label1, label2, label3;
    label1 = new Label("Breakout Retro Game");
    label2 = new Label("© TotalCross Plaform");
    label3 = new Label("github.com/totalcross/breakout");
    label1.setBackForeColors(bgColor, 0xFFFF00);
    label2.setBackForeColors(bgColor, Color.WHITE);
    label3.setBackForeColors(bgColor, 0xCCCCFF);
    Font bigFont = Font.getFont(font.name, true, Font.BIG_SIZE);
    label1.setFont(bigFont); // FONT MUST BE SET ***BEFORE*** ADDING THE CONTROL TO THE SCREEN

    add(label1, CENTER, TOP + 15);
    add(label2, CENTER, AFTER + 5);
    add(label3, CENTER, AFTER + 5);

    try {
      ImageControl crossy = new ImageControl(new Image("crossy2.png").smoothScaledBy(0.3, 0.3));
      crossy.transparentBackground = true;

      add(crossy, CENTER, AFTER + 5);

    } catch (IOException | ImageException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    add(button = new Button("Start Game"));
    button.setRect(CENTER, BOTTOM - 15, PREFERRED + Breakout.screenPosition / 16,
        PREFERRED + Breakout.screenPosition / 16);
    setBackColor(Color.getRGB(53, 42, 154));
    button.setBackForeColors(bgColor, Color.WHITE);

  }

  @Override
  public void onEvent(Event event) {
    if (event.type == ControlEvent.PRESSED && event.target == button) {
      game.blankScreen();
      game.start();
    }
  }
}
