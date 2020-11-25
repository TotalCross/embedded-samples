package com.totalcross.sample.RPIExpansionPorts.ui;

import com.totalcross.sample.RPIExpansionPorts.utils.Colors;
import com.totalcross.sample.RPIExpansionPorts.utils.Images;
import com.totalcross.sample.RPIExpansionPorts.utils.MaterialConstants;

import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.ScrollContainer;

public class ShowContainer extends Container {
    ScrollContainer sc;

    public void initUI() {
        sc = new ScrollContainer(true, true);
        sc.setBackColor(Colors.BACKGROUND);
        add(sc, LEFT, TOP, FILL, FILL);

        RPIExpansionPortsLabel Title = new RPIExpansionPortsLabel("GUI Dashboard Sample",1);
        RPIExpansionPortsLabel Autor = new RPIExpansionPortsLabel("Autor: Patrick Martins",3);
        RPIExpansionPortsLabel Company = new RPIExpansionPortsLabel("Company: TotalCross",3);
        
        sc.add(Title,LEFT+(int) (Settings.screenWidth * 0.09),TOP + (int) (Settings.screenHeight * 0.12),PREFERRED,PREFERRED);
        sc.add(Autor,Title.getX(),AFTER);
        sc.add(Company,Title.getX(),AFTER);
       
        ImageControl crossy= new ImageControl(Images.crossy);
        crossy.transparentBackground=true;
        crossy.scaleToFit=true; 
        sc.add(crossy,LEFT+Title.getX2(),
        TOP+Title.getY(),(int)(0.10*Settings.screenWidth),(int)(0.20*Settings.screenHeight),Autor);
     
        
        AnalogInput Ainp= new AnalogInput();
            sc.add(Ainp,Title.getX(), AFTER+MaterialConstants.COMPONENT_SPACING,
             (int) (Settings.screenWidth * 0.37), (int) (Settings.screenHeight * 0.61));

        DigitalOutput Dout = new DigitalOutput();
        sc.add(Dout, (int) (Settings.screenWidth * 0.52) , TOP+(int)(Settings.screenHeight*0.06), (int) (Settings.screenWidth * 0.41),
            (int) (Settings.screenHeight * 0.43));

        DigitalInput Dinp= new DigitalInput();
            sc.add(Dinp,SAME , AFTER+MaterialConstants.COMPONENT_SPACING*2, (int) (Settings.screenWidth * 0.41),
            (int) (Settings.screenHeight * 0.43));

        
    }
}