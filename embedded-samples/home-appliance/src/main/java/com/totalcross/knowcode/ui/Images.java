package com.totalcross.knowcode.ui;

import totalcross.ui.image.Image;

/**
 * This is for image initialization when app starts.
 */
public class Images {

	/*
	 * Declaring image variables.
	 */
	public static Image dayOffImage;
	public static Image dayOnImage;

	public static Image nightOffImage;
	public static Image nightOnImage;
	/**/

	/**
	 * Loads all application images.
	 */
	public static void loadImages() {
		// Trying the initialize images.
		try {
			dayOffImage = new Image("drawable/day_off.png");
			dayOnImage = new Image("drawable/day_on.png");

			nightOffImage = new Image("drawable/nigth_off.png");
			nightOnImage = new Image("drawable/nigth_on.png");
			/**/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
