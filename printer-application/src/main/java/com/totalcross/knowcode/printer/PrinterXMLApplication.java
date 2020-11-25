package com.totalcross.knowcode.printer;

import com.totalcross.knowcode.SlidingNavigator;
import totalcross.sys.Settings;
import totalcross.ui.MainWindow;

public class PrinterXMLApplication extends MainWindow {
    public PrinterXMLApplication() {
        setUIStyle(Settings.FLAT_UI);
    }

    static {
        Settings.applicationId = "TCMT";
        Settings.appVersion = "1.0.0";
        Settings.iosCFBundleIdentifier = "com.totalcross.easytiful";
    }

    public void initUI() {
        try {
            new SlidingNavigator(this).present(HomePresenter.class);
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
