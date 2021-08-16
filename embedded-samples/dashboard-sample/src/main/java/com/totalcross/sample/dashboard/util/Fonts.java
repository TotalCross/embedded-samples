package com.totalcross.sample.dashboard.util;

import totalcross.sys.Settings;
import totalcross.ui.font.Font;

public class Fonts {
    public static Font MontserratBold17;
    public static Font MontserratMedium8;
    public static Font MontserratMedium14;
    public static Font MontserratRegular12;
    public static Font MontserratRegular14;
    public static Font MontserratRegular17;
    public static Font MontserratRegular19;
    public static Font MontserratRegular20;
    public static Font MontserratSemiBold12;
    public static Font MontserratExtraBold19;
    public static Font MontserratExtraBold24;
    public static Font MontserratLight7;


    public static void loadFonts(){
        if(Settings.onJavaSE) {

            MontserratBold17 = Font.getFont(17);
            MontserratMedium8 = Font.getFont(8);
            MontserratMedium14 = Font.getFont(14);
            MontserratRegular12 = Font.getFont(12);
            MontserratRegular14 = Font.getFont(14);
            MontserratRegular17 = Font.getFont( 17);
            MontserratRegular19 = Font.getFont(19);
            MontserratRegular20 = Font.getFont(20);
            MontserratSemiBold12 = Font.getFont(12);
            MontserratExtraBold19 = Font.getFont(19);
            MontserratExtraBold24 = Font.getFont(24);
            MontserratLight7 = Font.getFont(7);
        }
        else {
            
            MontserratBold17 = Font.getFont("Montserrat-Bold", false, 17);
            MontserratMedium8 = Font.getFont("Montserrat-Medium", false, 8);
            MontserratMedium14 = Font.getFont("Montserrat-Medium", false, 14);
            MontserratRegular12 = Font.getFont("Montserrat-Regular", false, 12);
            MontserratRegular14 = Font.getFont("Montserrat-Regular", false, 14);
            MontserratRegular17 = Font.getFont("Montserrat-Regular", false, 17);
            MontserratRegular19 = Font.getFont("Montserrat-Regular", false, 19);
            MontserratRegular20 = Font.getFont("Montserrat-Regular", false, 20);
            MontserratSemiBold12 = Font.getFont("Montserrat-SemiBold", false, 12);
            MontserratExtraBold19 = Font.getFont("Montserrat-ExtraBold", true, 19);
            MontserratExtraBold24 = Font.getFont("Montserrat-ExtraBold", true, 24);
            while(MontserratExtraBold24.fm.height < Settings.screenHeight * 4 / 100) {
                MontserratExtraBold24 = Font.getFont("Montserrat-ExtraBold", true, MontserratExtraBold24.size + 1);
            }
            MontserratLight7 = Font.getFont("Montserrat-Light", true, 7);
        }
	}

}