package com.totalcross.sample.dashboard.view;

import com.totalcross.sample.dashboard.util.*;
import com.totalcross.sample.dashboard.view.components.InfoModbvusViewContainer;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.util.UnitsConverter;

public class ModbusView extends SideMenuContainerView {
    // Declaring the variables.
    Label lTitle;
    Label lSubTitle;
    Button bConnect;
    ImageControl icLogo;
    InfoModbvusViewContainer infoTemperature;
    InfoModbvusViewContainer infoRelativeHumidy;
    InfoModbvusViewContainer infoWetBTemperature;
    InfoModbvusViewContainer infoDewPoin;

    @Override
    public void onView(Container content) {
        // Initializing the variables.

        // IMAGE CONTROLL

        icLogo = new ImageControl(Images.iTotalCrossLogoHorizontal);
        icLogo.scaleToFit = true;

        // LABEL

        lTitle = new Label("MODBUS");
        lTitle.setFont(Fonts.MontserratExtraBold24);
        lTitle.setForeColor(Colors.COLOR_WHITE);

        lSubTitle = new Label("Simulated ModBus Device");
        lSubTitle.setForeColor(Colors.COLOR_WHITE);
        lSubTitle.setFont(Fonts.MontserratRegular20);

        // INFO MODBVUS VIEW CONTAINER
        infoTemperature = new InfoModbvusViewContainer("Temperature", "-6.92° C", Colors.COLOR_GREEN_TEMP);
        infoRelativeHumidy = new InfoModbvusViewContainer("Relative Humidity", "46.46 %", Colors.COLOR_BLUE_HUMIDITY);
        infoWetBTemperature = new InfoModbvusViewContainer("Wet Bulb Temperature", "-10.45° C",
                Colors.COLOR_GREEN_WBTEMP);
        infoDewPoin = new InfoModbvusViewContainer("Dew Point", "-2.56° C", Colors.COLOR_YELLOW);

        bConnect = new Button("Connect");
        bConnect.setFont(Fonts.MontserratRegular17);
        bConnect.setBackForeColors(Colors.COLOR_GREEN_BUTTON, Colors.COLOR_WHITE);
        bConnect.setBorder(BORDER_ROUNDED);
        bConnect.setDoEffect(false);

        // ADDING THE ELEMENTS IN SCREEN
        content.add(lTitle, CENTER, TOP + MaterialConstants.DP30H);

        content.add(lSubTitle, CENTER, AFTER + MaterialConstants.DP20H);

        content.add(bConnect, CENTER, AFTER + MaterialConstants.DP30H, SCREENSIZE + 10,
                SCREENSIZE + 7);

        content.add(infoRelativeHumidy, CENTER - MaterialConstants.DP90W, AFTER + MaterialConstants.DP50H,
               MaterialConstants.DP150W, MaterialConstants.DP53H);
        content.add(infoTemperature, CENTER + MaterialConstants.DP90W, SAME,MaterialConstants.DP150W, MaterialConstants.DP53H);

        content.add(infoWetBTemperature, CENTER - MaterialConstants.DP90W, AFTER + MaterialConstants.DP30H,
               MaterialConstants.DP150W, MaterialConstants.DP53H);
        content.add(infoDewPoin, CENTER + MaterialConstants.DP90W, SAME,MaterialConstants.DP150W, MaterialConstants.DP53H);

        content.add(icLogo, RIGHT - MaterialConstants.DP30W, BOTTOM -  MaterialConstants.DP10H);
    }
}