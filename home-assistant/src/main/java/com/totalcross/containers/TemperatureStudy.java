package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import com.totalcross.util.Images;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

public class TemperatureStudy extends Container {

    private static Label lblTitle;
    private Label lblTemp;

    private String temp = "20";
    private static String DEFAULT_TEMP = "°C";

    static final int SIZEC = 100;

    private ImageControl imgEnergy;

    @Override
    public void initUI() {
        Images.loadTemperatureStudy();

        // creating image
        imgEnergy = new ImageControl(Images.imgEnergy);

        // configuring image
        imgEnergy.transparentBackground = true;

        // creating label
        lblTitle = new Label("Estudo de temperatura");
        lblTemp = new Label(temp + DEFAULT_TEMP);

        // creating label
        lblTitle.transparentBackground = true;
        lblTemp.transparentBackground = true;
        lblTitle.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTitle.getFont().size + 6));
        lblTemp.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTemp.getFont().size + 5));

        add(lblTitle, LEFT + 20, TOP + 10);
        add(lblTemp, SAME, SAME + 60);
        add(imgEnergy, LEFT + 400, TOP + 15);

        // Setting up the container
        setBackColor(Colors.BACKGROUD_DEFAULT);
        setBorderRadius(5);
        setBorderStyle(BORDER_RAISED);
        setBackColor(Color.WHITE);

        resize();
    }
}
