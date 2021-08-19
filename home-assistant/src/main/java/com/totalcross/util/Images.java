package com.totalcross.util;

import totalcross.ui.image.Image;

import totalcross.ui.dialog.MessageBox;

public class Images {

    public static Image imgFrozenGray;
    public static Image imgFrozenBlue;
    public static Image imgCalenderGray;
    public static Image imgCalenderGreen;
    public static Image imgHotGray;
    public static Image imgHotOrange;
    public static Image imgOffGray;
    public static Image imgOffBlack;
    public static Image imgSpotify;
    public static Image imgSecurityGreen;
    public static Image imgSecurityRed;
    public static Image imgEnergy;
    public static Image imgSolarPower;
    public static Image imgEletricity;
    public static Image imgNonFossil;
    public static Image imgHomeEnergy;
    public static Image imgHarmony;
    public static Image imgMap;
    public static Image imgLigthBack;
    public static Image imgLigthYellow;
    public static Image imgCameraDireita;
    public static Image imgCameraEsquerda;
    
    public static void loadFrozen() {
        try {
            imgFrozenBlue = new Image("images/iconFrozenGray.png");
            // imgFrozenGray = new Image("images/iconFronzenBlule.png");

        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadCalender() {
        try {
            imgCalenderGray = new Image("images/iconCalenderGray.png");
            // imgCalenderGreen = new Image("images/iconCalenderGreen.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadHot() {
        try {
            imgHotGray = new Image("images/iconHotGray.png");
            // imgHotOrange = new Image("images/iconHotOrange.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadOff() {
        try {
            // imgOffBlack = new Image("images/iconOffBlack.png");
            imgOffGray = new Image("images/iconOffGray.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadSpotify() {
        try {
            imgSpotify = new Image("images/spotify.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadSecurity() {
        try {
            imgSecurityGreen = new Image("images/iconSecurityGreen.png");
            imgSecurityRed = new Image("images/iconSecurityRed.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadTemperatureStudy() {
        try {
            imgEnergy = new Image("images/iconPowerCharge.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
        
    public static void loadMap(){
        try {
            imgMap = new Image("images/mapa.png");
            imgLigthBack = new Image("images/lampBlack.png");
            imgLigthYellow = new Image("images/lampYellow.png");
            imgCameraDireita = new Image("images/cameraDireita.png");
            imgCameraEsquerda = new Image("images/cameraEsquerda.png");

        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadSolarPower() {
        try {
            imgSolarPower = new Image("images/SolarPower.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadEletricity() {
        try {
            imgEletricity = new Image("images/Eletricity.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadNonFossil() {
        try {
            imgNonFossil = new Image("images/Non-fossil.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadHomeEnergy() {
        try {
            imgHomeEnergy = new Image("images/homeEnergy.png");
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }

    public static void loadHarmony() {
        try {
            imgHarmony = new Image("images/Harmony.png");
            imgHarmony.scaledBy(1, 1);
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
}
