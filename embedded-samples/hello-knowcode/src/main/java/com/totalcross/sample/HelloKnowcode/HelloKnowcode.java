package com.totalcross.sample.HelloKnowcode;

import com.totalcross.knowcode.parse.XmlContainerLayout;
import com.totalcross.knowcode.parse.CustomInitUI;
import com.totalcross.knowcode.parse.XmlContainerFactory;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;
import totalcross.sys.Convert;
import totalcross.sys.InvalidNumberException;
import totalcross.sys.Settings;

public class HelloKnowcode extends MainWindow {

	@Override
	public void initUI() {
		
		//Container cont = XmlContainerFactory.create("embeddedWorldSample.xml"); //The resolution have to be 1024x600 because of the absolute position of components 
		//MainWindow.getMainWindow().swap(cont);

		//Button plus and minus to embeddedWorldSample.xml
		//addPlusFuncionality("@+id/plus", "@+id/insideTempLabel", cont);
		//addMinusFuncionality("@+id/minus", "@+id/insideTempLabel", cont);		
		
		
		Container cont = XmlContainerFactory.create("simpleScreen.xml");
		XmlContainerLayout xmlContainerLayout = (XmlContainerLayout)cont;
		
		//xmlContainerLayout.setCustomInitUI(new MyScreenCustomization());
		
		xmlContainerLayout.setCustomInitUI(new CustomInitUI() {
			public void postInitUI(XmlContainerLayout contLayout) {
				Button btCancel = new Button("Cancel");
				btCancel.setBackColor(Color.BRIGHT);

				Control btRegister = contLayout.getControlByID("@+id/btRegister");
				btRegister.setBackColor(Color.BRIGHT);
				int posBtCancel = btRegister.getY()+btRegister.getHeight();
				
				Control progress = contLayout.getControlByID("@+id/progressBar");
				progress.setVisible(false);
				
				contLayout.add(btCancel, Container.CENTER, posBtCancel+2, btRegister.getWidth(), btRegister.getHeight());
			}
		});
		
		MainWindow.getMainWindow().swap(cont);
		
	}

	private void addMinusFuncionality(String bt, String label, Container container) {
		Control minusButton = ((XmlContainerLayout) container).getControlByID(bt);
		Label insideTempLabel = (Label) ((XmlContainerLayout) container).getControlByID(label);
		
		minusButton.addPressListener(new PressListener() {
			@Override
			public void controlPressed(ControlEvent e) {
				try {
					String tempString = insideTempLabel.getText();
					int temp;
					temp = Convert.toInt(tempString);
					insideTempLabel.setText(Convert.toString(--temp));
				} catch (InvalidNumberException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}

	private void addPlusFuncionality(String bt, String label, Container container) {
		Control plusButton = ((XmlContainerLayout) container).getControlByID(bt);
		Label insideTempLabel = (Label) ((XmlContainerLayout) container).getControlByID(label);

		plusButton.addPressListener(new PressListener() {
			@Override
			public void controlPressed(ControlEvent e) {
				try {
					String tempString = insideTempLabel.getText();
					int temp;
					temp = Convert.toInt(tempString);
					insideTempLabel.setText(Convert.toString(++temp));
				} catch (InvalidNumberException e1) {
					e1.printStackTrace();
				}
			}
		});		
	}

	private void changeColor(String string, Container container) {
		Control control = ((XmlContainerLayout) container).getControlByID(string);
		control.setBackColor(Color.BRIGHT);
		
	}

	public HelloKnowcode() {
		setUIStyle(Settings.MATERIAL_UI);
	}
}