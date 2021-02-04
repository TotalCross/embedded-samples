package com.totalcross.knowcode.printer.scan;

import com.totalcross.knowcode.parse.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Control;

public class ScanFinishingXML extends XMLPresenter {

    public ScanFinishingXML() {
        super(XmlContainerFactory.create("layout/SCAN FINISHING.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Control done = ((XmlContainerLayout) content).getControlByID("@+id/done");
        done.addPressListener(this.navigator::home);

        Control oscan = ((XmlContainerLayout) content).getControlByID("@+id/oscan");
        navigator.onClick(oscan, ScanXML.class);
    }
}
