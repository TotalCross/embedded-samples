package com.totalcross.sample.knowcodesamples.ui;

import com.totalcross.knowcode.parse.XmlContainerLayout;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.sample.knowcodesamples.util.*;

import totalcross.io.IOException;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;


public class InicialScreen extends Container {

	public InicialScreen() {
		this.setBackColor(Colors.PRIMARY);
	}

	public void initUI() {
		String pathLinearXml = "/xml/linearSample.xml";
		String pathRelativeXml = "/xml/relativeSample.xml";
		String pathAbsoluteXml = "/xml/embeddedWorldSample.xml";

		Images.loadImage();

		ImageControl background = new ImageControl(Images.background);
		background.scaleToFit = true;
		background.centerImage = true;
		background.hwScale = true;
		background.strechImage = true;
		add(background, LEFT, TOP, FILL, FILL);

		ImageControl logo = new ImageControl(Images.logo_nome_borda);
		logo.scaleToFit = true;
		logo.transparentBackground = true;
		add(logo, CENTER, TOP +  UnitsConverter.toPixels(16 + Control.DP), PARENTSIZE + 70, PARENTSIZE + 20);

		Container cont = new Container();
		cont.transparentBackground = true;
		add(cont, LEFT +  Constants.BORDER_SPACING, BOTTOM, FILL -  Constants.BORDER_SPACING, PARENTSIZE + 65);

		Label lbl = new Label("Choose the Android XML to be load");
		lbl.setFont(Fonts.latoBoldPlus10);
		lbl.transparentBackground = true;
		lbl.setForeColor(Colors.TEXT_ON_P);
		cont.add(lbl, CENTER, TOP + 15);

		/*LINEAR LAYOUT*/
		Button bt01 = new Button("Linear Layout Sample ", Button.BORDER_OUTLINED);
		bt01.setForeColor(Colors.PRIMARY);
		cont.add(bt01, CENTER, AFTER + (Constants.COMPONENT_SPACING)*2, PREFERRED, PREFERRED);

		bt01.addPressListener((e) -> {			
			Container container = XmlContainerFactory.create(pathLinearXml);
			MainWindow.getMainWindow().swap(container);

			/*Get Controls of XML by ID*/
			Control control = ((XmlContainerLayout) container).getControlByID("@+id/btRegister");
			control.setFont(Fonts.latoBoldDefaultSize);  

			/*Add back button*/
			try {
				createBackButton(container);
			} catch (IOException | ImageException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		/*CONSTRAINT WITH ABSOLUTE LAYOUT*/	
		Button bt02 = new Button("Constraint Absolute Layout Sample ", Button.BORDER_OUTLINED);
		bt02.setForeColor(Colors.PRIMARY);
		cont.add(bt02, CENTER, AFTER + (Constants.COMPONENT_SPACING)*2, PREFERRED, PREFERRED);
		bt02.addPressListener((e) -> {
			Container container = XmlContainerFactory.create(pathAbsoluteXml);
			MainWindow.getMainWindow().swap(container);

			/*Get Controls of XML by ID*/
			//Control control = ((XmlContainerLayout) container).getControlByID("@+id/btRegister");
			//control.setBackColor(Color.BLUE);  

			/*Add back button*/
			try {
				createBackButton(container);
			} catch (IOException | ImageException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		/*RELATIVE LAYOUT*/	
		Button bt03 = new Button("Relative Layout Sample ", Button.BORDER_OUTLINED);
		bt03.setForeColor(Colors.PRIMARY);
		cont.add(bt03, CENTER, AFTER + (Constants.COMPONENT_SPACING)*2, PREFERRED, PREFERRED);
		bt03.addPressListener((e) -> {
			Container container = XmlContainerFactory.create(pathRelativeXml);
			MainWindow.getMainWindow().swap(container);

			/*Get Controls of XML by ID*/
			//Control control = ((XmlContainerLayout) container).getControlByID("@+id/btRegister");
			//control.setBackColor(Color.BLUE);  

			/*Add back button*/
			try {
				createBackButton(container);
			} catch (IOException | ImageException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Button readMore = new Button("Read more", Button.BORDER_NONE);
		readMore.transparentBackground = true;
		readMore.setFont(Fonts.latoRegularDefaultSize);
		readMore.setForeColor(Color.WHITE);

		cont.add(readMore, CENTER, AFTER + Constants.COMPONENT_SPACING, PREFERRED, PREFERRED);

		readMore.addPressListener(new PressListener() {
			@Override
			public void controlPressed(ControlEvent e) {
				MessageBox mb = new MessageBox("", "Know Code Application\n\n"
						+ "Computer Vision and \n"
						+ "Android XML to Totalcross Parser\n\n"
						+"https://github.com/TotalCross/KnowCodeXML", new String[] { "Ok" });
				mb.setTextAlignment(CENTER);
				mb.setRect(CENTER, CENTER, SCREENSIZE+70 , SCREENSIZE+50);
				mb.setBackForeColors(Colors.ON_P_600, Colors.ON_P_300);
				mb.popup();
			}
		});
	}

	public void createBackButton(Container container) throws totalcross.io.IOException, ImageException {
		Button btVoltar = null;

		btVoltar = new Button(new Image("drawable/arrowgray.jpg"), Button.BORDER_ROUND);
		btVoltar.setForeColor(Colors.BACKGROUND_GRAY_01);

		container.add(btVoltar, LEFT, BOTTOM);
		btVoltar.addPressListener((e) -> {
			InicialScreen scr1 = new InicialScreen();

			MainWindow.getMainWindow().swap(scr1);
		});

	}

}
