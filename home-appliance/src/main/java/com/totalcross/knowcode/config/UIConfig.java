package com.totalcross.knowcode.config;

/**
 * There are UI confs
 */
public abstract class UIConfig {

    private UIConfig() {

    }

    /**
     * Lightweight layout to low RAM devices
     */
    public static final String LIGHT_XML_LAYOUT = "xml/homeApplianceLightXML.xml";

    /**
     * Beautiful layout for more advanced devices
     */
    public static final String BEAUTIFUL_XML_LAYOUT = "xml/homeApplianceBeautifulXML.xml";

    /**
     * App XML layout that will be loaded by MainWindow
     */
    public static final String LAYOUT_TO_INITIALIZE = BEAUTIFUL_XML_LAYOUT;

}