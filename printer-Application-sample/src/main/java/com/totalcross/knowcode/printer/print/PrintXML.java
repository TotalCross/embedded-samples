package com.totalcross.knowcode.printer.print;

import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Control;

public class PrintXML extends XMLPresenter {

    public PrintXML() {
        super(XmlContainerFactory.create("xml/PRINT.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Control phone = ((XmlContainerLayout) content).getControlByID("@+id/sendphone");
        navigator.onClick(phone, PrintPhoneXML.class);

        Control usb = ((XmlContainerLayout) content).getControlByID("@+id/sendusb");
        navigator.onClick(usb, PrintUSBXML.class);

        Control pc = ((XmlContainerLayout) content).getControlByID("@+id/sendpc");
        navigator.onClick(pc, PrintPCXML.class);
    }
}
