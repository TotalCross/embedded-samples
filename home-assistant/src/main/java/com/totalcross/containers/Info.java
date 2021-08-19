package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;

import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class Info extends Container {
    public Info() {

    }

    public Container info;

    public Label lblInfo;
    public Label lblGngHome;
    public Label lblGngWork;
    public Label lblPlexSpy;
    public Label lblDolarconv;
    public Label tempGHome;
    public Label tempGWork;
    public Label watchspy;
    public Label dlconv;

    public Icon gWorkIcon;
    public Icon gHomeIcon;
    public Icon spyIcon;
    public Icon dolarConvIcon;

    static final int SIZEC = 100;

    public void initUI() {
        // configurar container
        info = new Container();
        info.setBackColor(Colors.BACKGROUD_DEFAULT);
        info.setBorderStyle(BORDER_RAISED);
        info.setBorderRadius(5);

        add(info, CENTER, TOP, 200, 200);

        // configurar label
        lblInfo = new Label("Informação");
        lblGngHome = new Label("indo para Casa");
        lblGngWork = new Label("indo para o Trabalho");
        lblPlexSpy = new Label("PlexSpy");
        lblDolarconv = new Label("USDREAL");
        tempGHome = new Label("40 min ");
        tempGWork = new Label("37 min ");
        watchspy = new Label("0 Watching ");
        dlconv = new Label("5,22 R$ ");

        lblInfo.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, lblInfo.getFont().size + 10));
        lblGngHome.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 14));
        lblGngWork.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 14));
        lblPlexSpy.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 14));
        lblDolarconv.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 14));
        tempGHome.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 14));
        tempGWork.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 14));
        watchspy.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 14));
        dlconv.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 14));

        // configurar icone
        gWorkIcon = new Icon(MaterialIcons._DIRECTIONS_CAR);
        gHomeIcon = new Icon(MaterialIcons._DIRECTIONS_CAR);
        spyIcon = new Icon(MaterialIcons._VISIBILITY);
        dolarConvIcon = new Icon(MaterialIcons._ATTACH_MONEY);

        gHomeIcon.setForeColor(0x6495ED);
        gWorkIcon.setForeColor(0x6495ED);
        spyIcon.setForeColor(0x6495ED);
        dolarConvIcon.setForeColor(0x6495ED);

        info.add(lblInfo, LEFT + 10, TOP);

        info.add(gWorkIcon, LEFT + 10, CENTER - 30);
        info.add(lblGngWork, LEFT + 50, CENTER - 30);
        info.add(tempGWork, RIGHT + 30, CENTER - 30);

        info.add(gHomeIcon, LEFT + 10, CENTER);
        info.add(lblGngHome, LEFT + 50, CENTER);
        info.add(tempGHome, RIGHT + 30, CENTER);

        info.add(spyIcon, LEFT + 8, CENTER + 30);
        info.add(lblPlexSpy, LEFT + 50, CENTER + 30);
        info.add(watchspy, RIGHT + 30, CENTER + 30);

        info.add(dolarConvIcon, LEFT + 12, BOTTOM - 30);
        info.add(lblDolarconv, LEFT + 50, BOTTOM - 30);
        info.add(dlconv, RIGHT + 30, BOTTOM - 30);

        info.setRect(CENTER, TOP, PREFERRED, PREFERRED);
        info.resize();

    }

}