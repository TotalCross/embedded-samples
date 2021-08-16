package com.totalcross.sample.RPIExpansionPorts.ui;

import com.totalcross.sample.RPIExpansionPorts.utils.Colors;
import com.totalcross.sample.RPIExpansionPorts.utils.Images;
import com.totalcross.sample.RPIExpansionPorts.utils.MaterialConstants;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.ScrollContainer;
import totalcross.ui.layout.VBox;

public class AnalogInput extends Container {
    @Override
    public void initUI() {
        super.initUI();
        ScrollContainer sc = new ScrollContainer(true, true);
        sc.setBorderStyle(sc.BORDER_ROUNDED);
        sc.setBackForeColors(Colors.SHADOW, Colors.SHADOW);
        add(sc, LEFT, TOP, FILL, FILL);

        RPIExpansionPortsLabel A0 = new RPIExpansionPortsLabel("0000",4);
        A0.appId = 14;
        A0.setSendCommand('-', "14");
        A0.setTermoMode();
        RPIExpansionPortsLabel A1 = new RPIExpansionPortsLabel("0000",4);
        A1.appId = 15;
        A1.setSendCommand('-', "15");
        RPIExpansionPortsLabel A2= new RPIExpansionPortsLabel("0000",4);
        A2.appId=16;
        A2.setSendCommand('-', "16");

        VBox LabD = new VBox(VBox.LAYOUT_FILL, VBox.ALIGNMENT_STRETCH);
        LabD.add(A0);
        LabD.add(A1);
        LabD.add(A2);
        LabD.transparentBackground = true;
        LabD.setSpacing(MaterialConstants.COMPONENT_SPACING);

        VBox LabT = new VBox(VBox.LAYOUT_FILL, VBox.ALIGNMENT_STRETCH);
        LabT.add(new RPIExpansionPortsLabel("Thermometer °C",2));
        LabT.add(new RPIExpansionPortsLabel("Joystick (X axis)",2));
        LabT.add(new RPIExpansionPortsLabel("Joystick (Y axis)",2));
        LabT.transparentBackground = true;
        LabT.setSpacing(MaterialConstants.COMPONENT_SPACING);
        

        VBox imgs = new VBox(VBox.LAYOUT_FILL, VBox.ALIGNMENT_STRETCH);

        ImageControl sensorImage = new ImageControl(Images.sensor);
        ImageControl sensorImage1 = new ImageControl(Images.sensor);
        ImageControl sensorImage2 = new ImageControl(Images.sensor);
        sensorImage.transparentBackground=true;
        sensorImage1.transparentBackground=true;
        sensorImage2.transparentBackground=true;
        sensorImage.scaleToFit=true;
        sensorImage1.scaleToFit=true;
        sensorImage2.scaleToFit=true;

        imgs.add(sensorImage);
        imgs.add(sensorImage1);
        imgs.add(sensorImage2);
        imgs.transparentBackground=true;
        imgs.setSpacing(MaterialConstants.COMPONENT_SPACING);

        RPIExpansionPortsLabel title =new RPIExpansionPortsLabel("Sensors",1);
        sc.add(title,CENTER, TOP+MaterialConstants.BORDER_SPACING);

        sc.add(imgs,LEFT+MaterialConstants.BORDER_SPACING,AFTER+MaterialConstants.COMPONENT_SPACING, MaterialConstants.EDIT_HEIGHT/2,
        (MaterialConstants.COMPONENT_SPACING + MaterialConstants.EDIT_HEIGHT) * 3);

        sc.add(LabT,AFTER+MaterialConstants.COMPONENT_SPACING,
        SAME-MaterialConstants.COMPONENT_SPACING,PREFERRED,
        (MaterialConstants.COMPONENT_SPACING + MaterialConstants.EDIT_HEIGHT) * 3);

        sc.add(LabD,RIGHT-MaterialConstants.BORDER_SPACING,SAME,PREFERRED,
        (MaterialConstants.COMPONENT_SPACING + MaterialConstants.EDIT_HEIGHT) * 3);
    
    }
}