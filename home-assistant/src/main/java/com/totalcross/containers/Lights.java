package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;


import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.Switch;
import totalcross.ui.font.Font;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;


public class Lights extends Container {

    public Lights() {

    }
    private OnUpdateListener upd;

    public static boolean kValue;
    public static boolean gValue;
    public static boolean lrValue;
    public static boolean pValue;
    public static boolean lValue;

    public boolean isSwtK() {
        return swtK;
    }

    public void setSwtK(boolean swtK) {
        this.swtK = swtK;
    }

    public boolean isSwtLR() {
        return swtLR;
    }
    
    public void setSwtLR(boolean swtLR) {
        this.swtLR = swtLR;
    }
    
    public boolean isSwtG() {
        return swtG;
    }
    
    public void setSwtG(boolean swtG) {
        this.swtG = swtG;
    }
    
    public boolean isSwtP() {
        return swtP;
    }
    
    public void setSwtP(boolean swtP) {
        this.swtP = swtP;
    }
    
    private boolean swtK;
    private boolean swtLR;
    private boolean swtG;
    private boolean swtP;
    

    public Container lightCtrl;
    public Label lblLights;
    public Label lblKitchenl;
    public Label lblLRooml;
    public Label lblPorchl;
    public Label lblGaragel;

    public Switch sLights;
    public Switch sKitchen;
    public Switch slRoom;
    public Switch sPorch;
    public Switch sGarage;

    public Icon kitchenLIcon;
    public Icon lRoomLIcon;
    public Icon porchLIcon;
    public Icon garageLIcon;

    static final int SIZEC = 100;

    private HomeMap homeMap;

    public void initUI() {

    

        //lightCtrl = new Container();
        setBackColor(Colors.BACKGROUD_DEFAULT);
        setBorderStyle(BORDER_RAISED);

        //add(lightCtrl, CENTER, CENTER, 300, 300);

        // Material Icons
        kitchenLIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        lRoomLIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        porchLIcon = new Icon(MaterialIcons._FLASH_ON);
        garageLIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);

        // Criando Switch button
        sLights = new Switch();
        sKitchen = new Switch();
        slRoom = new Switch();
        sPorch = new Switch();
        sGarage = new Switch();

        // configurando labels
        lblLights = new Label("Lights");
        lblKitchenl = new Label("Kitchen");
        lblLRooml = new Label("Living Room");
        lblPorchl = new Label("Porch");
        lblGaragel = new Label("Garage");

        lblLights.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, lblLights.getFont().size + 10));
        lblKitchenl.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        lblLRooml.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        lblPorchl.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        lblGaragel.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));

        // configurando icones

        kitchenLIcon.setForeColor(0x6495ED);
        lRoomLIcon.setForeColor(0x6495ED);
        porchLIcon.setForeColor(0x6495ED);
        garageLIcon.setForeColor(0x6495ED);

        // configurando switch button
        sLights.colorBackOn = 0x00BFFF;
        sLights.colorBackOff = Colors.COLOR_DARK_GRAY;
        sLights.colorBallOn = 0x1E90FF;
        sLights.colorBallOff = 0x696969;

        sKitchen.colorBackOn = 0x00BFFF;
        sKitchen.colorBackOff = Colors.COLOR_DARK_GRAY;
        sKitchen.colorBallOn = 0x1E90FF;
        sKitchen.colorBallOff = 0x696969;

        slRoom.colorBackOn = 0x00BFFF;
        slRoom.colorBackOff = Colors.COLOR_DARK_GRAY;
        slRoom.colorBallOn = 0x1E90FF;
        slRoom.colorBallOff = 0x696969;

        sPorch.colorBackOn = 0x00BFFF;
        sPorch.colorBackOff = Colors.COLOR_DARK_GRAY;
        sPorch.colorBallOn = 0x1E90FF;
        sPorch.colorBallOff = 0x696969;

        sGarage.colorBackOn = 0x00BFFF;
        sGarage.colorBackOff = Colors.COLOR_DARK_GRAY;
        sGarage.colorBallOn = 0x1E90FF;
        sGarage.colorBallOff = 0x696969;

        // adicionado ao container
        add(lblLights, LEFT + 10, TOP);
        add(sLights, AFTER + 113, SAME);

        add(kitchenLIcon, LEFT + 10, AFTER + 30);
        add(lblKitchenl, AFTER, SAME, DP + 150, PREFERRED);
        add(sKitchen, AFTER, SAME);

        add(lRoomLIcon, LEFT + 10, AFTER + 10);
        add(lblLRooml,AFTER, SAME, DP +  150, PREFERRED);
        add(slRoom, AFTER, SAME);

        add(porchLIcon, LEFT + 10, AFTER +10);
        add(lblPorchl, AFTER, SAME, DP + 150, PREFERRED);
        add(sPorch, AFTER, SAME);

        add(garageLIcon, LEFT + 10, AFTER + 10);
        add(lblGaragel, AFTER, SAME, DP + 150, PREFERRED);
        add(sGarage, AFTER, SAME);


        homeMap = new HomeMap();

        turnOnOff();
        
        
    }
    //controle de luzes
    public void turnOnOff(){
        sLights.addPressListener((event) -> {
            if (sLights.isOn()) {
                sKitchen.setOn(true);
                slRoom.setOn(true);
                sGarage.setOn(true);
                sPorch.setOn(true);

                swtK = true;
                swtLR = true;
                swtG = true;
                swtP = true;

                kitchenLIcon.setForeColor(0xFFFF00);
                lRoomLIcon.setForeColor(0xFFFF00);
                porchLIcon.setForeColor(0xFFFF00);
                garageLIcon.setForeColor(0xFFFF00);
                upd.onUpdate();
            } else if (sLights.isOn() == false) {
                sKitchen.setOn(false);
                kitchenLIcon.setForeColor(0x6495ED);
                slRoom.setOn(false);
                lRoomLIcon.setForeColor(0x6495ED);
                sGarage.setOn(false);
                garageLIcon.setForeColor(0x6495ED);
                sPorch.setOn(false);
                porchLIcon.setForeColor(0x6495ED);

                swtK = false;
                swtLR = false;
                swtG = false;
                swtP = false;
                upd.onUpdate();
   
            }
        });
        sKitchen.addPressListener((event) -> {
            if (sKitchen.isOn()) {
                kitchenLIcon.setForeColor(0xFFFF00);
                swtK = true;
                upd.onUpdate();
            } else{
                kitchenLIcon.setForeColor(0x6495ED);
                swtK = false;
                upd.onUpdate();
            }
        });
        slRoom.addPressListener((event) -> {
            if (slRoom.isOn()) {
                lRoomLIcon.setForeColor(0xFFFF00);
                
                swtLR = true;
                upd.onUpdate(); 
            } else {
                lRoomLIcon.setForeColor(0x6495ED);
                
                swtLR = false;
                upd.onUpdate(); 
            }
        });
        sGarage.addPressListener((event) -> {
            if (sGarage.isOn()) {
                garageLIcon.setForeColor(0xFFFF00);
                swtG = true;
                
                upd.onUpdate(); 
            } else{
                garageLIcon.setForeColor(0x6495ED);
                
                swtG = false;
                upd.onUpdate(); 
            }
        });
        sPorch.addPressListener((event) -> {
            if (sPorch.isOn()) {
                porchLIcon.setForeColor(0xFFFF00);
                
                swtP = true;
                upd.onUpdate(); 
            } else {
                porchLIcon.setForeColor(0x6495ED);
                
                swtP = false;
                upd.onUpdate(); 
            }
        });
    }     
    //set home map
     public void setHomeMap(HomeMap homeMap){
        this.homeMap = homeMap;
        homeMap.setOnUpdate(()->{
            kValue = this.homeMap.isSwitchKitchen();
            sKitchen.setOn(kValue);
            if (kValue == true) {
                kitchenLIcon.setForeColor(0xFFFF00);
                swtK = true;
            } else{
                kitchenLIcon.setForeColor(0x6495ED);
                swtK = false;
            }
            lrValue = this.homeMap.isSwitchLRoom();
            slRoom.setOn(lrValue);
            if (lrValue == true) {
                lRoomLIcon.setForeColor(0xFFFF00);
                swtLR = true;
            } else {
                lRoomLIcon.setForeColor(0x6495ED);
                swtLR = false;
            }
            gValue = this.homeMap.isSwitchGarage();
            sGarage.setOn(gValue);
            if (gValue == true) {
                garageLIcon.setForeColor(0xFFFF00);
                swtG = true;
            } else{
                garageLIcon.setForeColor(0x6495ED);
                swtG = false;
            }
            pValue = this.homeMap.isSwitchPorch();
            sPorch.setOn(pValue);
            if (pValue == true) {
                porchLIcon.setForeColor(0xFFFF00);
                swtP = true;
            } else {
                porchLIcon.setForeColor(0x6495ED);
                swtP = false;
            }      
        });
    }
    //update Listener
    public void setOnUpdate(OnUpdateListener upd){
        this.upd = upd;
    }
}