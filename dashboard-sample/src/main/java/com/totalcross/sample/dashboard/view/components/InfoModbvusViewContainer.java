package com.totalcross.sample.dashboard.view.components;

import com.totalcross.sample.dashboard.util.Fonts;
import com.totalcross.sample.dashboard.util.MaterialConstants;

import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.gfx.Graphics;
import totalcross.util.UnitsConverter;

public class InfoModbvusViewContainer extends Container {
    private String sTitle;
    private String sInfo;
    private Label lTitle;
    private Label lInfo;
    private int color;

    public InfoModbvusViewContainer(String sTitle, String sInfo, int color) {
        this.sTitle = sTitle;
        this.sInfo = sInfo;
        this.color = color;
    }

    public void initUI() {
        // setBorderStyle(BORDER_ROUNDED);
        borderColor = color;
        setBackColor(color);

        lTitle = new Label(sTitle);
        lTitle.setFont(Fonts.MontserratRegular12);

        lInfo = new Label(sInfo);
        lInfo.setFont(Fonts.MontserratSemiBold12);

        add(lTitle, CENTER, TOP + MaterialConstants.DP4H);
        add(lInfo, CENTER, AFTER);

    }

    @Override
    public void onPaint(Graphics g) {
        g.backColor = backColor;
        g.fillRoundRect(0, 0, getWidth(), getHeight(), UnitsConverter.toPixels(DP + 8));
    }
}