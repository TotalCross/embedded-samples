package com.totalcross.knowcode.printer.print;

import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Container;
import totalcross.ui.Control;

public class PrintTypeXML extends XMLPresenter {
    Container beforeScreen;

    public PrintTypeXML() {
        super(XmlContainerFactory.create("xml/PRINT TYPE.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Control color = ((XmlContainerLayout) content).getControlByID("@+id/printcolor");
        navigator.onClick(color, PrintCopiesXML.class);

        Control bw = ((XmlContainerLayout) content).getControlByID("@+id/printbw");
        navigator.onClick(bw, PrintCopiesXML.class);
    }
}
