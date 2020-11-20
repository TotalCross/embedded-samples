package com.totalcross.sample.RPIExpansionPorts.utils;

import java.util.LinkedList;
import totalcross.ui.Control;
import totalcross.util.UnitsConverter;

public class MaterialConstants {

	public static final int BORDER_SPACING = UnitsConverter.toPixels(16 + Control.DP);
	public static final int COMPONENT_SPACING = UnitsConverter.toPixels(8);
	public static final int EDIT_HEIGHT = UnitsConverter.toPixels(35 + Control.DP);
	public static LinkedList<String> command=  new LinkedList<String>();
	public static String[] feedback = new String[20];

}