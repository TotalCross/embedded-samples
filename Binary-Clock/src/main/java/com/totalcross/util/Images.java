package com.totalcross.util;

import totalcross.ui.MainWindow;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.image.Image;

public class Images {
    public static Image background, ledRed, ledDark;

    public static void loadImages() {
        try {
            // testing if we are running on landscape or protrait
            if (MainWindow.getMainWindow().getWidth() > MainWindow.getMainWindow().getHeight())
                background = new Image("images/back2.jpg");
            else
                background = new Image("images/back2portrait.jpg");

            ledRed = new Image("images/Red.png");
            ledDark = new Image("images/gray.png");

        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
}
