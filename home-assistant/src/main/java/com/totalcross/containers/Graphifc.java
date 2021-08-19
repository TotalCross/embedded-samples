package com.totalcross.containers;
import java.util.ArrayList;
import java.util.List;

import totalcross.sys.Convert;
import totalcross.ui.Control;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Graphics;
import totalcross.ui.gfx.Rect;
public class Graphifc <X extends Comparable<X>, Y extends Number> extends Control {

    Series<X, Y>[] series;
    int yMin = 0;
    int yMax;
    int yStep = 1000 * 1000;
    int yMaxValue;

    final int borderGap = 10;
    final int xTextHeight = 52;
    final int yGap = 20;
    int yTextLen;
    int yCount;;

    Rect r;
    int widthX;

    private List<Integer> listToDraw = new ArrayList<>();

    @SafeVarargs
    public Graphifc(Series<X, Y>... series) {
        reset();
        listToDraw.add(0);
        changeSeries(series);
    }

    public void reset() {
        listToDraw.clear();
    }

    @Override
    protected void onBoundsChanged(boolean screenChanged) {
        r = new Rect(borderGap, borderGap, width - (borderGap * 2), height - (borderGap * 2));
        widthX = r.width - 1 - yTextLen - yGap;
    }

    @Override
    public void onPaint(Graphics g) {
        final int BORDER_COLOR = Color.interpolateA(0x869699, this.backColor, 65);

        g.foreColor = BORDER_COLOR;
        g.backColor = this.backColor;
        g.fillRoundRect(r.x, r.y, r.width, r.height, 10);

        final int yPart = (r.height - xTextHeight - 1) / (yCount + 1);

        for (int i = 0; i < yCount; i++) {
            final String s = Integer.toString(i * yStep);
            final int yPos = r.height - xTextHeight - 1 - (i + 1) * yPart;
            g.foreColor = BORDER_COLOR;
            g.drawLine(r.x, yPos, r.width - yTextLen - yGap, yPos);

            g.foreColor = 0xc5cbce;
            g.drawLine(r.width - 1 - yTextLen, yPos, r.width - 1 - yTextLen - yGap, yPos);
            g.drawText(Convert.toCurrencyString(s, 0), r.width - 1 - yTextLen, yPos - this.fmH / 2);
        }
        g.foreColor = 0xc5cbce;
        g.drawLine(r.width - 1 - yTextLen - yGap, r.y + 1, r.width - 1 - yTextLen - yGap, r.height - xTextHeight - 1);
        
        // x axis
        g.drawLine(r.x + 1, r.height - xTextHeight - 1, r.width - 1 - yTextLen - yGap, r.height - xTextHeight - 1);
        
        for (int i = 0; i < series.length; i++) {
            final Series<X, Y> series2 = series[i];
            g.foreColor = 0xc5cbce;
            final List<Data<X, Y>> data = series2.data;
            final int nPoints = listToDraw.size();
            if (nPoints > 0) {
                final int part = widthX / nPoints;
                final int[] xPoints = new int[nPoints];
                final int[] yPoints = new int[nPoints];

                final int h = r.height - xTextHeight - 1 - r.y - 1;
                for (int j = 0; j < nPoints; j++) {
                    final Data<X, Y> series = data.get(listToDraw.get(j));

                    // x
                    final int xPos = r.x + 1 + j * part;

                    final String s = series.x.toString();
                    if (s != null) {
                        g.foreColor = 0xc5cbce;
                        g.drawLine(xPos, r.height - xTextHeight - 1, xPos, r.height - (xTextHeight * 3 / 4) - 1);
                        g.drawText(s, xPos - (this.fm.stringWidth(s) / 2), r.height - (xTextHeight * 3 / 4) - 1);
                        g.foreColor = BORDER_COLOR;
                        g.drawLine(xPos, r.y + 1, xPos, r.height - xTextHeight - 1);
                    }

                    final double percentage = 1.0 * series.y.intValue() / (yMax - yMin + yStep);
                    final int yPos = r.height - xTextHeight - 1 - yPart - (int) Math.round((h * percentage));

                    xPoints[j] = xPos;
                    yPoints[j] = yPos;
                }
                g.foreColor = series2.color;
                g.drawDots(r.x + 1, yPoints[yPoints.length - 1], widthX, yPoints[yPoints.length - 1]);
                g.drawPolyline(xPoints, yPoints, nPoints);

                // paint more pixels around to make the line thicker
                for (int j = 0; j < nPoints; j++) {
                    xPoints[j] += 1;
                }
                g.drawPolyline(xPoints, yPoints, nPoints);
                for (int j = 0; j < nPoints; j++) {
                    xPoints[j] -= 2;
                }
                g.drawPolyline(xPoints, yPoints, nPoints);
                for (int j = 0; j < nPoints; j++) {
                    xPoints[j] += 1;
                    yPoints[j] += 1;
                }
                g.drawPolyline(xPoints, yPoints, nPoints);
                for (int j = 0; j < nPoints; j++) {
                    yPoints[j] -= 2;
                }
                g.drawPolyline(xPoints, yPoints, nPoints);

                g.foreColor = Color.WHITE;
                final String texto = series2.title;
                g.drawText(texto, r.x + 10, r.y + 6 + (i * this.fmH));
                g.foreColor = series2.color;
                g.drawText(Convert.toCurrencyString(data.get(listToDraw.get(listToDraw.size() - 1)).y.toString(), 0),
                        r.x + 15 + this.fm.stringWidth(texto), r.y + 6 + (i * this.fmH));
            }
        }
    }

    public void changeIndex(int index) {
        listToDraw.add(index);

        // Getting scale on y Axis
        yMaxValue = Integer.MIN_VALUE;
        for (Series<X, Y> series2 : series) {
            for (Integer i : listToDraw) {
                yMaxValue = Math.max(yMaxValue, series2.data.get(i).y.intValue());
            }
        }
        yMax = ((yMaxValue / yStep) + 2) * yStep;

        // y axis
        yTextLen = Math.max(this.fm.stringWidth(Integer.toString(yMax)), this.fm.stringWidth(Integer.toString(yMin)));
        yCount = (yMax - yMin) / yStep;

        repaintNow();
    }

    @SafeVarargs
    public final void changeSeries(Series<X, Y>... series) {
        this.series = series;

        // Getting scale on y Axis
        yMaxValue = Integer.MIN_VALUE;
        for (Series<X,Y> series2 : series) {
            for (Integer i : listToDraw) {
                yMaxValue = Math.max(yMaxValue, series2.data.get(i).y.intValue());
            }
        }
        yMax = ((yMaxValue / yStep) + 2) * yStep;

        // y axis
        yTextLen = Math.max(this.fm.stringWidth(Integer.toString(yMax)), this.fm.stringWidth(Integer.toString(yMin)));
        yCount = (yMax - yMin) / yStep;

        repaintNow();
    }

    public static class Series<X extends Comparable<X>, Y extends Number> {
        List<Data<X, Y>> data;
        public String title;
        public int color;

        public Series(List<Data<X, Y>> data) {
            this.data = data;
        }
    }

    public static class Data<X extends Comparable<X>, Y extends Number> {
        X x;
        Y y;

        public Data(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
