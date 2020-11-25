package com.totalcross.knowcode.printer.scan;

import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Button;
import totalcross.ui.Control;

public class ScanXML extends XMLPresenter {

    public ScanXML() {
        super(XmlContainerFactory.create("xml/SCAN.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Button document = (Button) ((XmlContainerLayout) content).getControlByID("@+id/document");
        navigator.onClick(document, ScanDocXML.class);

        Button photo = (Button) ((XmlContainerLayout) content).getControlByID("@+id/photo");
        navigator.onClick(photo, ScanPhotoXML.class);
    }
}
