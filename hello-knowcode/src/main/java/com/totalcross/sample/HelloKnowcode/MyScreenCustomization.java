package com.totalcross.sample.HelloKnowcode;

import com.totalcross.knowcode.parse.CustomInitUI;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.gfx.Color;

public class MyScreenCustomization implements CustomInitUI {

	@Override
	public void postInitUI(XmlContainerLayout arg0) {
		
		Button btCancel = new Button("Cancel");
		btCancel.setBackColor(Color.BRIGHT);


		
		Control btRegister = arg0.getControlByID("@+id/btRegister");
		btRegister.setBackColor(Color.BRIGHT);
		int posBtCancel = btRegister.getY()+btRegister.getHeight();
		
		Control progress = arg0.getControlByID("@+id/progressBar");
		progress.setVisible(false);
		
		arg0.add(btCancel, Container.CENTER, posBtCancel+2, btRegister.getWidth(), btRegister.getHeight());
	}
}

