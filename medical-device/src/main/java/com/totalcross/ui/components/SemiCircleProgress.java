package com.totalcross.ui.components;

import totalcross.ui.Control;
import totalcross.ui.gfx.Graphics;

public class SemiCircleProgress extends Control{
    public static final byte LEFT = 0x00;
    public static final byte RIGHT = 0x01;
    private int thickness;
	private int maxValue;
	private int value;
	private int unfilledColor;
    private int filledColor;
    private boolean useGradient = false;
    private int gradientBack;
    private int gradientFore;
    private byte type;

    public SemiCircleProgress(int thickness, int maxValue, int value, byte type) {
        this.thickness = thickness;
        this.maxValue = maxValue;
        this.value = value;
        this.type = type;
    }

    @Override
    public void onPaint(Graphics g) {
        if(type == LEFT) {
            g.backColor = g.foreColor = filledColor;
            g.fillCircle(width -1, height/2, width -1);
            g.backColor = g.foreColor = unfilledColor;
            g.fillPie(width - 1, height/2, width - 1, 90, 90 + (1 - 1.0*value/maxValue)*180);
            if(useGradient) {
                g.backColor = gradientBack;
                g.foreColor = gradientFore;
                g.fillPieGradient(width - 1, height/2, width - 1 - thickness, 90, 270);
            } else {
                g.foreColor = g.backColor = this.backColor;
                g.fillPieGradient(width - 1, height/2, width - 1 - thickness, 90, 270);
            }
        } else {
            g.backColor = g.foreColor = unfilledColor;
            g.fillCircle(0, height/2, width -1);
            g.backColor = g.foreColor = filledColor;
            g.fillPie(0, height/2, width - 1, 270, 270 + 1.0*value/maxValue*180);
            if(useGradient) {
                g.backColor = gradientBack;
                g.foreColor = gradientFore;
                g.fillPieGradient(0, height/2, width - 1 - thickness, 270, 90);
            } else {
                g.foreColor = g.backColor = this.backColor;
                g.fillPieGradient(0, height/2, width - 1 - thickness, 270, 90);
            }
        }
    }

    public int getUnfilledColor() {
        return unfilledColor;
    }

    public void setUnfilledColor(int unfilledColor) {
        this.unfilledColor = unfilledColor;
    }

    public int getFilledColor() {
        return filledColor;
    }

    public void setFilledColor(int filledColor) {
        this.filledColor = filledColor;
    }

    public int getGradientBack() {
        return gradientBack;
    }

    public void setGradientBack(int gradientBack) {
        this.gradientBack = gradientBack;
    }

    public int getGradientFore() {
        return gradientFore;
    }

    public void setGradientFore(int gradientFore) {
        this.gradientFore = gradientFore;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isUseGradient() {
        return useGradient;
    }

    public void setUseGradient(boolean useGradient) {
        this.useGradient = useGradient;
    }
}