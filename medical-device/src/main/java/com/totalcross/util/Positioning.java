package com.totalcross.util;

import totalcross.sys.Settings;

public class Positioning {
    public static int getWidthDP(int value) {
        return value*Settings.screenWidth/960;
    }
    public static int getHeightDP(int value) {
        return value*Settings.screenHeight/640;
    }
}