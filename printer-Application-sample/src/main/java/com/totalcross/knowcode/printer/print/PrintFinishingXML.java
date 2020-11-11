package com.totalcross.knowcode.printer.print;

import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Control;

public class PrintFinishingXML extends XMLPresenter {

    public PrintFinishingXML() {
        super(XmlContainerFactory.create("xml/PRINT FINISHING.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Control done = ((XmlContainerLayout) content).getControlByID("@+id/done");
        done.addPressListener(this.navigator::home);

        Control oscan = ((XmlContainerLayout) content).getControlByID("@+id/oprint");
        navigator.onClick(oscan, PrintXML.class);
    }
}
