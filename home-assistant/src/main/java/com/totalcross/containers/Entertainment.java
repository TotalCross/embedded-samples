package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Images;

import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.ScrollBar;
import totalcross.ui.Slider;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class Entertainment extends Container {
    static final int SIZEC = 100;
    // public Container entretenimento;

    public Entertainment() {

    }

    public Label title, atividade, comutadorHDMI, entradaHDMI, volume, tempTV, desligarTV, txtDevice, txtAtiv,
            txtTempTV;
    public String[] services = { "PowerOFF", "Watch Fire TV", "YouTube", "SATV", "Watch Apple TV" };
    public String[] comutHDMI = { "AppleTV", "FireTV", "Shield" };
    public String[] entHDMI = { "imputHDMI1", "imputHDMI2", "imputHDMI3", "imputHDMI4" };
    public Slider vol;
    public Button desl;
    public ComboBox actiBox, comutBox, enterBox;
    public Icon ativIcon, comutIcon, entIcon, volIcon, temptvIcon, desligarIcon;
    public ImageControl imgHarmony;

    public void initUI() {

        title = new Label("Entretenimento");
        atividade = new Label("Atividade");
        comutadorHDMI = new Label("Comutador HDMI");
        entradaHDMI = new Label("Entrada HDMI");
        volume = new Label("Volume");
        tempTV = new Label("Tempo total de TV");
        desligarTV = new Label("Desligar televisão");
        txtDevice = new Label("Harmony");
        txtAtiv = new Label("YouTube ");
        txtTempTV = new Label("0,42 h ");

        title.setFont(Font.getFont("Times New Roman", true, title.getFont().size + 10));
        txtDevice.setFont(Font.getFont("Times New Roman", false, atividade.getFont().size + 2));
        txtAtiv.setFont(Font.getFont("Times New Roman", false, txtAtiv.getFont().size + 2));
        volume.setFont(Font.getFont("Times New Roman", false, txtAtiv.getFont().size - 1));
        tempTV.setFont(Font.getFont("Times New Roman", false, txtAtiv.getFont().size - 1));
        txtTempTV.setFont(Font.getFont("Times New Roman", false, txtAtiv.getFont().size - 1));
        desligarTV.setFont(Font.getFont("Times New Roman", false, txtAtiv.getFont().size - 1));

        atividade.setForeColor(0x808080);
        comutadorHDMI.setForeColor(0x808080);
        entradaHDMI.setForeColor(0x808080);

        actiBox = new ComboBox(services);
        comutBox = new ComboBox(comutHDMI);
        enterBox = new ComboBox(entHDMI);

        actiBox.borderColor = 0x000000;
        actiBox.setBorderStyle(BORDER_LOWERED);
        comutBox.borderColor = 0x000000;
        comutBox.setBorderStyle(BORDER_LOWERED);

        vol = new Slider(ScrollBar.HORIZONTAL);
        vol.setFont(Font.getFont(false, Font.NORMAL_SIZE));
        vol.appId = 1;
        vol.setLiveScrolling(true);
        vol.setBackColor(Colors.BACKGROUD_DEFAULT);
        vol.sliderColor = 0xADD8E6;
        vol.ticksColor = 0xFFFAFA;
        vol.circleColor = 0xADD8E6;
        vol.setPressColor(0xADD8E6);
        vol.invertDirection = true;
        vol.barHeight = 5;
        vol.setMaximum(100);
        vol.setMinimum(1);
        vol.setValue(20);
        vol.markerSize = 5;

        ativIcon = new Icon(MaterialIcons._SETTINGS_REMOTE);
        comutIcon = new Icon(MaterialIcons._SETTINGS_REMOTE);
        entIcon = new Icon(MaterialIcons._SETTINGS_REMOTE);
        volIcon = new Icon(MaterialIcons._VOLUME_UP);
        temptvIcon = new Icon(MaterialIcons._TRENDING_UP);
        desligarIcon = new Icon(MaterialIcons._POWER);

        ativIcon.setForeColor(0x007FFF);
        comutIcon.setForeColor(0x007FFF);
        entIcon.setForeColor(0x007FFF);
        volIcon.setForeColor(0x007FFF);
        temptvIcon.setForeColor(0x007FFF);
        desligarIcon.setForeColor(0x007FFF);

        desl = new Button("Executar");
        desl.setForeColor(0x007FFF);
        desl.transparentBackground = true;
        desl.setBorder(BORDER_NONE);
        desl.setFont(Font.getFont("Times New Roman", true, txtAtiv.getFont().size + 1));

        setBackColor(Colors.BACKGROUD_DEFAULT);
        setBorderRadius(5);
        setBorderStyle(BORDER_RAISED);
        setBackColor(Color.WHITE);

        Images.loadHarmony();

        imgHarmony = new ImageControl(Images.imgHarmony);

        imgHarmony.transparentBackground = true;

        add(title, LEFT + 10, TOP);
        add(imgHarmony, LEFT + 10, TOP + 50);
        add(txtDevice, LEFT + 80, TOP + 65);
        add(txtAtiv, RIGHT + 250, TOP + 65);
        add(ativIcon, LEFT + 25, AFTER + 80);
        add(atividade, AFTER + 5, SAME - 15);
        add(actiBox, SAME, SAME + 15, 200, 30);
        add(comutIcon, LEFT + 25, AFTER + 20);
        add(comutadorHDMI, AFTER + 5, SAME - 15);
        add(comutBox, SAME, SAME + 15, 200, 30);
        add(entIcon, LEFT + 25, AFTER + 20);
        add(entradaHDMI, AFTER + 5, SAME - 15);
        add(enterBox, SAME, SAME + 15, 200, 30);
        add(volIcon, LEFT + 25, AFTER + 20);
        add(volume, AFTER + 5, SAME);
        add(vol, RIGHT + 250, SAME, 70, PREFERRED);
        add(temptvIcon, LEFT + 25, AFTER + 20);
        add(tempTV, AFTER + 5, SAME);
        add(txtTempTV, RIGHT + 250, SAME);
        add(desligarIcon, LEFT + 25, AFTER + 20);
        add(desligarTV, AFTER + 5, SAME + 1);
        add(desl, RIGHT + 250, SAME - 5);

    }
}
