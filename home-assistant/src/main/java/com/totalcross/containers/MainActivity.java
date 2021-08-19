package com.totalcross.containers;

import totalcross.ui.ScrollContainer;

public class MainActivity extends ScrollContainer{
   
    Home home;
    Temperature temperature;
    Security security;
    TemperatureStudy temperatureStudy;
    HomeMap homeMap;
    Spotify spotify;
    Demo demo;
    ScrollContainer container;
    Lights lights;
    Info info;
    Notify notification;
    Energy energy;
    Entertainment entertainment;
    DoorBell doorBell;

    @Override
  public void initUI() {
    
      setScrollBars(false, true);
      setBackForeColors(0xF7F7F7, 0x000000); 

      home = new Home();
      add(home, LEFT, TOP,PREFERRED,PREFERRED);
      home.resize();
     
      homeMap = new HomeMap();
      add(homeMap,SAME,AFTER, 410, 489,home);
      homeMap.resize();     
        
      security = new Security();
      add(security,AFTER,SAME,PREFERRED,PREFERRED,home);
      security.resize(); 
        
      spotify = new Spotify();
      add(spotify,AFTER - 22,SAME - 40, 300,200,security);
      spotify.resize();        
      
      temperature = new Temperature();
      add(temperature, SAME, AFTER,PREFERRED,PREFERRED,homeMap);
      temperature.resize();  
      
      info = new Info(); 
      add(info,AFTER, SAME,PREFERRED,PREFERRED,temperature); 
      info.resize();
      
      temperatureStudy = new TemperatureStudy();
      add(temperatureStudy,SAME, AFTER,PREFERRED,PREFERRED,info);
      temperatureStudy.resize(); 
      
      entertainment = new Entertainment();
      add(entertainment,AFTER, SAME,PREFERRED,PREFERRED,homeMap);
      entertainment.resize();  
      
      energy = new Energy();
      add(energy, AFTER,SAME,PREFERRED,PREFERRED,info);
      energy.resize();  

      doorBell = new DoorBell();
      add(doorBell, SAME,AFTER,PREFERRED,PREFERRED,temperature);
      doorBell.resize();

      lights = new Lights();
      add(lights, SAME + 10, AFTER,PREFERRED,PREFERRED,temperatureStudy);
      lights.resize(); 

      homeMap.setLights(lights);
      lights.setHomeMap(homeMap);
  }
}


