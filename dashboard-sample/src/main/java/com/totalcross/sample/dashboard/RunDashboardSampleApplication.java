package com.totalcross.sample.dashboard;

import totalcross.TotalCrossApplication;

public class RunDashboardSampleApplication {
    public static void main(String [] args) {
        TotalCrossApplication.run(DashboardSample.class, "/scr", "848x480x24");
    }
}
