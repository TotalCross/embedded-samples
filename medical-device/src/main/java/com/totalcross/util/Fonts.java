package com.totalcross.util;

import totalcross.ui.font.Font;

public class Fonts {
    
    public static Font BARLOW_CONDENSED_50;
    public static Font BARLOW_CONDENSED_150;
    public static Font BARLOW_CONDENSED_24;
    public static Font BARLOW_CONDENSED_25;
    public static Font BARLOW_CONDENSED_17;
    public static Font BARLOW_CONDENSED_20;
    public static Font BARLOW_CONDENSED_54;

    public static void loadFonts() {
        BARLOW_CONDENSED_17 = Font.getFont("BarlowCondensed-Regular", false, 17);
        BARLOW_CONDENSED_20 = Font.getFont("BarlowCondensed-Regular", false, 20);
        BARLOW_CONDENSED_24 = Font.getFont("BarlowCondensed-Regular", false, 24);
        BARLOW_CONDENSED_25 = Font.getFont("BarlowCondensed-Regular", false, 25);
        BARLOW_CONDENSED_50 = Font.getFont("BarlowCondensed-Regular", false, 50);
        BARLOW_CONDENSED_54 = Font.getFont("BarlowCondensed-Regular", false, 54);
        BARLOW_CONDENSED_150 = Font.getFont("BarlowCondensed-Regular", false, 150);
    }
}