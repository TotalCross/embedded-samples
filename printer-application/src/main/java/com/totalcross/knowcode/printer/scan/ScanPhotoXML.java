package com.totalcross.knowcode.printer.scan;

import com.totalcross.knowcode.parse.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Control;

public class ScanPhotoXML extends XMLPresenter {
    public ScanPhotoXML() {
        super(XmlContainerFactory.create("layout/SCAN PHOTO.xml"));
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
