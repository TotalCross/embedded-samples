package com.totalcross.knowcode.ui;


import com.totalcross.knowcode.parse.XMLPresenter;
import totalcross.ui.Button;

public class XmlMainScreenPresenter extends XMLPresenter {

    public Button Multimidia;

    public Button GPU;

    public Button TC;

    @Override
    public void onPresent() {
        navigator.onClick(Multimidia, XMLMultiScreen.class);
        navigator.onClick(GPU, XMLGpuScreen.class);
        navigator.onClick(TC, XMLTCScreen.class);
    }
}
