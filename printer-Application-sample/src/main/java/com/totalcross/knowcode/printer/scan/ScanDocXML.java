package com.totalcross.knowcode.printer.scan;

import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Control;

public class ScanDocXML extends XMLPresenter {

    public ScanDocXML() {
        super(XmlContainerFactory.create("xml/SCAN DOC.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Control scanb = ((XmlContainerLayout) content).getControlByID("@+id/scanb");
        navigator.onClick(scanb, ScanningXML.class);
    }
}
