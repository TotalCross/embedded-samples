package com.totalcross.sample.dashboard;

import com.totalcross.sample.dashboard.view.*;
import com.totalcross.sample.dashboard.util.Images;
import com.totalcross.sample.dashboard.util.Colors;
import com.totalcross.sample.dashboard.util.Fonts;

import totalcross.ui.MainWindow;
import totalcross.ui.SideMenuContainer;
import totalcross.sys.Settings;

public class DashboardSample extends MainWindow {
    SideMenuContainer sideMenu;

    public DashboardSample() {
        setUIStyle(Settings.MATERIAL_UI);
        setBackColor(Colors.COLOR_BLACK);
        Settings.virtualKeyboard = true;
    }

    @Override
    public void initUI() {
        // Initializing the images.
        Images.loadImages();
        // Initializing the fonts.
        Fonts.loadFonts();

        swap(new HomeView());
    }
}
