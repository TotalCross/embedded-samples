package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import com.totalcross.util.Images;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.Slider;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

public class Temperature extends Container {

    public Label lblLevel;
    public Label lblTempNow;
    public Label lblTemp;
    public Label lblStatusTemp;

    public Button btnHot;
    public Button btnFrozen;
    public Button btnOff;
    public Button btnDate;

    public Slider sliderTempMin;
    public Slider sliderTempMax;

    public String statusTemp = "Automatico";
    public String statusTempOFF = "Ausente";
    public String tempMax = "30";
    public String tempMin = "15";

    static final int SIZEC = 100;
    public int startAngle = 225;
    public int endAngle = 315;
    public int radius;

    ArcSlider arcSlider;

    @Override
    public void initUI() {

        // Chamando imagens
        Images.loadCalender();
        Images.loadFrozen();
        Images.loadHot();
        Images.loadOff();

        // Criando labels
        lblLevel = new Label("Andar de cima");
        lblTempNow = new Label("22°");
        lblTemp = new Label(tempMin + "  -  " + tempMax);
        lblStatusTemp = new Label(statusTemp + " - " + statusTempOFF);

        // Configurando labels
        lblTempNow.transparentBackground = true;
        lblTemp.transparentBackground = true;
        lblStatusTemp.transparentBackground = true;
        lblTempNow.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTempNow.getFont().size + 60));
        lblStatusTemp.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblStatusTemp.getFont().size + 2));
        lblTemp.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTemp.getFont().size + 2));
        lblLevel.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblLevel.getFont().size + 2));

        // Criando botões
        btnDate = new Button(Images.imgCalenderGray);
        btnFrozen = new Button(Images.imgCalenderGray);
        btnHot = new Button(Images.imgHotGray);
        btnOff = new Button(Images.imgOffGray);

        // Criando slider button
        arcSlider = new ArcSlider();


        // Configurando o container
        setBackColor(Colors.BACKGROUD_DEFAULT);
        setBorderRadius(5);
        setBorderStyle(BORDER_RAISED);
        setBackColor(Color.WHITE);   

        // Configurando os botoes
        btnDate.transparentBackground = true;
        btnFrozen.transparentBackground = true;
        btnHot.transparentBackground = true;
        btnOff.transparentBackground = true;

        // Adicionando componentes ao container
        add(arcSlider, LEFT - 10, CENTER + 80, 250, 200);

        add(lblTempNow, LEFT + 75, SAME + 50);
        add(lblTemp, SAME + 15, SAME + 80);
        add(lblStatusTemp, SAME - 40, SAME + 20);

        add(btnDate, LEFT + 20, SAME + 30);
        add(btnHot, SAME + 50, SAME);
        add(btnFrozen, SAME + 50, SAME);
        add(btnOff, SAME + 50, SAME);

        add(lblLevel, LEFT + 60, SAME + 50);

        // Configurando tamanho do container
        //setRect(CENTER, CENTER, PREFERRED, PREFERRED);
        resize();
    }
}
