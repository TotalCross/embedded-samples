
package com.totalcross.knowcode;

import com.totalcross.knowcode.ui.HomeApplianceXML;

import totalcross.TotalCrossApplication;

/**
 * This is for run Launcher in JAVA simulator.
 */
public class HomeApplianceXMLApplication {

    /**
     * Main method, used to run application passing args for Launcher in simulator.
     * 
     * @param args
     */
    public static void main(String[] args) {
        /*
         * Runs the application in simulator with /scr specified resolution, it's
         * possible to specify /density too.
         */
        TotalCrossApplication.run(HomeApplianceXML.class, "/scr", "848x480"
        // , "/density", "1"
                , "/r", "5443444B5AAEEB90306B00E4");
    }
}
