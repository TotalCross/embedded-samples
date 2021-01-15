package com.totalcross.ui.components;

import com.totalcross.util.Positioning;

import totalcross.ui.Control;
import totalcross.ui.gfx.Graphics;

public class ControlPanel extends Control {
    private int unfilledColor;
    private int filledColor;
    private int maxValue;
    private int value;
    private int textColor;

    public ControlPanel(int maxValue, int value) {
        this.maxValue = maxValue;
        this.value = value;
    }

    @Override
    public void onPaint(Graphics g) {
        g.backColor = unfilledColor;
        g.fillRoundRect(0, 0, width - 1, height - 1, Positioning.getWidthDP(20));
        g.backColor = filledColor;
        g.fillRoundRect(0, (int) (height - 1.0 * value / maxValue * height - 1), width - 1,
                (int) (1.0 * value / maxValue * height), Positioning.getWidthDP(20));
        g.foreColor = textColor;
        g.setFont(this.font.adjustedBy(-10));
        g.drawText("+", (width - fm.stringWidth("+")) / 2, Positioning.getHeightDP(12));
        g.drawText("-", (width - fm.stringWidth("-")) / 2, height - Positioning.getHeightDP(20) - 1);
        g.setFont(this.font);
        g.drawText(value + " MIN.", (width - fm.stringWidth(value + " MIN.")) / 2, (height - fm.height) / 2);
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

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}