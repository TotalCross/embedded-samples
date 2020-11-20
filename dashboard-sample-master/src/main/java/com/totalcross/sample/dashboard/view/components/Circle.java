package com.totalcross.sample.dashboard.view.components;

import totalcross.sys.Settings;
import totalcross.ui.Control;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Graphics;

public class Circle extends Control {

    int color;

    public Circle(int color) {
        this.color = color;
    }

    @Override
    public void onPaint(Graphics g) {
        g.backColor = this.color;
        g.fillCircle(width / 2, height / 2, width / 2 - 1);
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
        repaint();
    }

    @Override
    public <H extends EventHandler> void onEvent(Event<H> event) {
        if (event.type == PenEvent.PEN_UP) {
            if ((!Settings.fingerTouch || !hadParentScrolled())
                    && isInsideOrNear(((PenEvent) event).x, ((PenEvent) event).y)) {
                postPressedEvent();
            }
        }
    }
}