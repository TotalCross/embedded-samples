package com.totalcross.UI;

import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;
import com.totalcross.knowcode.parse.XMLPresenter;
import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.MainWindow;

public class Media extends XMLPresenter{
    public Media(){super(XmlContainerFactory.create("xml/Media.xml"));}
    @Override
    public void onPresent() {
        Button btPhone = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButtonPhone");
        Button btMedia = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButtonMus");
        Button btNavigation = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButtonNav");
        Button btOverView = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButtonOverView");
        navigator.onClick(btPhone, Phone.class);
        navigator.onClick(btMedia,Media.class);
        navigator.onClick(btNavigation, Navigation.class);
        navigator.onClick(btOverView, Calculating.class);
        
    }
}