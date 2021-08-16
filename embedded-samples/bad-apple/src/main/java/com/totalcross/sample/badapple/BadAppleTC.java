package com.totalcross.sample.badapple;

import totalcross.ui.Button;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.event.UpdateListener;
import totalcross.ui.gfx.Graphics;

import totalcross.io.ByteArrayStream;
import totalcross.io.LineReader;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.sys.Vm;

public class BadAppleTC extends MainWindow {

    public BadAppleTC() {
        setUIStyle(Settings.MATERIAL_UI);
    }

    long timestamp = 0;
    int frames = 0;

    Label fps;
    Button start, stop, continueBtn;

    boolean stopAnimation = false;

    @Override
    public void initUI() {

        fps = new Label("Number of FPS");
        start = new Button("Start");
        stop = new Button("Stop");
        continueBtn = new Button("Continue");

        add(fps, RIGHT - 8, TOP + 8);
        add(start, RIGHT - 40, AFTER + 8, SAME, PREFERRED);
        add(stop, SAME, AFTER + 8, SAME, PREFERRED);
        add(continueBtn, SAME, AFTER + 8, SAME, PREFERRED);

        start.addPressListener(new PressListener() {

            @Override
            public void controlPressed(ControlEvent e) {
                i = 1;
                stopAnimation = false;
            }

        });

        stop.addPressListener(new PressListener() {

            @Override
            public void controlPressed(ControlEvent e) {
                stopAnimation = true;
            }

        });
        continueBtn.addPressListener(new PressListener() {

            @Override
            public void controlPressed(ControlEvent e) {
                stopAnimation = false;
            }

        });

        addUpdateListener(new UpdateListener() {

            @Override
            public void updateListenerTriggered(int elapsedMilliseconds) {
                repaintNow();
                ++frames;
                timestamp += elapsedMilliseconds;
                if (timestamp > 1000) {
                    fps.setText(frames + " FPS");
                    frames = 0;
                    timestamp = 0;
                }
            }

        });
    }

    private String fileName;
    private int i = 1;

    @Override
    public void onPaint(Graphics g) {
        super.onPaint(g);

        if (i == 6569) {
            i = 0;
            return;
        } else {

            if (!stopAnimation)
                i++;
        }

        fileName = "data/out (" + i + ").txt";

        // FileReader fr = null;
        // BufferedReader br = null;
        LineReader reader = null;
        ByteArrayStream bas = null;
        try {

            bas = new ByteArrayStream(Vm.getFile(fileName));
            reader = new LineReader(bas);

            String temp;

            int j = 0;

            while ((temp = reader.readLine()) != null) {
                String[] data = temp.split("\\s");
                int w = 0;
                while (w < data.length) {
                    int start = Convert.toInt(data[w++]);
                    int end = Convert.toInt(data[w++]);
                    g.drawLine(start, j, end, j);
                }

                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bas.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
