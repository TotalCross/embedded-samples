package com.totalcross.knowcode.io.temperature;

import totalcross.io.LineReader;
import totalcross.io.Stream;
import totalcross.sys.Convert;
import totalcross.sys.InvalidNumberException;
import totalcross.sys.Settings;
import totalcross.sys.Vm;

/**
 * This is a reader that catch response of dht.py.
 * 
 */
public class DHTSensorReader {

    /**
     * Runs dht.py and returns it response.
     * 
     * @return
     */
    public String readTemp() {

        // Returns default 18 value if it's not running in a embedded device.
        if (!Settings.platform.equalsIgnoreCase("linux_arm"))
            return "18";

        // Input from program
        String readValue = "error";

        try {

            Vm.debug("starting read sensor");

            // Process initialization.
            final Process process = Runtime.getRuntime().exec("python3 dht.py");

            // Writes output into process.
            process.getOutputStream().write("".getBytes(), 0, "".getBytes().length);

            // Waits for dht response.
            process.waitFor();

            // Getts the lineReader for the process.
            final LineReader lineReader = new LineReader(Stream.asStream(process.getInputStream()));

            // Reads the response.
            readValue = lineReader.readLine();

            Vm.debug(readValue);
            Vm.debug("finishing read sensor");

        } catch (java.io.IOException e) {
            e.printStackTrace();
            readValue = "40";
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Returns the validated temp.
        return validateTemp(readValue);
    }

    /**
     * Validate the read value.
     * 
     * @param temp
     * @return
     */
    private String validateTemp(String temp) {
        try {
            if (temp == null || temp.equalsIgnoreCase("error") || temp.trim().equals("") || Convert.toInt(temp) < 20)
                return null;
        } catch (InvalidNumberException e) {
            e.printStackTrace();
        }

        return temp;
    }

}