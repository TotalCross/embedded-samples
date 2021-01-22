package com.easyui;

import totalcross.ui.MainWindow;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;

import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.sys.Settings;

public class EasyUI extends MainWindow {

    public EasyUI() {
        setUIStyle(Settings.MATERIAL_UI);
    }

    int likes = 0;

    @Override
    public void initUI() {

        Container cont = XmlContainerFactory.create("layout/easyui.xml");
        MainWindow.getMainWindow().swap(cont);

        Button smileButton = (Button) ((XmlContainerLayout) cont).getControlByID("@+id/smile");
        Button sadButton = (Button) ((XmlContainerLayout) cont).getControlByID("@+id/sad");
        Button neutralButton = (Button) ((XmlContainerLayout) cont).getControlByID("@+id/neutral");

        Label likesLabel = (Label) ((XmlContainerLayout) cont).getControlByID("@+id/footer");

        smileButton.addPressListener(new PressListener() {

            @Override
            public void controlPressed(ControlEvent e) {
                likes += 2;
                likesLabel.setText(likes + " Likes");
            }

        });

        neutralButton.addPressListener(new PressListener() {

            @Override
            public void controlPressed(ControlEvent e) {
                likesLabel.setText(++likes + " Likes");
            }

        });

        sadButton.addPressListener(new PressListener() {

            @Override
            public void controlPressed(ControlEvent e) {
                likesLabel.setText(--likes + " Likes");
            }

        });

    }
}
