package com.totalcross.sample.dashboard.view;

import com.totalcross.sample.dashboard.util.Colors;
import com.totalcross.sample.dashboard.util.Fonts;
import com.totalcross.sample.dashboard.util.Images;
import com.totalcross.sample.dashboard.util.MaterialConstants;

import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.Switch;
import totalcross.ui.gfx.Color;

public class EditView extends SideMenuContainerView{
    ImageControl icLogo;
    Label lTitle;
    Label labelLEDS;
    Switch switchRedLED;
    Switch switchGreenLED;
    Switch switchBlueLED;
    Edit editRedLED;
    Edit editGreenLED;
    Edit editBlueLED;
    Container container;

    @Override
    public void onView(Container content) {
        icLogo = new ImageControl(Images.iTotalCrossLogoHorizontal);
        content.add(icLogo, RIGHT - MaterialConstants.DP30W, BOTTOM -  MaterialConstants.DP10H);

        lTitle = new Label("LED INTENSITY");
        
        lTitle.setFont(Fonts.MontserratExtraBold24);
        lTitle.setForeColor(Colors.COLOR_WHITE);
        content.add(lTitle, CENTER, TOP + MaterialConstants.DP55H);

        container = new Container();
        container.setBackColor(Colors.COLOR_LED_BACKGROUND);
        container.setBorderStyle(Container.BORDER_ROUNDED);
        container.borderColor = Colors.COLOR_LED_BACKGROUND;
        content.add(container, LEFT + MaterialConstants.DP124W, AFTER + MaterialConstants.DP50H,FILL - MaterialConstants.DP124W, FILL - MaterialConstants.DP114H);
        labelLEDS = new Label("LEDS", CENTER);
        labelLEDS.setBackForeColors(Colors.COLOR_LED_BACKGROUND, Colors.COLOR_WHITE);

        content.add(labelLEDS, LEFT + MaterialConstants.DP150W, AFTER + MaterialConstants.DP55H, MaterialConstants.DP124W, PREFERRED, lTitle);
        
        switchRedLED = new Switch();
        switchRedLED.setDoEffect(false);
        switchRedLED.colorBarOn = Colors.COLOR_RED_SWITCH;
        switchRedLED.colorBarOff = Colors.COLOR_GRAY_SWITCH;
        switchRedLED.colorBallOn = Colors.COLOR_RED_SWITCH_BALL;
        switchRedLED.colorBallOff = Colors.COLOR_GRAY_SWITCH_BALL;
        content.add(switchRedLED, SAME, AFTER + MaterialConstants.DP2H, MaterialConstants.DP124W, new Edit().getPreferredHeight());
        
        editRedLED = new Edit();
        editRedLED.transparentBackground = true;
        editRedLED.caption = "Intensity";
        editRedLED.captionColor = Colors.COLOR_WHITE;
        editRedLED.setForeColor(Colors.COLOR_GRAY_LED_TEXT);
        editRedLED.setFont(Fonts.MontserratRegular12);
        content.add(editRedLED, AFTER + MaterialConstants.DP70W, SAME - MaterialConstants.DP8H, MaterialConstants.DP124W, PREFERRED);
        
        switchGreenLED = new Switch();
        switchGreenLED.setDoEffect(false);
        switchGreenLED.colorBarOn = Colors.COLOR_GREEN_SWITCH;
        switchGreenLED.colorBarOff = Colors.COLOR_GRAY_SWITCH;
        switchGreenLED.colorBallOn = Colors.COLOR_GREEN_SWITCH_BALL;
        switchGreenLED.colorBallOff = Colors.COLOR_GRAY_SWITCH_BALL;
        content.add(switchGreenLED, SAME, AFTER + MaterialConstants.DP2H, MaterialConstants.DP124W, new Edit().getPreferredHeight(), switchRedLED);
        
        editGreenLED = new Edit();
        editGreenLED.transparentBackground = true;
        editGreenLED.caption = "Intensity";
        editGreenLED.captionColor = Colors.COLOR_WHITE;
        editGreenLED.setForeColor(Colors.COLOR_GRAY_LED_TEXT);
        editGreenLED.setFont(Fonts.MontserratRegular12);
        content.add(editGreenLED, AFTER + MaterialConstants.DP70W, SAME - MaterialConstants.DP8H, MaterialConstants.DP124W, PREFERRED);
        
        switchBlueLED = new Switch();
        switchBlueLED.setDoEffect(false);
        switchBlueLED.colorBarOn = Colors.COLOR_BLUE_SWITCH;
        switchBlueLED.colorBarOff = Colors.COLOR_GRAY_SWITCH;
        switchBlueLED.colorBallOn = Colors.COLOR_BLUE_SWITCH_BALL;
        switchBlueLED.colorBallOff = Colors.COLOR_GRAY_SWITCH_BALL;
        content.add(switchBlueLED, SAME, AFTER + MaterialConstants.DP2H, MaterialConstants.DP124W, new Edit().getPreferredHeight(), switchGreenLED);
        
        editBlueLED = new Edit();
        editBlueLED.transparentBackground = true;
        editBlueLED.caption = "Intensity";
        editBlueLED.captionColor = Colors.COLOR_WHITE;
        editBlueLED.setForeColor(Colors.COLOR_GRAY_LED_TEXT);
        editBlueLED.setFont(Fonts.MontserratRegular12);
        content.add(editBlueLED, AFTER + MaterialConstants.DP70W, SAME - MaterialConstants.DP8H, MaterialConstants.DP124W, PREFERRED);
    
        int backgroundHeight = labelLEDS.getHeight() + MaterialConstants.DP5H + switchRedLED.getHeight() + MaterialConstants.DP2H + switchGreenLED.getHeight() + MaterialConstants.DP2H + switchBlueLED.getHeight() + MaterialConstants.DP2H + MaterialConstants.DP5H;
        container.setRect(container.getX(), container.getY(), container.getWidth(), backgroundHeight);
        
    }

}