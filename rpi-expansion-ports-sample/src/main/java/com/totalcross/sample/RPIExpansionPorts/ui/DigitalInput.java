package com.totalcross.sample.RPIExpansionPorts.ui;

import com.totalcross.sample.RPIExpansionPorts.utils.Colors;
import com.totalcross.sample.RPIExpansionPorts.utils.Images;
import com.totalcross.sample.RPIExpansionPorts.utils.MaterialConstants;

import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.ScrollContainer;
import totalcross.ui.layout.VBox;

public class DigitalInput extends Container {
    @Override
    public void initUI(){
        super.initUI();
        ScrollContainer sc = new ScrollContainer(true, true);
        sc.setBorderStyle(sc.BORDER_ROUNDED);
        sc.setBackForeColors(Colors.SHADOW,Colors.SHADOW);
        add(sc, LEFT, TOP, FILL, FILL);

        ImageControl LC7= new ImageControl(Images.status_grey);
        RPIExpansionPortsLabel L7= new RPIExpansionPortsLabel("0000",4,LC7);
        L7.appId=7;
        L7.setSendCommand('>', "7");
        ImageControl LC8= new ImageControl(Images.status_grey);
        RPIExpansionPortsLabel L8= new RPIExpansionPortsLabel("0000",4,LC8);
        L8.appId=8;
        L8.setSendCommand('>', "8");
        ImageControl LC11= new ImageControl(Images.status_grey);
        RPIExpansionPortsLabel L11= new RPIExpansionPortsLabel("0000",4,LC11);
        L11.appId=11;
        L11.setSendCommand('>', "11");
        ImageControl LC12= new ImageControl(Images.status_grey);
        RPIExpansionPortsLabel L12= new RPIExpansionPortsLabel("0000",4,LC12);
        L12.appId=12;
        L12.setSendCommand('>', "12");

        VBox LabD= new VBox(VBox.LAYOUT_FILL, VBox.ALIGNMENT_STRETCH);
        LabD.add(LC7);
        LabD.add(LC8);
        LabD.add(LC11);
        LabD.add(LC12);
        LabD.transparentBackground=true;
        LabD.setSpacing(MaterialConstants.COMPONENT_SPACING);

        VBox LabT= new VBox(VBox.LAYOUT_FILL, VBox.ALIGNMENT_STRETCH);
        LabT.add(new RPIExpansionPortsLabel("Button",3));
        LabT.add(new RPIExpansionPortsLabel("Input 8",3));
        LabT.add(new RPIExpansionPortsLabel("Input 11",3));
        LabT.add(new RPIExpansionPortsLabel("Input 12",3));
        LabT.transparentBackground=true;
        LabT.setSpacing(MaterialConstants.COMPONENT_SPACING);

        VBox LabI= new VBox(VBox.LAYOUT_FILL, VBox.ALIGNMENT_STRETCH);
        ImageControl IC=new ImageControl(Images.input_white);
        ImageControl IC1=new ImageControl(Images.input_white);
        ImageControl IC2=new ImageControl(Images.input_white);
        ImageControl IC3=new ImageControl(Images.input_white);
        IC.transparentBackground=true;
        IC.scaleToFit=true;
        IC1.transparentBackground=true;
        IC1.scaleToFit=true;
        IC2.transparentBackground=true;
        IC2.scaleToFit=true;
        IC3.transparentBackground=true;
        IC3.scaleToFit=true;
        LabI.add(IC);
        LabI.add(IC1);
        LabI.add(IC2);
        LabI.add(IC3);
        LabI.transparentBackground=true;
        LabI.setSpacing(MaterialConstants.COMPONENT_SPACING);

        sc.add(new RPIExpansionPortsLabel("Status", 1),RIGHT-MaterialConstants.BORDER_SPACING*2,TOP);
        sc.add(LabI,LEFT+MaterialConstants.BORDER_SPACING*2,AFTER+MaterialConstants.BORDER_SPACING,(int)(sc.getEffectW()*0.06),
        (MaterialConstants.COMPONENT_SPACING + MaterialConstants.EDIT_HEIGHT) * 4);
        sc.add(new RPIExpansionPortsLabel("Name", 1),AFTER+MaterialConstants.BORDER_SPACING,TOP);
        sc.add(LabT,SAME,AFTER+MaterialConstants.COMPONENT_SPACING,PREFERRED,
                (MaterialConstants.COMPONENT_SPACING + MaterialConstants.EDIT_HEIGHT) * 4);

        sc.add(LabD,RIGHT-MaterialConstants.BORDER_SPACING*3,SAME+MaterialConstants.BORDER_SPACING/2,(int)(sc.getEffectW()*0.06),
        (MaterialConstants.COMPONENT_SPACING + MaterialConstants.EDIT_HEIGHT) * 4);
    
    }
}