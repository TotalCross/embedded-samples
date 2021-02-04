package com.totalcross.knowcode.printer.copy;

import com.totalcross.knowcode.parse.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Control;

public class CopyXML extends XMLPresenter {

    public CopyXML() {
        super(XmlContainerFactory.create("layout/COPY.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Control bw = ((XmlContainerLayout) content).getControlByID("@+id/bw");
        navigator.onClick(bw, CopyOptionsXML.class);

        Control color = ((XmlContainerLayout) content).getControlByID("@+id/color");
        navigator.onClick(color, CopyOptionsXML.class);
    }
}
