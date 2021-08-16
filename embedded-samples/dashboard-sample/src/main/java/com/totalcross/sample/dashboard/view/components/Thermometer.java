package com.totalcross.sample.dashboard.view.components;

import com.totalcross.sample.dashboard.util.MaterialConstants;

import totalcross.sys.Settings;
import totalcross.sys.Vm;
import totalcross.ui.Control;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Graphics;
import totalcross.util.UnitsConverter;

public class Thermometer extends Control {

    int minValue;
    int maxValue;
    int value;
    int steps;

    public Thermometer(int minValue, int maxValue, int steps) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.steps = steps;
    }

    @Override
    public void onPaint(Graphics g) {
        // Thermometer
        height = height - 1;
        int radius = UnitsConverter.toPixels(DP + 14);
        g.backColor = Color.getRGB("CEC4C4");
        g.fillCircle(width / 2, radius, radius);
        g.backColor = Color.getRGB("FFFFFF");
        g.fillCircle(width / 2, radius, radius - MaterialConstants.DP1W);
        int thermometerHeight = height - width - MaterialConstants.DP5W;
        g.backColor = Color.getRGB("CEC4C4");
        g.fillRect(width / 2 - radius, radius, radius * 2, thermometerHeight);
        g.fillCircle(width / 2, height - width / 2, width / 2);
        g.backColor = Color.getRGB("FFFFFF");
        g.fillRect(width / 2 - radius + MaterialConstants.DP1W, radius,
                radius * 2 - MaterialConstants.DP2W, thermometerHeight);
        g.fillCircle(width / 2, height - width / 2, width / 2 - MaterialConstants.DP1W);
        // Vermelho
        // g.backColor = Color.getRGB("FF4A4A");
        // Azul
        g.backColor = Color.getRGB("1E90FF");
        g.fillCircle(width / 2, height - width / 2, width / 2 - MaterialConstants.DP8W);

        int valueStartPoint = height - width - MaterialConstants.DP2W;
        int majorDivisions = 10;
        int minorDivisions = 5;
        int pointsHeight = valueStartPoint;
        int incr = pointsHeight / (majorDivisions * minorDivisions);
        int pointY = radius;
        int pointsXStart = MaterialConstants.DP39W;
        int pointsXEnd = width / 2 + radius;
        int drawValue = maxValue;
        String valueText = "" + drawValue;
        g.foreColor = Color.getRGB("CEC4C4");
        for (int i = 0, j = 0; i <= majorDivisions; j = (j + 1) % minorDivisions) {
            if (j == 0) {
                g.drawThickLine(pointsXStart, pointY, pointsXEnd, pointY, MaterialConstants.DP2H);
                g.drawText(valueText, pointsXEnd + MaterialConstants.DP2W, pointY - font.fm.height / 2);
                i++;
                drawValue = maxValue - (int) (1.0 * i / majorDivisions * maxValue);
                valueText = "" + drawValue;
            } else {
                g.drawThickLine(pointsXStart, pointY, pointsXEnd - MaterialConstants.DP2W, pointY, MaterialConstants.DP1H);
            }
            pointY += incr;
        }

        // Vermelho
        // g.backColor = Color.getRGB("FF4A4A");
        // Azul
        g.backColor = Color.getRGB("1E90FF");
        int barBottom = height - width;
        int barTop = (int) ((1 - 1.0 * value / maxValue) * (barBottom - radius)) + MaterialConstants.DP5H
                + radius;
        g.fillRect(MaterialConstants.DP25W, barTop, MaterialConstants.DP10W,
                barBottom - barTop + MaterialConstants.DP12H);
        g.fillCircle(MaterialConstants.DP30W, barTop, MaterialConstants.DP5W);
        height = height + 1;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
        repaint();
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
}