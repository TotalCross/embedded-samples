package com.totalcross.containers;

import totalcross.ui.Control;
import totalcross.ui.gfx.Graphics;

public class CircleContainer extends Control {
    public CircleContainer(int cor){
        this.cor = cor;
    }
    int cor;
    @Override
    public void onPaint(Graphics g) {
        g.foreColor = cor;
        g.drawCircle(width /2, height/2, 30);

    }

}
