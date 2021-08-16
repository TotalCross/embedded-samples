package com.totalcross.UI;



import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;
import com.totalcross.knowcode.parse.XMLPresenter;
import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;

public class Phone extends XMLPresenter {
    public Phone() {super(XmlContainerFactory.create("xml/Phone.xml"));}
    @Override
    public void onPresent() {

        Label todaysDate = (Label) ((XmlContainerLayout) content).getControlByID("@+id/TextView3");
        Button bt1 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton10");
        Button bt2 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton11");
        Button bt3 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton3");
        Button bt4 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton7");
        Button bt5 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton2");
        Button bt6 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton5");
        Button bt7 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton4");
        Button bt8 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton12");
        Button bt9 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton");
        Button bt0 = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton9");
        Button btHashtag = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton6");
        Button btStar = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton8");
        Button bspace = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButton9");
        Edit ed = (Edit) ((XmlContainerLayout) content).getControlByID("@+id/EditText");
        Button btPhone = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButtonPhone");
        Button btMedia = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButtonMus");
        Button btNavigation = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButtonNav");
        Button btOverView = (Button) ((XmlContainerLayout) content).getControlByID("@+id/ImageButtonOverView");

        StringBuffer sb = new StringBuffer();
        bt0.addPressListener(e -> {
            sb.append("0");
            ed.setText(sb.toString());
        });
        bt1.addPressListener(e -> {
            sb.append("1");
            ed.setText(sb.toString());
        });
        bt2.addPressListener(e -> {
            sb.append("2");
            ed.setText(sb.toString());
        });
        bt3.addPressListener(e -> {
            sb.append("3");
            ed.setText(sb.toString());
        });
        bt4.addPressListener(e -> {
            sb.append("4");
            ed.setText(sb.toString());
        });
        bt5.addPressListener(e -> {
            sb.append("5");
            ed.setText(sb.toString());
        });
        bt6.addPressListener(e -> {
            sb.append("6");
            ed.setText(sb.toString());
        });
        bt7.addPressListener(e -> {
            sb.append("7");
            ed.setText(sb.toString());
        });
        bt8.addPressListener(e -> {
            sb.append("8");
            ed.setText(sb.toString());
        });
        bt9.addPressListener(e -> {
            sb.append("9");
            ed.setText(sb.toString());
        });
        btHashtag.addPressListener(e -> {
            sb.append("#");
            ed.setText(sb.toString());
        });
        btStar.addPressListener(e -> {
            sb.append("*");
            ed.setText(sb.toString());
        });
        bspace.addPressListener(e -> {
            sb.delete(0, sb.length());
            ed.setText(sb.toString());
        });

        navigator.onClick(btPhone, Phone.class);
        navigator.onClick(btMedia,Media.class);
        navigator.onClick(btNavigation, Navigation.class);
        navigator.onClick(btOverView, Calculating.class);


    }
}