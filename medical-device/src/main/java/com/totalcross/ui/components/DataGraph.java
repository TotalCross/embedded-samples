package com.totalcross.ui.components;

import com.totalcross.util.Positioning;

import totalcross.ui.Control;
import totalcross.ui.gfx.Graphics;
import totalcross.util.UnitsConverter;

public class DataGraph extends Control {

    private int color;
    private int[] values = new int[9];
    private int[] valuesX = new int[9];
    private int[] valuesY = new int[9];
    private int minValue;
    private int maxValue;
    private final int step = Positioning.getWidthDP(323)/8;
    private final int graphHeight = Positioning.getHeightDP(123);

    public DataGraph(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void onPaint(Graphics g) {
        // g.fillRect(0, 0, width, height);
        g.backColor = g.foreColor = this.color;
        g.drawText(""+maxValue, 0, 0);
        g.drawText(""+minValue, 0, Positioning.getHeightDP(67) - fm.height/2);
        g.drawLine(width - Positioning.getWidthDP(323), Positioning.getHeightDP(10), width, Positioning.getHeightDP(10));
        g.drawLine(width - Positioning.getWidthDP(323), Positioning.getHeightDP(67), width, Positioning.getHeightDP(67));
        g.drawLine(width - Positioning.getWidthDP(323), Positioning.getHeightDP(133), width, Positioning.getHeightDP(133));
        g.drawLine(width - Positioning.getWidthDP(313), 0, width - Positioning.getWidthDP(313), Positioning.getHeightDP(143));
        g.drawLine(width - Positioning.getWidthDP(313 - 75), 0, width - Positioning.getWidthDP(313 - 75), Positioning.getHeightDP(143));
        g.drawLine(width - Positioning.getWidthDP(313 - 150), 0, width - Positioning.getWidthDP(313 - 150), Positioning.getHeightDP(143));
        g.drawLine(width - Positioning.getWidthDP(313 - 225), 0, width - Positioning.getWidthDP(313 - 225), Positioning.getHeightDP(143));
        g.drawLine(width - Positioning.getWidthDP(313 - 300), 0, width - Positioning.getWidthDP(313 - 300), Positioning.getHeightDP(143));

        for(int i = 0; i < values.length; i++) {
            valuesX[i] = width - Positioning.getWidthDP(323) + i*step;
            valuesY[i] = (int)(graphHeight - 1.0*values[i]/maxValue*graphHeight);
        }
        for(int i = 0; i < values.length; i++) {
            if(i + 1 < values.length) {
                g.foreColor = 0xffffff;
                g.drawThickLine(valuesX[i], valuesY[i], valuesX[i+1], valuesY[i+1], UnitsConverter.toPixels(DP + 5));
            }
        }
        
    }

    public void addValues(int[] values) {
        this.values = values;
    }

    public void addValue(int value) {
        for (int i = 1; i < values.length; i++) {
            if(i + 1 < values.length) {
                values[i] = values[i + 1];
            }
        }
        values[values.length - 1] = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}