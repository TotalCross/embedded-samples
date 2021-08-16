package com.totalcross.ui.components;

import totalcross.ui.Control;
import totalcross.ui.gfx.Graphics;

public class CircleProgress extends Control {
	private int thickness;
	private int maxValue;
	private int value;
	private String text;
	private int textColor;
	private int ix, iy;// icon's x and y.
	private int unfilledColor;
	private int filledColor;

	public CircleProgress(int thickness, int maxValue, int value, String text) {
		this.thickness = thickness;
		if (maxValue < 0) {
			this.maxValue = 100;
		} else {
			this.maxValue = maxValue;
		}
		if (value < 0) {
			this.value = 0;
		} else if (value > maxValue) {
			this.value = maxValue;
		} else {
			this.value = value;
		}
		if (text != null) {
			this.text = text;
		}
	}

	@Override
	public void onPaint(Graphics g) {
		int xc = x + width / 2;
		int yc = y + height / 2;
		int outsideCircleRadius = width / 2;
		int insideCircleRadius = outsideCircleRadius - thickness;
		g.backColor = unfilledColor;
		g.fillCircle(xc, yc, outsideCircleRadius - 1);
		if (value != maxValue) {
			g.foreColor = filledColor;
			g.backColor = filledColor;
			g.fillPie(xc, yc, outsideCircleRadius - 1, 90 - (double) value / maxValue * 360, 90);
		} else {
			g.foreColor = filledColor;
			g.backColor = filledColor;
			g.fillCircle(xc, yc, outsideCircleRadius - 1);
		}
		g.foreColor = g.backColor = this.backColor;
		g.fillCircle(xc, yc, insideCircleRadius - 1);
		if (text != null) {
			g.setFont(this.font);
			ix = (width - this.font.fm.stringWidth(text)) / 2;
			iy = (height - this.font.fm.height) / 2;
			g.foreColor = textColor;
			g.drawText(text, ix, iy);
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

	public int getTextColor() {
		return textColor;
	}

	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}
}