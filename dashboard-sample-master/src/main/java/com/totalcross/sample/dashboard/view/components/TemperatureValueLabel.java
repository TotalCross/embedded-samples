package com.totalcross.sample.dashboard.view.components;

import totalcross.ui.Control;
import totalcross.ui.gfx.Graphics;
import totalcross.util.UnitsConverter;

public class TemperatureValueLabel extends Control {

    String text;

    public TemperatureValueLabel(int value) {
        this.text = value + "° C";
    }

    @Override
    public void onPaint(Graphics g) {
        g.backColor = backColor;
        g.foreColor = foreColor;
        g.fillRoundRect(0, 0, width, height, UnitsConverter.toPixels(DP + 9));
        g.drawText(text, (width - font.fm.stringWidth(text)) / 2, height / 2 - font.fm.height / 2 - font.fm.descent);
    }

    public void setValue(int value) {
        this.text = value + "° C";
        repaint();
    }
}