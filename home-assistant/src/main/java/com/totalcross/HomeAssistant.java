package com.totalcross;

import totalcross.ui.MainWindow;
import totalcross.sys.Settings;


import com.totalcross.util.Colors;
import com.totalcross.containers.MainActivity;
import com.totalcross.containers.SideMenu;
import com.totalcross.database.DatabaseManager;

public class HomeAssistant extends MainWindow {

    MainActivity mainActivity;
    SideMenu sideMenu;
   
    public HomeAssistant() {
        setUIStyle(Settings.MATERIAL_UI);
        setBackColor(Colors.BACKGROUD_DEFAULT);
        try {
            DatabaseManager.getInstance();      
            
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }

    @Override
    public void initUI() {
        sideMenu = new SideMenu();
        add(sideMenu,LEFT, TOP,PARENTSIZE,PARENTSIZE);
    }

}
