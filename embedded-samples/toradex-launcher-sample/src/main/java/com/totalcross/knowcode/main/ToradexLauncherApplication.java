package com.totalcross.knowcode.main;

import com.totalcross.knowcode.parse.SlidingNavigator;
import com.totalcross.knowcode.ui.XmlMainScreenPresenter;
import totalcross.sys.Settings;
import totalcross.ui.MainWindow;

public class ToradexLauncherApplication extends MainWindow {
    public ToradexLauncherApplication() {
        setUIStyle(Settings.FLAT_UI);
    }

    static {
        Settings.applicationId = "TCMT";
        Settings.appVersion = "1.0.0";
        Settings.iosCFBundleIdentifier = "com.totalcross.easytiful";
    }

    public void initUI() {
        try {
            new SlidingNavigator(this).present(XmlMainScreenPresenter.class);
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
