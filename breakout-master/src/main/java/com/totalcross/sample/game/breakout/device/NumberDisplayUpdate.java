package com.totalcross.sample.game.breakout.device;

import totalcross.sys.Settings;
import totalcross.sys.Vm;

public class NumberDisplayUpdate {

    private static NumberDisplayUpdate singleton = null;

    public static NumberDisplayUpdate getInstance() {
        if (singleton == null)
            singleton = new NumberDisplayUpdate();

        return singleton;
    }

    private int number = 0;
    private int lastNumber = 0;

    private NumberDisplayUpdate() {

        if (!Settings.platform.equalsIgnoreCase("linux_arm"))
            return;

        new Thread() {

            public void run() {

                while (true) {

                    // Process initialization
                    Process process = null;

                    try {
                        if (lastNumber != number) {
                            Vm.debug("starting updating number display");
                            process = Runtime.getRuntime().exec("python3 one_number_display.py " + number);
                            process.getOutputStream().write("".getBytes(), 0, "".getBytes().length); // write output
                                                                                                     // into

                            process.waitFor();

                            Vm.debug("finishing updating number display");
                        }

                        Thread.sleep(50);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void updateNumber(int a) {
        lastNumber = number;
        number = a;
    }

}