package com.totalcross.sample.RPIExpansionPorts;

import totalcross.TotalCrossApplication;

public class RunRPIExpansionPortsApplication {
    public static void main(String [] args) {
        TotalCrossApplication.run(RPIExpansionPorts.class, "/r", "5443444B5AAEEB90306B00E4","/scr", "720x480");
    }
}