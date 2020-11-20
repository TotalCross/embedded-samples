package com.totalcross.sample.dashboard.view.components.gauge;

//package totalcross.ui.chart;

import totalcross.ui.Control;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Coord;
import totalcross.ui.gfx.Graphics;
import totalcross.util.UnitsConverter;

public class Gauge extends Control {

    protected int prefferedHeight;
    protected int sectionCount;
    protected int sum = 0;
    protected int centerX, centerY;
    private int startAngle, endAngle;
    protected int[] sections = new int[255];
    protected int[] colors = new int[255];
    protected int angleRange;
    protected double markWidthScale = 0.15;
    // int valuesCount;
    protected int value;
    protected Label valueLabel;
    protected int min;
    protected int max;
    protected String valuePrefix = "";
    protected String valueSuffix = "";
    protected Font valueLabelFont = Font.getFont(true, Font.BIG_SIZE);
    protected Font ticksLabelFont = Font.getFont(Font.NORMAL_SIZE);
    protected boolean showTicks = true;
    protected boolean showTickValues;
    private int majorTicksInterval = 20;
    private int minorTicksInterval = 5;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public Gauge() {
        this(0, 180, 180);
    }

    public Gauge(int minValue, int maxValue) {
        this(minValue, maxValue, 180);
    }

    public Gauge(int angleRange) {
        this(0, angleRange, angleRange);
    }

    public Gauge(int minValue, int maxValue, int angleRange) {
        this.min = minValue;
        this.max = maxValue;
        if (angleRange < 0)
            this.angleRange = 0;
        else if (angleRange > 360)
            this.angleRange = 360;
        else {
            this.angleRange = angleRange;
        }
        valueLabel = new Label(valuePrefix + value + valueSuffix);
        this.transparentBackground = true;
    }

    public Gauge section(int value, int color) {
        sections[sectionCount] = value;
        colors[sectionCount++] = color;
        sum += value;

        return this;
    }

    public Gauge setValue(int value) {
        this.value = value;
        return this;
    }

    public Gauge setMajorTickInterval(int interval) {
        this.majorTicksInterval = interval;
        return this;
    }

    public Gauge setMinorTickInterval(int interval) {
        this.minorTicksInterval = interval;
        return this;
    }

    public Gauge setMarkWidthScale(double markWidthScale) {
        if (markWidthScale < 0)
            this.markWidthScale = 0;
        if (markWidthScale > 1)
            this.markWidthScale = 1;
        else
            this.markWidthScale = markWidthScale;
        return this;
    }

    public Gauge setValueSuffix(String suffix) {
        this.valueSuffix = suffix;
        return this;
    }

    public Gauge setValuePrefix(String prefix) {
        this.valuePrefix = prefix;
        return this;
    }

    public Gauge setValueLabelFont(Font font) {
        this.valueLabelFont = font;
        return this;
    }

    public Gauge setTickFont(Font font) {
        this.ticksLabelFont = font;
        return this;
    }

    public Gauge showTickValues(boolean showTickValues) {
        this.showTickValues = showTickValues;
        return this;
    }

    @Override
    public int getPreferredHeight() {
        return prefferedHeight;
    }

    @Override
    public void onPaint(Graphics g) {
        g.backColor = g.foreColor = backColor;
        g.fillRect(0, 0, width, height);
        int remainder = (angleRange - 180) / 2;
        startAngle = 180 + remainder;
        endAngle = 0 - remainder;

        int radius = (int) (this.width * 0.49f);
        if (showTicks)
            radius = radius - fm.stringWidth("" + min) - fm.stringWidth("" + max);
        final int maxHeight = height - 1;
        centerY = angleRange <= 180 ? maxHeight
                : maxHeight - (int) (Math.sin(((angleRange - 180) / 2.0) * Math.PI / 180) * (double) radius); // Center
                                                                                                              // goes up
                                                                                                              // if
                                                                                                              // angleRange
                                                                                                              // > 180

        if (showTicks)
            centerY = centerY - fm.height - 2; // margin

        centerX = width / 2;
        int start = (180 - angleRange) / 2;
        int lastStart = start;
        g.foreColor = getForeColor();

        onDrawSections(g, radius, startAngle, endAngle);
        g.setFont(ticksLabelFont);

        int maxY = maxHeight, minY;

        // if (showTickValues) {
        // getTickLabelPlacement(""+max, start+1, radius, 2, out);
        // g.drawText(""+max, out.x, out.y);
        // maxY = out.y + ticksLabelFont.fm.height;
        // }

        g.foreColor = g.backColor = this.backColor;
        g.fillPie(centerX, centerY, (int) (radius * (1 - markWidthScale)), start, lastStart);

        onDisplayValue(g, value + "", valuePrefix, valueSuffix, radius, startAngle, endAngle);

        if (showTicks)
            onDrawTicks(g, majorTicksInterval, minorTicksInterval, radius);
        drawArrow(g, radius, startAngle, endAngle);
    }

    protected void getTickLabelPlacement(String label, int angle, int radius, int margin, Coord out) {

        out.x = centerX + (int) ((double) (radius + margin) * Math.cos(angle * Math.PI / 180));
        out.y = centerY - (int) ((double) (radius + margin) * Math.sin(angle * Math.PI / 180));

        if (angle == 0) {
            out.y = out.y - fm.height / 2;
        } else if (angle == 90) {
            out.y = out.y - fm.height;
            out.x = out.x - fm.stringWidth(label) / 2;
        } else if (angle == 180) {
            out.y = out.y - fm.height / 2;
            out.x = out.x - fm.stringWidth(label);
        } else if (angle > 0 && angle < 90) { // 1st quadrant
            out.y = out.y - fm.height;
        } else if (angle > 90 && angle < 180) { // 2nd quadrant
            out.y = out.y - fm.height;
            out.x = out.x - fm.stringWidth(label);
        } else if (angle > 180 && angle <= 270) { // 3rd quadrant
            out.x = out.x - fm.stringWidth(label);
        }
    }

    protected void drawArrow(Graphics g, int radius, int startAngle, int endAngle) {
        Coord out = new Coord();
        int arrowLength = (int) (radius * (1 - markWidthScale) - 5);
        int ptrCircleRadius = (int) (arrowLength * 0.20);
        g.fillCircle(centerX, centerY, ptrCircleRadius);
        double angle = (double) (value - min) / (double) (max - min); // normalized in function of min and max value
        angle = startAngle - angle * (startAngle - endAngle);

        out.x = (int) (Math.cos(angle * Math.PI / 180) * arrowLength + centerX); // centerX + radius = originX
        out.y = (int) (-Math.sin(angle * Math.PI / 180) * arrowLength + (centerY)); // centerY = originY
        // g.drawThickLine(centerX, centerY, out.x, out.y, 3);
        double beta = angle - 180;
        double delta = Math.toDegrees(Math.atan(ptrCircleRadius / 2.0 / (double) arrowLength));
        g.foreColor = g.backColor = Color.BLACK;

        g.fillPie(out.x, out.y, arrowLength, beta, (beta + delta));
        g.fillPie(out.x, out.y, arrowLength, beta - delta, beta);
        g.fillCircle(centerX, centerY, ptrCircleRadius);
    }

    protected void onDrawTicks(Graphics g, int majorTicksInterval, int minorTicksInterval, int radius) {
        int start = startAngle;

        int incremntSum = 0;
        int minorTickThickness = UnitsConverter.toPixels(DP + 1);
        g.foreColor = foreColor;
        // draw thicks from end to start
        for (int i = 0; i <= max; i += minorTicksInterval) {
            double angle = (double) (i - min) / (double) (max - min); // normalized in function of min and max value
            angle = startAngle - (angle) * (startAngle - endAngle);
            Coord coord1 = getCoordEndVectorWith(centerX, centerY, radius, (int) angle);
            Coord coord2 = getCoordEndVectorWith(centerX, centerY, radius - UnitsConverter.toPixels(DP + 4),
                    (int) angle);
            if (minorTickThickness == 1) {
                g.drawLine(coord1.x, coord1.y, coord2.x, coord2.y);
            } else {
                g.drawThickLine(coord1.x, coord1.y, coord2.x, coord2.y, UnitsConverter.toPixels(DP + 1));
            }
        }

        for (int i = 0; i <= max; i += majorTicksInterval) {
            double angle = (double) (i - min) / (double) (max - min); // normalized in function of min and max value
            angle = startAngle - (angle) * (startAngle - endAngle);
            Coord coord1 = getCoordEndVectorWith(centerX, centerY, radius, (int) angle);
            Coord coord2 = getCoordEndVectorWith(centerX, centerY, radius - UnitsConverter.toPixels(DP + 8),
                    (int) angle);
            g.drawThickLine(coord1.x, coord1.y, coord2.x, coord2.y, UnitsConverter.toPixels(DP + 2));
        }
    }

    protected double getSectionAngle(int arcSize, int radius) {
        return (180.0 * arcSize) / (Math.PI * radius);
    }

    protected Coord getCoordEndVectorWith(int centerX, int centerY, int radius, int angle) {
        Coord result = new Coord();
        result.x = centerX + (int) (Math.cos(Math.toRadians(angle)) * radius);
        result.y = centerY - (int) (Math.sin(Math.toRadians(angle)) * radius);
        return result;
    }

    protected double getAngle() {
        double angle = (double) (value - min) / (double) (max - min); // normalized in function of min and max value
        return startAngle - (angle) * (startAngle - endAngle);
    }

    protected void onDrawSections(Graphics g, int radius, int startAngle, int endAngle) {
        int start = (180 - angleRange) / 2;
        int lastStart = start;
        int incremntSum = 0;
        Coord out = new Coord();
        // Marks are mounted backwards
        for (int i = sectionCount - 1; i >= 0; i--) {
            g.backColor = colors[i];
            g.foreColor = colors[i];
            final int sectionSize = (int) (((double) sections[i] / sum) * angleRange);
            g.fillPie(centerX, centerY, radius, lastStart, lastStart + sectionSize);
            lastStart += sectionSize;
        }
        g.backColor = g.foreColor = backColor;
        g.fillCircle(centerX, centerY, (int) (radius * 0.90));
    }

    protected void onDisplayValue(Graphics g, String value, String preffix, String suffix, int radius, int startAngle,
            int endAngle) {
        // Draw value Label
        Font f = valueLabelFont.getFont(getMostSuitableFontSize((int) (0.40 * width)));
        String valueString = preffix + "" + value + "" + suffix;
        int maxY = height - 1, minY;
        g.foreColor = Color.BLACK;

        g.setFont(f);
        int remainderAngle = angleRange / 2 - 90;
        int tx = centerX - (f.fm.stringWidth(valuePrefix + value + valueSuffix) / 2);
        int ty = centerY + (int) (radius * (Math.sin(Math.toRadians(remainderAngle))) - f.fm.height / 2);
        g.foreColor = g.backColor = backColor;
        g.fillRect(centerX - (f.fm.stringWidth(max + "" + valuePrefix + valueSuffix) / 2), ty,
                f.fm.stringWidth(max + "" + valuePrefix + valueSuffix), f.fm.height);
        g.foreColor = Color.WHITE;
        g.drawText(valueString, tx, ty);

    }

    protected int getMostSuitableFontSize(int availableArea) {
        String minValueStr = valuePrefix + min + valueSuffix;
        String maxValueStr = valueSuffix + max + valueSuffix;

        int size = 30;
        Font font = getFont().getFont(30);
        String larggestString = font.fm.stringWidth(minValueStr) > font.fm.stringWidth(maxValueStr) ? minValueStr
                : maxValueStr;
        int strWidth = font.fm.stringWidth(larggestString);
        while (strWidth > availableArea && size > 6) { // resize string according to available area
            font = font.getFont(--size);
            strWidth = font.fm.stringWidth(larggestString);
        }

        return size;
    }

}