package com.totalcross.util;

import totalcross.sys.Settings;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.image.Image;


public class Images {
	// Declaring the variables.
	public static Image iTotalCrossLogoVertical, iTotalCrossLogoHorizontal;
	public static Image iModbusButton, iAnalogInputButton, iAnalogOutputButton, iDigitalInputButton, iLedButton, iHomeButton;

	static double scale015 = Settings.isIOS() ? 1 : 0.15;
	static double scale010 = Settings.isIOS() ? 1 : 0.13;

	public static void loadImages() {
		try {
			// Trying the initialize the variables.
			iTotalCrossLogoVertical = new Image("images/logo_oficial_vertical.png");
			iTotalCrossLogoVertical = iTotalCrossLogoVertical.scaledBy(scale015, scale015);

			iTotalCrossLogoHorizontal = new Image("images/logo_oficial_horizontal_branca.png");
			iTotalCrossLogoHorizontal = iTotalCrossLogoHorizontal.scaledBy(scale010, scale010);
			iModbusButton = new Image("images/icone-01.png");
			iAnalogInputButton = new Image("images/icone-02.png");
			iAnalogOutputButton = new Image("images/icone-04.png");
			iDigitalInputButton = new Image("images/icone-03.png");
			iLedButton = new Image("images/icone-05.png");
			iHomeButton = new Image("images/icone-06.png");

		} catch (Exception e) {
			MessageBox.showException(e, true);
		}
	}

}