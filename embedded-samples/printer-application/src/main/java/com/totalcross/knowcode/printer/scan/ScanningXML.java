package com.totalcross.knowcode.printer.scan;

import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;
import com.totalcross.knowcode.parse.XMLPresenter;
import totalcross.ui.Control;
import totalcross.ui.Label;
import totalcross.ui.Spinner;
import totalcross.ui.event.TimerEvent;

public class ScanningXML extends XMLPresenter {
    TimerEvent time;

    public ScanningXML() {
        super(XmlContainerFactory.create("layout/SCANNING.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        startSpinner();
    }

    public void startSpinner() {
        time = content.addTimer(500);
        content.addTimerListener((e) -> {
            try {
                progress();
            } catch (InstantiationException | IllegalAccessException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        Spinner spinner = (Spinner) ((XmlContainerLayout) content).getControlByID("@+id/spinner");
        spinner.start();
    }

    public void progress() throws InstantiationException, IllegalAccessException {
        int progress2 = 0;
        Label progress = (Label) ((XmlContainerLayout) content).getControlByID("@+id/label");
        String temp = progress.getText();
        temp = temp.replace("%", "");
        progress2 = Integer.parseInt(temp);
        if (progress2 == 100) {
            navigator.present(ScanSendSaveXML.class);
            progress.setText("0%");
        } else {
            if(content.getX()==0) {
                progress2 += 10;
                temp = Integer.toString(progress2);
                temp += "%";
                progress.setText(temp);
            }
        }
    }
}
