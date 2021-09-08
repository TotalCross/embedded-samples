package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import com.totalcross.util.Images;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

public class Temperature extends Container {

    private Label lblLevel;
    private Label lblTempNow;
    private Label lblTemp;
    private Label lblStatusTemp;

    private Button btnHot;
    private Button btnFrozen;
    private Button btnOff;
    private Button btnDate;

    private String statusTemp = "Automatico";
    private String statusTempOFF = "Ausente";
    private String tempMax = "30";
    private String tempMin = "15";

    static final int SIZEC = 100;

    ArcSlider arcSlider;

    @Override
    public void initUI() {
        // calling images
        Images.loadCalender();
        Images.loadFrozen();
        Images.loadHot();
        Images.loadOff();

        // Creating labels
        lblLevel = new Label("Andar de cima");
        lblTempNow = new Label("22°");
        lblTemp = new Label(tempMin + "  -  " + tempMax);
        lblStatusTemp = new Label(statusTemp + " - " + statusTempOFF);

        // creating buttons
        btnDate = new Button(Images.imgCalenderGray);
        btnFrozen = new Button(Images.imgCalenderGray);
        btnHot = new Button(Images.imgHotGray);
        btnOff = new Button(Images.imgOffGray);

        // Criando slider button
        arcSlider = new ArcSlider();

        // Setting labels
        lblTempNow.transparentBackground = true;
        lblTemp.transparentBackground = true;
        lblStatusTemp.transparentBackground = true;
        lblTempNow.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTempNow.getFont().size + 60));
        lblStatusTemp.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblStatusTemp.getFont().size + 2));
        lblTemp.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTemp.getFont().size + 2));
        lblLevel.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblLevel.getFont().size + 2));

        // Setting up the container
        setBackColor(Colors.BACKGROUD_DEFAULT);
        setBorderRadius(5);
        setBorderStyle(BORDER_RAISED);
        setBackColor(Color.WHITE);

        // configuring the buttons
        btnDate.transparentBackground = true;
        btnFrozen.transparentBackground = true;
        btnHot.transparentBackground = true;
        btnOff.transparentBackground = true;

        // Adding components to container
        add(arcSlider, LEFT - 20, CENTER + 150, 600, 400);
        add(lblTempNow, LEFT + 190, SAME + 130);
        add(lblTemp, SAME + 40, AFTER + 10);
        add(lblStatusTemp, SAME - 80, SAME + 30);
        add(btnDate, LEFT + 130, SAME + 50);
        add(btnHot, SAME + 80, SAME);
        add(btnFrozen, SAME + 80, SAME);
        add(btnOff, SAME + 80, SAME);
        add(lblLevel, LEFT + 180, SAME + 80);
        resize();
    }
}
