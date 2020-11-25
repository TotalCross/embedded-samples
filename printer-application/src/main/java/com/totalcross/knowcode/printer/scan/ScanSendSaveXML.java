package com.totalcross.knowcode.printer.scan;

import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Control;

public class ScanSendSaveXML extends XMLPresenter {

    public ScanSendSaveXML() {
        super(XmlContainerFactory.create("xml/SCAN SEND-SAVE.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Control phone = ((XmlContainerLayout) content).getControlByID("@+id/sendphone");
        navigator.onClick(phone, ScanFinishingXML.class);

        Control usb = ((XmlContainerLayout) content).getControlByID("@+id/sendusb");
        navigator.onClick(usb, ScanFinishingXML.class);

        Control pc = ((XmlContainerLayout) content).getControlByID("@+id/sendpc");
        navigator.onClick(pc, ScanFinishingXML.class);
    }
}