package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;

import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class DoorBell extends Container {

    public DoorBell() {

    }

    // declarações
    public Label title, fDoor, fDMontion, fDLDing, fDLMotion, fDEstado, fDMEstado, fDLDtempo, fDLMtempo;
    public Icon fDoorIcon, fDMIcon, fDLDIcon, fDLMoIcon;

    public void initUI() {

        // setando labels
        title = new Label("Doorbell");
        fDoor = new Label("Front Door Ding");
        fDMontion = new Label("Front Door Motion");
        fDLDing = new Label("Front Door Last Ding");
        fDLMotion = new Label("Front Door Last Motion");
        fDEstado = new Label("Desocupado");
        fDMEstado = new Label("Desligado");
        fDLDtempo = new Label("06:44");
        fDLMtempo = new Label("13:21");

        // setando icones
        fDoorIcon = new Icon(MaterialIcons._HOME);
        fDMIcon = new Icon(MaterialIcons._DIRECTIONS_WALK);
        fDLDIcon = new Icon(MaterialIcons._HISTORY);
        fDLMoIcon = new Icon(MaterialIcons._HISTORY);

        // configurando container
        setBackColor(Colors.BACKGROUD_DEFAULT);
        setBorderRadius(5);
        setBorderStyle(BORDER_RAISED);
        setBackColor(Color.WHITE);

        // configurando icones
        fDoorIcon.setForeColor(Colors.FROZEN_DEFAULT);
        fDMIcon.setForeColor(Colors.FROZEN_DEFAULT);
        fDLDIcon.setForeColor(Colors.FROZEN_DEFAULT);
        fDLMoIcon.setForeColor(Colors.FROZEN_DEFAULT);

        // configurando labels
        title.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, title.getFont().size + 10));
        fDoor.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        fDMontion.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        fDEstado.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        fDMEstado.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        fDLDing.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        fDLDtempo.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        fDLMotion.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
        fDLMtempo.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));

        add(title, LEFT + 10, TOP);
        add(fDoorIcon, LEFT + 10, AFTER + 30);
        add(fDoor, AFTER + 10, SAME + 5);
        add(fDEstado, RIGHT_OF + 100, SAME);
        add(fDMIcon, LEFT + 12, AFTER + 10);
        add(fDMontion, AFTER + 10, SAME + 5);
        add(fDMEstado, RIGHT_OF + 90, SAME);
        add(fDLDIcon, LEFT + 8, AFTER + 10);
        add(fDLDing, AFTER + 10, SAME);
        add(fDLDtempo, RIGHT_OF + 75, SAME);
        add(fDLMoIcon, LEFT + 8, AFTER + 10);
        add(fDLMotion, AFTER + 10, SAME);
        add(fDLMtempo, RIGHT_OF + 65, SAME);

        this.resize();
    }
}
