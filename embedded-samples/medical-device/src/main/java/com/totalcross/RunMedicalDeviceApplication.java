package com.totalcross;

import totalcross.TotalCrossApplication;

public class RunMedicalDeviceApplication {
    public static void main(String [] args) {
        TotalCrossApplication.run(MedicalDevice.class,  "/scr", "800x480");
    }
}
