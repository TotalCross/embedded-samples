package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Images;

import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ScrollBar;
import totalcross.ui.Slider;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public class Energy extends Container {
    public Energy() {

    }

    public Container energyContainer;
    public Button btnDashboard;
    //public ImageControl eletrica, home;
    //public CircleContainer  eletrica, home;
    //public Label lblNFossil, lblSolar, lblGrid1, lblGrid2, lblHome;
    public Slider sldNFossil, sldSolGrid, sldSolHome, sldGridHome;
    public Generator nFossil, solar, eletrica, home;
    public Image imgNFossil, imgSolar, imgEletrica, imgHome;
    static final int SIZEC = 100;

    public void initUI() {

        energyContainer = new Container();

        Images.loadNonFossil();
        Images.loadSolarPower();
        Images.loadEletricity();
        Images.loadHomeEnergy();

       

        
        add(energyContainer, LEFT, TOP, 200, 200);
        energyContainer.setBorderStyle(BORDER_RAISED);
        energyContainer.setBackColor(Colors.BACKGROUD_DEFAULT);
        
        try {
            imgNFossil = new Image("images/imgNFossil.png");
            imgSolar = new Image("images/Solar.png");
            imgEletrica = new Image("images/Grid.png");
            imgHome = new Image("images/Home.png");

        } catch (IOException | ImageException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
        sldNFossil = new Slider(ScrollBar.VERTICAL);
        sldNFossil.setFont(Font.getFont(false, Font.NORMAL_SIZE));
        sldNFossil.appId = 1;
        sldNFossil.setLiveScrolling(false);
        sldNFossil.setBackColor(0x00C301);
        sldNFossil.sliderColor = 0x00C301;
        sldNFossil.setPressColor(0x00C301);
        sldNFossil.setMaximum(15);
        sldNFossil.markerSize = 0;
        sldNFossil.barHeight = 2;

        sldSolGrid = new Slider(ScrollBar.VERTICAL);
        sldSolGrid.setFont(Font.getFont(false, Font.NORMAL_SIZE));
        sldSolGrid.appId = 2;
        sldSolGrid.setLiveScrolling(true);
        sldSolGrid.setBackColor(0xff781f);
        sldSolGrid.sliderColor = 0xff781f;
        sldSolGrid.setPressColor(0xff781f);
        sldSolGrid.setMaximum(50);
        sldSolGrid.markerSize = 2;
        sldSolGrid.barHeight = 2;

        sldSolHome = new Slider(ScrollBar.VERTICAL);
        sldSolHome.setFont(Font.getFont(false, Font.NORMAL_SIZE));
        sldSolHome.appId = 3;
        sldSolHome.setLiveScrolling(true);
        sldSolHome.setBackColor(0xff781f);
        sldSolHome.sliderColor = 0xff781f;
        sldSolHome.setPressColor(0xff781f);
        sldSolHome.setMaximum(50);
        sldSolHome.markerSize = 2;
        sldSolHome.barHeight = 2;

        sldGridHome = new Slider(ScrollBar.HORIZONTAL);
        sldGridHome.setFont(Font.getFont(false, Font.NORMAL_SIZE));
        sldGridHome.appId = 4;
        sldGridHome.setLiveScrolling(true);
        sldGridHome.setBackColor(0x2b5bb0);
        sldGridHome.sliderColor = 0x2b5bb0;
        sldGridHome.setPressColor(0x2b5bb0);
        sldGridHome.setMaximum(55);
        sldGridHome.markerSize = 2;
        sldGridHome.barHeight = 2;

        
        nFossil = new Generator(Color.GREEN, 2.1, imgNFossil);
        solar = new Generator(Color.YELLOW, 5.2,imgSolar);
        eletrica = new Generator(Color.BLUE,3.6, imgEletrica);
        home = new Generator(Color.RED, 9, imgHome);

       
        nFossil.setConsumer(eletrica, 2.1);
        eletrica.setConsumer(home, 3.6);
        solar.setConsumer(home, 4.9);
        solar.setConsumer(eletrica, 1.4);

        
        solar.transparentBackground = true;
        eletrica.transparentBackground = true;
        home.transparentBackground = true;

        

        btnDashboard = new Button("GO TO ENERGY DASHBOARD", Button.BORDER_NONE);

        btnDashboard.setForeColor(Colors.FROZEN_DEFAULT);

        energyContainer.add(nFossil, LEFT, TOP, 80, 80);
        energyContainer.add(solar, RIGHT, TOP, 80, 80);
        energyContainer.add(eletrica, LEFT, TOP + 110, 80, 80);
        energyContainer.add(home, RIGHT + 80, TOP + 110, 80, 80);
        energyContainer.add(btnDashboard, CENTER, BOTTOM + 100, PARENTSIZE, PREFERRED);

        energyContainer.resize();

    }
    
}
