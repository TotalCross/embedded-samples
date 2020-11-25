// Copyright (C) 2003-2004 Johannes Wallroth (www.programming.de)
// Copyright (C) 2004-2013 SuperWaba Ltda.
// Copyright (C) 2014-2020 TotalCross Global Mobile Platform Ltda.
//
// SPDX-License-Identifier: LGPL-2.1-only

package com.totalcross.sample.game.breakout;

import totalcross.TotalCrossApplication;

public class RunBreakoutApplication {
  public static void main(String[] args) {
    TotalCrossApplication.run(Breakout.class, "/scr", "800x480");
  }
}
