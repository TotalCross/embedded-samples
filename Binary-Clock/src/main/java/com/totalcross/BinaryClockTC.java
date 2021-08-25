package com.totalcross;

import totalcross.ui.MainWindow;
import totalcross.util.UnitsConverter;
import totalcross.ui.ImageControl;
import totalcross.ui.event.UpdateListener;
import totalcross.sys.*;
import com.totalcross.util.Images;

import totalcross.ui.Container;
import totalcross.sys.Settings;

public class BinaryClockTC extends MainWindow {

    private ImageControl imageControl;
    private ImageControl[] ledSeconds;
    private ImageControl[] ledMinutes;
    private ImageControl[] ledHours;

    int SIZE = 64;
    final int SPACING = 8;

    private int setSeconds = 0;
    private int setMinutes = 1;
    private int setHours = 1;

    private boolean[] positionsSeconds = new boolean[6];
    private boolean[] positionsMinutes = new boolean[6];
    private boolean[] positionsHours = new boolean[5];

    public BinaryClockTC() {
        setUIStyle(Settings.MATERIAL_UI);
        setTitle("Binary Clock");
    }

    @Override
    public void initUI() {
        Images.loadImages();

        if (MainWindow.getMainWindow().getWidth() < MainWindow.getMainWindow().getHeight())
            SIZE = 32;

        imageControl = new ImageControl(Images.background);
        imageControl.scaleToFit = true;
        imageControl.strechImage = true;

        add(imageControl, LEFT, TOP, FILL, FILL);

        setHours();
        createLeds();

        addUpdateListener(updateListener);
    }

    // creating the leds....
    public void createLeds() {

        ledHours = new ImageControl[5];

        for (int i = 0; i < ledHours.length; i++) {
            ledHours[i] = new ImageControl(Images.ledDark);
            ledHours[i].scaleToFit = true;
        }

        ledMinutes = new ImageControl[6];

        for (int i = 0; i < ledMinutes.length; i++) {
            ledMinutes[i] = new ImageControl(Images.ledDark);
            ledMinutes[i].scaleToFit = true;
        }

        ledSeconds = new ImageControl[6];

        for (int i = 0; i < ledSeconds.length; i++) {
            ledSeconds[i] = new ImageControl(Images.ledDark);
            ledSeconds[i].scaleToFit = true;
        }

        Container container = new Container();
        add(container, CENTER, CENTER);

        // empty container just to align in a right way all the leds....
        container.add(new Container(), LEFT, TOP, UnitsConverter.toPixels(DP + SIZE),
                UnitsConverter.toPixels(DP + SIZE));

        for (int i = 0; i < ledHours.length; i++) {
            container.add(ledHours[i], AFTER + UnitsConverter.toPixels(DP + SPACING), SAME, SAME, SAME);
        }

        container.add(ledMinutes[0], LEFT, AFTER + UnitsConverter.toPixels(DP + SPACING),
                UnitsConverter.toPixels(DP + SIZE), UnitsConverter.toPixels(DP + SIZE));
        for (int i = 1; i < ledMinutes.length; i++) {
            container.add(ledMinutes[i], AFTER + UnitsConverter.toPixels(DP + SPACING), SAME, SAME, SAME);
        }

        container.add(ledSeconds[0], LEFT, AFTER + UnitsConverter.toPixels(DP + SPACING),
                UnitsConverter.toPixels(DP + SIZE), UnitsConverter.toPixels(DP + SIZE));
        for (int i = 1; i < ledSeconds.length; i++) {
            container.add(ledSeconds[i], AFTER + UnitsConverter.toPixels(DP + SPACING), SAME, SAME, SAME);
        }

        container.resize();
        container.setRect(CENTER, CENTER, KEEP, KEEP);
        container.transparentBackground = true;
    }

    // getting the hour from the system...
    public void setHours() {

        Time f24h = new Time();

        setHours = f24h.hour;
        setMinutes = f24h.minute;
        setSeconds = f24h.second;
    }

    // Update leds representing seconds
    public void updateLedSeconds() {
        int i = 5;
        for (ImageControl ledSecond : ledSeconds) {
            ledSecond.setImage(positionsSeconds[i--] ? Images.ledRed : Images.ledDark);
        }
    }

    // Update leds representing minutes
    public void updateLedMinutes() {

        int i = 5;
        for (ImageControl ledMinute : ledMinutes) {
            ledMinute.setImage(positionsMinutes[i--] ? Images.ledRed : Images.ledDark);
        }
    }

    // Update leds representing hours
    public void updateLedHours() {
        int i = 4;
        for (ImageControl ledHour : ledHours) {
            ledHour.setImage(positionsHours[i--] ? Images.ledRed : Images.ledDark);
        }
    }

    int elapsedTime = 0;

    private UpdateListener updateListener = new UpdateListener() {

        @Override
        public void updateListenerTriggered(int elapsedMilliseconds) {

            elapsedTime += elapsedMilliseconds;

            if (elapsedTime > 1000) {
                elapsedTime = 0;

                setHours();
                for (int i = 0; i < 6; i++) {
                    positionsSeconds[i] = (((setSeconds >> i) & 0x1) == 1);
                }
                updateLedSeconds();

                for (int i = 0; i < 6; i++) {
                    positionsMinutes[i] = (((setMinutes >> i) & 0x1) == 1);
                }
                updateLedMinutes();

                for (int i = 0; i < 5; i++) {
                    positionsHours[i] = (((setHours >> i) & 0x1) == 1);
                }
                updateLedHours();
            }
        }
    };
}