package com.totalcross.sample.RPIExpansionPorts.SerialExpansion;

import java.io.IOException;
import java.util.LinkedList;
import totalcross.io.LineReader;
import totalcross.io.device.PortConnector;
import totalcross.util.concurrent.Lock;

public class SerialExpansion {
    
    private PortConnector pc;
    private LinkedList<String> data = new LinkedList<>();
    private final int CAPACITY = 100;
    private Lock lock = new Lock();

    SerialXpansionCallback callback;

    public String FeedBack;

    public SerialExpansion(SerialXpansionCallback callback) {
        this.callback = callback;
    }

    public void start() throws IOException {
        pc = new PortConnector(PortConnector.USB, 115200);
        LineReader lineReader = new LineReader(pc);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (lock) {
                            if (data.size() < CAPACITY) {
                                String input;
                                try {
                                    if ((input = lineReader.readLine()) != null) {
                                        data.add(input);
                                    }
                                } catch (totalcross.io.IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (lock) {
                            if (data.size() > 0) {
                            String s = data.removeFirst();
                            callback.callback(s);
                            }
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }

        }).start();
    }
       
    public static interface SerialXpansionCallback {
        void callback(String d);
    }

        public void PortConnectorSendCommand(String command) {

            try {
                pc.writeBytes(command);

            } catch ( totalcross.io.IOException ioe) {
                ioe.printStackTrace();
            }
        }

  
}