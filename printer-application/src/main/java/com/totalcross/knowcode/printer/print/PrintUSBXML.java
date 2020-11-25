package com.totalcross.knowcode.printer.print;

import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Control;

public class PrintUSBXML extends XMLPresenter {
    public PrintUSBXML() {
        super(XmlContainerFactory.create("xml/PRINT FROM USB.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Control printb = ((XmlContainerLayout) content).getControlByID("@+id/print");
        navigator.onClick(printb, PrintTypeXML.class);
    }
}
