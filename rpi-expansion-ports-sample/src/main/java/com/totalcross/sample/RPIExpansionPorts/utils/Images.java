package com.totalcross.sample.RPIExpansionPorts.utils;

import totalcross.io.IOException;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class Images {
	public static Image crossy, input_white, yellow_led,blue_led,red_led,sensor,status_grey,status;

	private Images() {
	}

	public static void loadImages() {
		try {
            crossy = new Image("Images/crossy.png");
            input_white = new Image("Images/input_white.png");
            sensor = new Image("Images/sensor.png");
            status_grey = new Image("Images/status-grey.png");
            status = new Image("Images/status.png");

		} catch (ImageException | IOException e) {
			e.printStackTrace();
		}
	}
}