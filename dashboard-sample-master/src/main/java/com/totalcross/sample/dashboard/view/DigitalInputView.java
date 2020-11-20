package com.totalcross.sample.dashboard.view;

import com.totalcross.sample.dashboard.util.*;
import com.totalcross.sample.dashboard.view.components.Circle;

import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;
import totalcross.ui.Label;
import totalcross.util.UnitsConverter;

public class DigitalInputView extends SideMenuContainerView {

    Circle circle1;
    boolean circle1On;
    Circle circle2;

    public DigitalInputView() {
        setBackColor(Color.getRGB("1A1A1A"));
        circle1 = new Circle(Color.getRGB("12D50B"));
        circle1.addPressListener(new PressListener() {
            @Override
            public void controlPressed(ControlEvent e) {
                if (!circle1On) {
                    circle2.setColor(Color.getRGB("FFFFFF"));
                    circle1.setColor(Color.getRGB("12D50B"));
                    circle1On = !circle1On;
                }
            }
        });
        circle2 = new Circle(Color.getRGB("FFFFFF"));
        circle2.addPressListener(new PressListener() {
            @Override
            public void controlPressed(ControlEvent e) {
                if (circle1On) {
                    circle1.setColor(Color.getRGB("FFFFFF"));
                    circle2.setColor(Color.getRGB("D8E51D"));
                    circle1On = !circle1On;
                }
            }
        });
        circle1On = true;

    }

    @Override
    public void onView(Container content) {
        ImageControl icLogo = new ImageControl(Images.iTotalCrossLogoHorizontal);
        icLogo.scaleToFit = true;

        // LABEL
        Label lTitle = new Label("DIGITAL INPUT");
        lTitle.setFont(Fonts.MontserratExtraBold24);
        // Montserrat Extra Bold tam 24px
        lTitle.setForeColor(Colors.COLOR_WHITE);
        content.add(lTitle, CENTER, TOP + MaterialConstants.DP55H);
        content.add(circle1, CENTER - MaterialConstants.DP67W, CENTER, MaterialConstants.DP90W, MaterialConstants.DP90H);
        content.add(circle2, CENTER + MaterialConstants.DP68W, CENTER, MaterialConstants.DP90W, MaterialConstants.DP90H);
        content.add(icLogo, RIGHT - MaterialConstants.DP30W, BOTTOM -  MaterialConstants.DP10H);
    }
}