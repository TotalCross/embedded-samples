package com.totalcross;

import com.totalcross.ui.MedicalHome;
import com.totalcross.util.Fonts;

import totalcross.sys.Settings;
import totalcross.ui.MainWindow;

public class MedicalDevice extends MainWindow {

    private static final String[] DAYS_OF_WEEK = { "SUN", "MON", "THU", "WED", "TUE", "FRI", "SAT" };

    public MedicalDevice() {
        setUIStyle(Settings.FLAT_UI);
        Fonts.loadFonts();
    }

    @Override
    public void initUI() {
        swap(new MedicalHome());
    }
}
