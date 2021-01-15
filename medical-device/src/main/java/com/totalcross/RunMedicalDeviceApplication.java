package com.totalcross;

import totalcross.TotalCrossApplication;

public class RunMedicalDeviceApplication {
    public static void main(String [] args) {
        TotalCrossApplication.run(MedicalDevice.class, "/r", "5443444B5AAEEB90306B00E4", "/scr", "1024x768x60");
    }
}
