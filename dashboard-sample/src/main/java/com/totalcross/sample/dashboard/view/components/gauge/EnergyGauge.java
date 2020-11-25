package com.totalcross.sample.dashboard.view.components.gauge;

import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Coord;
import totalcross.ui.gfx.Graphics;
import totalcross.util.UnitsConverter;

public class EnergyGauge extends Gauge {
    public EnergyGauge(int min, int max, int angleRange) {
        super(min, max, angleRange);
        valueSuffix = "GB";
    }

    @Override
    public int getPreferredHeight() {
        int remainderAngle = (angleRange > 180 ? (angleRange - 180) / 2 : 0);
        return (int) (width / 2 + width * Math.sin(remainderAngle * Math.PI / 180));
    }

    @Override
    protected void onDrawSections(Graphics graphics, int radius, int startAngle, int endAngle) {
        graphics.backColor = graphics.foreColor = 0;
        graphics.foreColor = Color.WHITE;
        int thickness = (int) (radius * 0.25);
        int delta = (int) getSectionAngle(UnitsConverter.toPixels(8 + DP), radius - thickness);

        int currentSection = 0;
        int currentSum = 0;
        int color1 = colors[0], color2 = colors[0];
        int startColorChangeAngle = 0, endColorChangeAngle = 0;
        int index = 0;
        boolean colorChanged = false;
        double[][] intervals = getColorsInterval();
        int valueColor = foreColor;
        for (int i = startAngle; i >= endAngle; i -= delta) {
            double progress = (i - startAngle) / (double) (endAngle - startAngle);
            if (progress > intervals[index][1]) {
                currentSection++;
                index++;
                if (index == intervals.length - 1) {
                    color1 = color2 = colors[sectionCount - 1];
                } else {
                    color1 = colors[index - 1];
                    color2 = colors[index];
                }
            }

            double factor = (progress - intervals[index][0]) / (intervals[index][1] - intervals[index][0]);
            graphics.foreColor = graphics.backColor = getMarkColor(factor, color1, color2);

            if (i <= getAngle()) {
                if (!colorChanged) {
                    colorChanged = true;
                    if (graphics.backColor != Color.getCursorColor(backColor))
                        valueColor = graphics.foreColor;
                }
                graphics.backColor = graphics.foreColor = Color.getCursorColor(backColor);
            }

            Coord innerCoord = getCoordEndVectorWith(centerX, centerY, radius - thickness, i);
            Coord extCoord = getCoordEndVectorWith(centerX, centerY, radius, i);
            int markWidth = UnitsConverter.toPixels(DP + 2);
            int deltaX = (int) (markWidth * Math.cos(180 - i));
            int deltaY = (int) (markWidth * Math.sin(180 - i));
            graphics.drawThickLine(extCoord.x, extCoord.y, innerCoord.x, innerCoord.y, UnitsConverter.toPixels(DP + 3));
            // graphics.fillPolygon(
            // new int[] {innerCoord.x, extCoord.x, innerCoord.x - deltaX, extCoord.x -
            // deltaX},
            // new int[] {innerCoord.y, extCoord.y, innerCoord.y - deltaY, extCoord.y -
            // deltaY},
            // 4);
        }
        onDisplayValue2(graphics, value + "", valuePrefix, valueSuffix, radius, startAngle, endAngle, valueColor);
    }

    @Override
    protected void onDrawTicks(Graphics g, int majorTicksInterval, int minorTicksInterval, int radius) {

    }

    @Override
    protected void drawArrow(Graphics g, int radius, int startAngle, int endAngle) {

    }

    @Override
    protected void onDisplayValue(Graphics g, String value, String preffix, String suffix, int radius, int startAngle,
            int endAngle) {

    }

    protected void onDisplayValue2(Graphics g, String value, String preffix, String suffix, int radius, int startAngle,
            int endAngle, int valueColor) {
        Font f = getFont().getFont(getMostSuitableFontSize((int) (0.33 * width)));
        String resultingValue = preffix + value + suffix;
        g.setFont(f);
        int tx = centerX - f.fm.stringWidth(resultingValue) / 2;
        int ty = centerY - (angleRange <= 180 ? f.fm.height : f.fm.height / 2);
        g.backColor = g.foreColor = backColor;
        g.fillRect(tx, ty, f.fm.stringWidth(resultingValue), f.fm.height);
        g.foreColor = valueColor;
        g.drawText(resultingValue, tx, ty);
    }

    private double[][] getColorsInterval() {
        double[][] intervals = new double[sectionCount + 1][2];
        int currentSum = 0;
        int index = 0;
        intervals[0][0] = 0;
        currentSum = sections[index] / 2;
        intervals[0][1] = currentSum / (double) sum;
        for (int i = 1; i < sectionCount; i++) {
            intervals[i][0] = currentSum / (double) sum;
            currentSum += sections[index] / 2 + sections[index + 1] / 2;
            intervals[i][1] = currentSum / (double) sum;
        }
        intervals[sectionCount][0] = currentSum / (double) sum;
        intervals[sectionCount][1] = 1.0;
        return intervals;
    }

    private int getMarkColor(double factor, int begin, int end) {
        if (begin == end)
            return begin;
        int r1 = (begin >> 16) & 0xFF;
        int g1 = (begin >> 8) & 0xFF;
        int b1 = (begin) & 0xFF;

        int r2 = (end >> 16) & 0xFF;
        int g2 = (end >> 8) & 0xFF;
        int b2 = (end) & 0xFF;

        int r = (int) (factor * (r2 - r1)) + r1;
        int g = (int) (factor * (g2 - g1)) + g1;
        int b = (int) (factor * (b2 - b1)) + b1;

        return Color.getRGB(r, g, b);
    }

}
