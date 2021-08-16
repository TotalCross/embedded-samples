package com.totalcross.knowcode.printer.copy;
import com.totalcross.knowcode.parse.XMLPresenter;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Button;
import totalcross.ui.Control;
import totalcross.ui.Label;

public class CopyOptionsXML extends XMLPresenter {
    public CopyOptionsXML() {
        super(XmlContainerFactory.create("layout/COPY OPTIONS.xml"));
    }

    @Override
    public void onPresent() {
        Control back = ((XmlContainerLayout) content).getControlByID("@+id/back");
        back.addPressListener(this.navigator::back);

        Control homeb = ((XmlContainerLayout) content).getControlByID("@+id/home");
        homeb.addPressListener(this.navigator::home);

        Label number = (Label) ((XmlContainerLayout) content).getControlByID("@+id/number");
        Button plus = (Button) ((XmlContainerLayout) content).getControlByID("@+id/plus");
        plus.addPressListener((e) -> {
            number.setText(Integer.toString(Integer.parseInt(number.getText()) + 1));
        });

        Button minus = (Button) ((XmlContainerLayout) content).getControlByID("@+id/minus");
        minus.addPressListener((e) -> {
            int copies = 0;
            copies = Integer.parseInt(number.getText()) - 1;
            if (copies <= 1) {
                number.setText("1");
            } else {
                number.setText(Integer.toString(copies));
            }
        });

        Button buttoncopy = (Button) ((XmlContainerLayout) content).getControlByID("@+id/bcopy");
        navigator.onClick(buttoncopy, CopyingXML.class);
    }
}