package com.totalcross.knowcode.printer.copy;

import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Control;

public class CopyFinishingXML extends XMLPresenter {

    public CopyFinishingXML() {
        super(XmlContainerFactory.create("xml/COPY FINISHING.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Control done = ((XmlContainerLayout) content).getControlByID("@+id/done");
        done.addPressListener(this.navigator::home);

        Control ocopy = ((XmlContainerLayout) content).getControlByID("@+id/ocopy");
        navigator.onClick(ocopy, CopyXML.class);
    }
}