package com.totalcross.knowcode.printer;

import com.totalcross.knowcode.XMLPresenter;
import com.totalcross.knowcode.printer.copy.CopyXML;
import com.totalcross.knowcode.printer.print.PrintXML;
import com.totalcross.knowcode.printer.scan.ScanXML;

import totalcross.ui.Button;

public class HomePresenter extends XMLPresenter {

    public Button bscan;

    public Button bprint;

    public Button bcopy;

    @Override
    public void onPresent() {
        navigator.onClick(bscan, ScanXML.class);
        navigator.onClick(bprint, PrintXML.class);
        navigator.onClick(bcopy, CopyXML.class);
    }
}
