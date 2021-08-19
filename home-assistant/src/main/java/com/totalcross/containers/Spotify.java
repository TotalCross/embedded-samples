package com.totalcross.containers;

import com.totalcross.util.*;
import totalcross.ui.Container;
import totalcross.util.UnitsConverter;
import totalcross.ui.ImageControl;

public class Spotify extends Container{
    
    public Container spotify;

    public ImageControl imgSpotify;

    static final int SIZEC = 100;

    @Override
    public void initUI() {
     
        Images.loadSpotify();

        spotify = new Container();
        add(spotify, CENTER, TOP + UnitsConverter.toPixels(DP + 30));

        imgSpotify = new ImageControl(Images.imgSpotify);

        // imgSpotify.scaleToFit = true;
        // imgSpotify.strechImage = true;

        add(imgSpotify, CENTER,CENTER);

        spotify.transparentBackground = true;

        this.resize();
    }     
}
