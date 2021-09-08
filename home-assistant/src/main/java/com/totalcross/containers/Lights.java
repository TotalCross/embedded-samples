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
    private OnUpdateListener upd;

    private static boolean kValue;
    private static boolean gValue;
    private static boolean lrValue;
    private static boolean pValue;
    // private static boolean lValue;
    private boolean swtK;
    private boolean swtLR;
    private boolean swtG;
    private boolean swtP;
    private boolean swtLC;

    // private Container lightCtrl;
    private Label lblLights;
    private Label lblKitchenl;
    private Label lblLRooml;
    private Label lblPorchl;
    private Label lblGaragel;

    private Switch sLights;
    private Switch sKitchen;
    private Switch slRoom;
    private Switch sPorch;
    private Switch sGarage;

    private Icon kitchenLIcon;
    private Icon lRoomLIcon;
    private Icon porchLIcon;
    private Icon garageLIcon;

    static final int SIZEC = 100;

    private HomeMap homeMap;

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

    public boolean isSwtLC() {
        return swtLC;
    }

    public void setSwtLC(boolean swtLC) {
        this.swtLC = swtLC;
    }

    public void initUI() {
        setBackColor(Colors.BACKGROUD_DEFAULT);
        setBorderStyle(BORDER_RAISED);

        kitchenLIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        lRoomLIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        porchLIcon = new Icon(MaterialIcons._FLASH_ON);
        garageLIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);

        // Creating Switch button
        sLights = new Switch();
        sKitchen = new Switch();
        slRoom = new Switch();
        sPorch = new Switch();
        sGarage = new Switch();

        // setting labels
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

        // configuring icons
        kitchenLIcon.setForeColor(0x6495ED);
        lRoomLIcon.setForeColor(0x6495ED);
        porchLIcon.setForeColor(0x6495ED);
        garageLIcon.setForeColor(0x6495ED);

        // configuring switch button
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

        // added to container
        add(lblLights, LEFT + 10, TOP);
        add(sLights, AFTER + 130, SAME);
        add(kitchenLIcon, LEFT + 10, AFTER + 30);
        add(lblKitchenl, AFTER, SAME, DP + 150, PREFERRED);
        add(sKitchen, AFTER - 100, SAME);
        add(lRoomLIcon, LEFT + 10, AFTER + 10);
        add(lblLRooml, AFTER, SAME, DP + 150, PREFERRED);
        add(slRoom, AFTER - 100, SAME);
        add(porchLIcon, LEFT + 10, AFTER + 10);
        add(lblPorchl, AFTER, SAME, DP + 150, PREFERRED);
        add(sPorch, AFTER - 100, SAME);
        add(garageLIcon, LEFT + 10, AFTER + 10);
        add(lblGaragel, AFTER, SAME, DP + 150, PREFERRED);
        add(sGarage, AFTER - 100, SAME);

        homeMap = new HomeMap();

        turnOnOff();
    }

    // light control
    public void turnOnOff() {
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
                swtLC = true;
                upd.onUpdate();

                kitchenLIcon.setForeColor(0xFFFF00);
                lRoomLIcon.setForeColor(0xFFFF00);
                porchLIcon.setForeColor(0xFFFF00);
                garageLIcon.setForeColor(0xFFFF00);
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
                swtLC = false;
                upd.onUpdate();
            }
        });
        sKitchen.addPressListener((event) -> {
            if (sKitchen.isOn()) {
                kitchenLIcon.setForeColor(0xFFFF00);
                swtK = true;
                upd.onUpdate();
            } else {
                kitchenLIcon.setForeColor(0x6495ED);
                setLightOff();
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
                setLightOff();
                swtLR = false;
                upd.onUpdate();
            }
        });
        sGarage.addPressListener((event) -> {
            if (sGarage.isOn()) {
                garageLIcon.setForeColor(0xFFFF00);
                swtG = true;

                upd.onUpdate();
            } else {
                garageLIcon.setForeColor(0x6495ED);
                setLightOff();
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
                setLightOff();
                swtP = false;
                upd.onUpdate();
            }
        });
    }

    // set home map
    public void setHomeMap(HomeMap homeMap) {
        this.homeMap = homeMap;
        homeMap.setOnUpdate(() -> {
            kValue = this.homeMap.isSwitchKitchen();
            sKitchen.setOn(kValue);
            if (kValue == true) {
                kitchenLIcon.setForeColor(0xFFFF00);
                swtK = true;
            } else {
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
            } else {
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

    // update Listener
    void setOnUpdate(OnUpdateListener upd) {
        this.upd = upd;
    }

    private void setLightOff() {
        if (!(sKitchen.isOn() || sGarage.isOn() || slRoom.isOn() || sPorch.isOn())) {
            sLights.setOn(false);
        }
    }
}