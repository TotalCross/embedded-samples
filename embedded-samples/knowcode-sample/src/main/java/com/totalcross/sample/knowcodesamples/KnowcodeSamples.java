package com.totalcross.sample.knowcodesamples;

import totalcross.ui.MainWindow;
import totalcross.ui.image.ImageException;

import com.totalcross.sample.knowcodesamples.ui.InicialScreen;
import com.totalcross.sample.knowcodesamples.ui.SplashWindow;

import totalcross.io.IOException;
import totalcross.sys.Settings;

public class KnowcodeSamples extends MainWindow {

    @Override
    public void initUI() {   
		SplashWindow sp = null;
		InicialScreen inicial = new InicialScreen();

		try {
			sp = new SplashWindow();
		} catch (IOException | ImageException e) {
			e.printStackTrace();
		}
		sp.popupNonBlocking();
		swap(inicial);
    }
    
    public KnowcodeSamples() {
        setUIStyle(Settings.MATERIAL_UI);
    }
}