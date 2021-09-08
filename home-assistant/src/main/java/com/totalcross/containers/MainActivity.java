package com.totalcross.containers;

import com.totalcross.HomeAssistant;
import totalcross.ui.ScrollContainer;

public class MainActivity extends ScrollContainer {

  private Home home;
  private Temperature temperature;
  private Security security;
  private TemperatureStudy temperatureStudy;
  private HomeMap homeMap;
  private Spotify spotify;
  private Lights lights;
  private Info info;
  private Entertainment entertainment;
  private DoorBell doorBell;

  @Override
  public void initUI() {
    setScrollBars(false, true);
    setBackForeColors(0xF7F7F7, 0x000000);

    if (HomeAssistant.getMainWindow().getWidth() < HomeAssistant.getMainWindow().getHeight())
      home = new Home();
    add(home, LEFT, TOP, PARENTSIZE, PARENTSIZE);
    home.resize();

    security = new Security();
    add(security, SAME, AFTER, PARENTSIZE, PARENTSIZE, home);
    security.resize();

    spotify = new Spotify();
    add(spotify, SAME, AFTER, PREFERRED + 500, PREFERRED + 220);
    spotify.resize();

    homeMap = new HomeMap();
    add(homeMap, SAME, AFTER, PREFERRED + 400, PREFERRED + 400, spotify);
    homeMap.resize();

    temperatureStudy = new TemperatureStudy();
    add(temperatureStudy, SAME, AFTER, PREFERRED, PREFERRED, homeMap);
    temperatureStudy.resize();

    temperature = new Temperature();
    add(temperature, SAME, AFTER, PREFERRED, PREFERRED, temperatureStudy);
    temperature.resize();

    info = new Info();
    add(info, SAME, AFTER, PREFERRED + 100, PREFERRED + 100, temperature);
    info.resize();

    entertainment = new Entertainment();
    add(entertainment, SAME, AFTER, PREFERRED, PREFERRED, info);
    entertainment.resize();

    doorBell = new DoorBell();
    add(doorBell, SAME, AFTER, PREFERRED, PREFERRED, entertainment);
    doorBell.resize();

    lights = new Lights();
    add(lights, SAME, AFTER, PREFERRED, PREFERRED, doorBell);
    lights.resize();

    homeMap.setLights(lights);
    lights.setHomeMap(homeMap);
  }  
}
