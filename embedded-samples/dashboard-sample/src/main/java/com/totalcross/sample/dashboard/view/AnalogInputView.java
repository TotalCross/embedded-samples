package com.totalcross.sample.dashboard.view;

import java.util.Random;

import com.totalcross.sample.dashboard.util.Colors;
import com.totalcross.sample.dashboard.util.Fonts;
import com.totalcross.sample.dashboard.util.Images;
import com.totalcross.sample.dashboard.util.MaterialConstants;
import com.totalcross.sample.dashboard.view.components.Graphic;
import com.totalcross.sample.dashboard.view.components.TemperatureValueLabel;
import com.totalcross.sample.dashboard.view.components.Thermometer;

import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.event.UpdateListener;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;

public class AnalogInputView extends SideMenuContainerView {

    Graphic graphic;
    Thermometer thermo;
    TemperatureValueLabel temperatureValue;
    int[] yValues;
    int refreshTime = 2000;
    int elapsedRefreshTime = 0;
    Random randomGenerator = new Random();

    UpdateListener updateListener = new UpdateListener() {

        public void updateListenerTriggered(int elapsedMiliseconds) {
            elapsedRefreshTime += elapsedMiliseconds;
            if (elapsedRefreshTime >= refreshTime) {
                int value = randomGenerator.nextInt(100);
                setThermometerValue(value);
                elapsedRefreshTime = 0;
            }
        }
    };

    public AnalogInputView() {
        setBackColor(Color.getRGB("1A1A1A"));
        this.graphic = new Graphic(100, 4, 12);
        yValues = new int[12];
        int[] values = new int[12];
        for (int i = 0; i < values.length; i++) {
            values[i] = 9 * i;
        }
        graphic.setFont(Fonts.MontserratMedium14);
        graphic.setValues(values);
        graphic.setIntervalBarsColor(Color.getRGB("C7C4C4"));
        graphic.setLineAndPointsColor(Color.getRGB("6B3193"));
        graphic.setSideTextColor(Color.getRGB("716D6D"));
        thermo = new Thermometer(0, 100, 10);
        thermo.setFont(Fonts.MontserratMedium8);
        thermo.setValue(50);
        MainWindow.getMainWindow().addUpdateListener(updateListener);
    }

    @Override
    public void onView(Container content) {
        ImageControl icLogo = new ImageControl(Images.iTotalCrossLogoHorizontal);
        icLogo.scaleToFit = true;
        // LABEL
        Label lTitle = new Label("ANALOG INPUT");
        lTitle.setFont(Fonts.MontserratExtraBold24);
        lTitle.setForeColor(Colors.COLOR_WHITE);
        Label graphTitle = new Label("Thermocouple T Type");
        graphTitle.setFont(Fonts.MontserratExtraBold24);
        graphTitle.setForeColor(Colors.COLOR_WHITE);
        content.add(lTitle, CENTER, TOP + MaterialConstants.DP35H);
        Label temperature = new Label("TEMPERATURE", CENTER);
        temperature.setFont(Fonts.MontserratBold17);
        temperature.setForeColor(Colors.COLOR_WHITE);
        temperatureValue = new TemperatureValueLabel(thermo.getValue());
        temperatureValue.setFont(Fonts.MontserratExtraBold19);
        temperatureValue.setBackForeColors(Color.getRGB("21C437"), Colors.COLOR_WHITE);
        content.add(graphic, MaterialConstants.DP40W, CENTER + MaterialConstants.DP50H, PARENTSIZE + 50,
                PARENTSIZE + 40);
        content.add(graphTitle, CENTER_OF, BEFORE - UnitsConverter.toPixels(DP + 20));

        content.add(temperatureValue, RIGHT - MaterialConstants.DP55W, CENTER, MaterialConstants.DP114W, MaterialConstants.DP40H);
        content.add(temperature, CENTER_OF, BEFORE - MaterialConstants.DP10H);
        content.add(thermo, BEFORE - MaterialConstants.DP10W, CENTER, MaterialConstants.DP60W, MaterialConstants.DP224H);

        content.add(icLogo, RIGHT - MaterialConstants.DP30W, BOTTOM -  MaterialConstants.DP10H);
    }

    public void setThermometerValue(int value) {
        thermo.setValue(value);
        for (int i = 1; i < yValues.length; i++) {
            yValues[i - 1] = yValues[i];
        }
        yValues[yValues.length - 1] = value;
        graphic.setValues(yValues);
        temperatureValue.setValue(value);
        repaint();
    }
}