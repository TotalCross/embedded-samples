package com.totalcross.coronachart;

import totalcross.TotalCrossApplication;

public class RunCoronaChartApplication {
    public static void main(String[] args) {
        TotalCrossApplication.run(CoronaChartApp.class,
                // "/scr", "1920x1280",
                // "/scr", "960x640",
                "/scr", "848x480");
    }
}
