package com.totalcross;

import totalcross.ui.MainWindow;
import totalcross.sys.Settings;
import com.totalcross.util.Colors;
import com.totalcross.containers.SideMenu;
import com.totalcross.database.DatabaseManager;


public class HomeAssistant extends MainWindow {

    @SuppressWarnings("FieldCanBeLocal")
    private SideMenu sideMenu;

    public HomeAssistant() {
        setUIStyle(Settings.MATERIAL_UI);
        setBackColor(Colors.BACKGROUD_DEFAULT);
    }

    @Override
    public void initUI() {
        try {
            DatabaseManager.getInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        sideMenu = new SideMenu();
        add(sideMenu, LEFT, TOP, PARENTSIZE, PARENTSIZE);
    }

}
