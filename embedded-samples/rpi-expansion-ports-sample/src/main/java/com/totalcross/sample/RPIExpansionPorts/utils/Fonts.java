package com.totalcross.sample.RPIExpansionPorts.utils;

import totalcross.ui.font.Font;

public class Fonts {

    public static Font Title;
    public static Font TextBold;
    public static Font TextRegular;
    public static Font Value;

    public static void loadFonts() {
        Title = Font.getFont("Fonts/Roboto-Bold", false, 14);
        TextBold = Font.getFont("Fonts/Roboto-Bold", false, 12);
        TextRegular = Font.getFont("Fonts/Roboto-Regular", false, 10);
        Value = Font.getFont("Fonts/Roboto-Regular", false, 9);

    }
}