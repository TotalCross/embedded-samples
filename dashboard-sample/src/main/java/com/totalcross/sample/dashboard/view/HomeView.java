package com.totalcross.sample.dashboard.view;

import com.totalcross.sample.dashboard.util.*;

import totalcross.ui.*;

public class HomeView extends Container {
    private Label lInit;
    private ImageControl icLogoTotalCross;
    private Button bStart;

    public void initUI() {

        icLogoTotalCross = new ImageControl(Images.iTotalCrossLogoVertical);
        icLogoTotalCross.scaleToFit = true;

        lInit = new Label("TotalCross running in Toradex");
        lInit.setForeColor(Colors.COLOR_LIGHT_GRAY);

        bStart = new Button("START");
        // Verde
        // bStart.setBackForeColors(Colors.COLOR_GREEN_BUTTON, Colors.COLOR_WHITE);
        // Vermelho
        bStart.setBackForeColors(Colors.COLOR_RED, Colors.COLOR_WHITE);
        bStart.setBorder(BORDER_ROUNDED);
        bStart.setDoEffect(false);
        bStart.addPressListener((c) -> {
            MainWindow.getMainWindow().swap(new AnalogInputView());
        });

        // Components in the screen
        add(icLogoTotalCross, CENTER, CENTER - MaterialConstants.DP60H);
        add(lInit, CENTER, AFTER);
        add(bStart, CENTER, AFTER + MaterialConstants.DP45H, SCREENSIZE + MaterialConstants.DP10W,
                SCREENSIZE + MaterialConstants.DP5H);
    }

}
