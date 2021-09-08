package com.totalcross.containers;

import com.totalcross.util.Colors;

import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.SideMenuContainer;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class SideMenu extends Container {

    public void initUI() {
        SideMenuContainer.Item home = new SideMenuContainer.Item("Home", MaterialIcons._HOME, Color.DARK, () -> {
            return new MainActivity();
        });
        SideMenuContainer.Item demo = new SideMenuContainer.Item("Demo", MaterialIcons._ACCESSIBILITY, Color.DARK,
                () -> {
                    return new Demo();
                });
        SideMenuContainer.Item notify = new SideMenuContainer.Item("Notificação", MaterialIcons._NOTIFICATIONS,
                Color.DARK, () -> {
                    return new Notify();
                });

        SideMenuContainer sideMenu = new SideMenuContainer(null, home, notify, demo);

        sideMenu.topMenu.header = new Container() {
            public void initUI() {
                setBackColor(Colors.FROZEN_DEFAULT);

                Label title = new Label("Home Assistant", CENTER, Color.WHITE, false);
                title.setFont(Font.getFont(Font.DEFAULT, true, this.getFont().size + 6));
                title.setForeColor(Color.WHITE);
                add(title, LEFT + 25, BOTTOM - 45, PARENTSIZE + 40, DP + 56);
            }
        };

        sideMenu.setBarFont(Font.getFont(Font.getDefaultFontSize() + 2));
        sideMenu.setBackColor(0x4A90E2);
        sideMenu.setForeColor(Color.WHITE);
        sideMenu.setItemForeColor(Color.BLACK);
        sideMenu.topMenu.drawSeparators = false;
        sideMenu.topMenu.itemHeightFactor = 3;

        Icon icon = new Icon(MaterialIcons._MENU);
        icon.setBackColor(Color.BLACK);
        add(icon, CENTER + 20, TOP + 20);
        add(sideMenu, LEFT, TOP, PARENTSIZE, PARENTSIZE);
    }

}
