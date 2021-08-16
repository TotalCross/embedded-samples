package com.totalcross.util;

import totalcross.ui.dialog.MessageBox;
import totalcross.ui.image.Image;

public class Images {
    public static Image background,ledRed,ledDark;

    public Images(){

    }
    public static void loadImage() {
        try {
            background = new Image("images/Binary-Clock.png");   
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
    public static void loadLed() {
        try {
            ledRed = new Image("images/LedVermelho.jpg");    
            ledDark = new Image("images/LedDark.jpg"); 

        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
}
