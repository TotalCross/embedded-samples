package com.totalcross.containers;

import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Graphics;
import totalcross.ui.image.Image;

public class Generator extends CircleContainer {

    public Generator(int cor, double kwh,  Image img) {
        super(cor);
        this.kwh = kwh;
        this.img = img;
        //TODO Auto-generated constructor stub
    }
    double kwh, value;
    Image img;
    CircleContainer consumer;

    @Override
    public void onPaint(Graphics g) {
        super.onPaint(g);
        g.foreColor = Color.BLACK;
        g.drawImage(img, width/3, height/4, false);
        g.drawText(Double.toString(kwh) + " KwH", width/4, height/2, 0);
        if(consumer!= null){
            g.drawLine(width/2, height/2, (consumer.getX() + consumer.getWidth())/2, (consumer.getY() + consumer.getHeight())/2);
        }
    }

    public void setConsumer(CircleContainer consumer, double value){
        this.consumer = consumer;
        this.value = value;
    }
}
