package com.totalcross.sample.dashboard.view.components;

import totalcross.sys.Vm;
import totalcross.ui.Control;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Graphics;
import totalcross.util.UnitsConverter;

public class Graphic extends Control {

    private int yMax;
    private int divisions;
    private int points;
    private int intervalBarsColor;
    private int sideTextColor;
    private int lineAndPointsColor;
    int[] pointsX;
    int[] pointsY;
    int[] values;

    public Graphic(int yMax, int divisions, int points) {
        this.yMax = yMax;
        this.divisions = divisions;
        this.points = points;
        pointsX = new int[points];
        for (int i = 0; i < points; i++) {
            pointsX[i] = i;
        }
        pointsY = new int[points];
    }

    @Override
    public void onPaint(Graphics g) {
        int graphSpace = height - font.fm.height;
        int[] graphY = new int[this.divisions + 1];
        graphY[0] = font.fm.height / 2;
        int graphX = width / 10;
        String sideText;
        int textX;
        int sideValue = yMax;
        int oldBackColor = g.backColor;
        int oldForeColor = g.foreColor;
        for (int i = 0; i < pointsY.length; i++) {
            pointsY[i] = (int) ((1 - 1.0 * this.values[i] / yMax) * graphSpace) + font.fm.height / 2;
        }
        for (int i = 0; i < this.divisions; i++) {
            graphY[i + 1] = graphY[i] + graphSpace / this.divisions;
        }
        int xSpace = width * 9 / 10 / (this.points - 1);
        int[] gradientPointsX = new int[pointsX.length + 2];
        int[] gradientPointsY = new int[pointsY.length + 2];
        int inc = 0;
        for (; inc < pointsX.length; inc++) {
            gradientPointsX[inc] = width / 10 + pointsX[inc] * xSpace;
            gradientPointsY[inc] = pointsY[inc];
        }
        gradientPointsX[inc] = width / 10 + pointsX[pointsX.length - 1] * xSpace;
        gradientPointsY[inc] = graphY[graphY.length - 1];
        inc++;
        gradientPointsX[inc] = width / 10 + pointsX[0] * xSpace;
        gradientPointsY[inc] = graphY[graphY.length - 1];
        g.backColor = Color.getRGB("630A71");
        g.foreColor = Color.getRGB("D08CFC");
        g.alpha = 0x70 << 24;
        g.fillPolygonGradient(gradientPointsX, gradientPointsY, gradientPointsX.length);
        for (int i = 0; i < this.divisions; i++) {
            g.foreColor = this.intervalBarsColor;
            g.drawLine(graphX, graphY[i], width, graphY[i]);
            sideText = String.valueOf(sideValue);
            textX = width / 20 - font.fm.stringWidth(sideText) / 2;
            sideValue -= yMax / divisions;
            g.foreColor = this.sideTextColor;
            g.drawText(sideText, textX, graphY[i] - font.fm.height / 2);
        }
        g.foreColor = this.intervalBarsColor;
        g.drawLine(graphX, graphY[graphY.length - 1], width, graphY[graphY.length - 1]);
        sideText = String.valueOf(sideValue);
        textX = width / 20 - font.fm.stringWidth(sideText) / 2;
        g.foreColor = this.sideTextColor;
        g.drawText(sideText, textX, graphY[graphY.length - 1] - font.fm.height / 2);

        for (int i = 1; i < this.points; i++) {
            g.foreColor = g.backColor = this.lineAndPointsColor;
            g.drawLine(width / 10 + pointsX[i - 1] * xSpace, pointsY[i - 1], width / 10 + pointsX[i] * xSpace,
                    pointsY[i]);
            g.fillCircle(width / 10 + pointsX[i] * xSpace, pointsY[i], UnitsConverter.toPixels(DP + 3));
        }
        g.backColor = oldBackColor;
        g.foreColor = oldForeColor;
    }

    public void setIntervalBarsColor(int intervalBarsColor) {
        this.intervalBarsColor = intervalBarsColor;
    }

    public void setSideTextColor(int sideTextColor) {
        this.sideTextColor = sideTextColor;
    }

    public void setLineAndPointsColor(int lineAndPointsColor) {
        this.lineAndPointsColor = lineAndPointsColor;
    }

    public void setAnimation(boolean animate, int ms) {

    }

    public void setValues(int[] values) {
        this.values = values;
    }
}