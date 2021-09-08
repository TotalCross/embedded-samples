package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;

import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class Info extends Container {

    private Container info;

    private Label lblInfo;
    private Label lblGngHome;
    private Label lblGngWork;
    private Label lblPlexSpy;
    private Label lblDolarconv;
    private Label tempGHome;
    private Label tempGWork;
    private Label watchspy;
    private Label dlconv;

    private Icon gWorkIcon;
    private Icon gHomeIcon;
    private Icon spyIcon;
    private Icon dolarConvIcon;

    static final int SIZEC = 100;

    public void initUI() {
        // configure container
        info = new Container();
        info.setBackColor(Colors.BACKGROUD_DEFAULT);
        info.setBorderStyle(BORDER_RAISED);
        info.setBorderRadius(5);

        add(info, CENTER, TOP, 200, 200);

        // set label
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

        info.add(lblInfo, LEFT + 50, TOP);
        info.add(gWorkIcon, LEFT + 40, AFTER);
        info.add(lblGngWork, SAME + 50, AFTER - 30);
        info.add(tempGWork, AFTER + 20, SAME, lblGngWork);

        info.add(gHomeIcon, LEFT + 40, AFTER);
        info.add(lblGngHome,  SAME + 50, AFTER - 30);
        info.add(tempGHome,  AFTER + 20, SAME, lblGngHome);

        info.add(spyIcon,  LEFT + 40, AFTER);
        info.add(lblPlexSpy, SAME + 50, AFTER - 30);
        info.add(watchspy,AFTER + 20, SAME, lblPlexSpy);

        info.add(dolarConvIcon, LEFT + 40, AFTER);
        info.add(lblDolarconv, SAME + 50, AFTER - 30);
        info.add(dlconv, AFTER + 20, SAME, lblDolarconv);

        //info.setRect(CENTER, TOP, PREFERRED, PREFERRED);
        info.resize();
    }
}