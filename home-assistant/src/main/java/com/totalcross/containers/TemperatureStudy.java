package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import com.totalcross.util.Images;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.UnitsConverter;


public class TemperatureStudy extends Container{
   
    private static Label lblTitle;
    private  Label lblTemp;

    private String temp = "20";
    public static String DEFAULT_TEMP = "°C";

    static final int SIZEC = 100;

    private ImageControl imgEnergy;

   // Graphifc.Series<MyDate, Integer> TempGraphifc;

    @Override
    public void initUI() {

        Images.loadTemperatureStudy();

        //Criando imagem
        imgEnergy = new ImageControl(Images.imgEnergy);

        //Configurando imagem
        imgEnergy.transparentBackground = true;

        //Criando label
        lblTitle = new Label("Estudo de temperatura");
        lblTemp = new Label(temp + DEFAULT_TEMP);
    
        //Configurando label
        lblTitle.transparentBackground = true;
        lblTemp.transparentBackground = true;
        lblTitle.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTitle.getFont().size + 6));
        lblTemp.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTemp.getFont().size + 5));


        add(lblTitle, LEFT + 20, TOP + 10);
        add(lblTemp, SAME, SAME + 20);
        add(imgEnergy, LEFT + 200, TOP + 10);
       //temperatureStudy.add(graphicsTemp, LEFT + 20, TOP + 10);

         // Configurando o container
         setBackColor(Colors.BACKGROUD_DEFAULT);
         setBorderRadius(5);
         setBorderStyle(BORDER_RAISED);
         setBackColor(Color.WHITE);

       //Configurando container 
       //setRect(LEFT + 10, TOP + UnitsConverter.toPixels(DP + SIZEC), KEEP, KEEP);
        resize();

}     
/* 
    class MyDate implements Comparable<MyDate> {
        int date;
        int day;
        int month;
        String s = null;
        public static final int DAY = 0;
        public static final int MONTH = 1;
        public static final int WEEK = 2;
        public static int mode = DAY;
        public Date firstDay;
    
        public MyDate(int yyyyMMdd) {
            this.date = yyyyMMdd;
            this.day = this.date % 100;
            this.month = yyyyMMdd / 100 % 100;
            if (this.day == 1) {
                s = Date.monthNames[this.month].substring(0, 3);
            } else if (this.day == 10 || this.day == 19) {
                s = Integer.toString(this.day);
            }
        }
    
        public void changeMode(int mode) {
            MyDate.mode = mode;
            switch (mode) {
                case DAY:
                    if (this.day == 1) {
                        s = Date.monthNames[this.month].substring(0, 3);
                    } else if (this.day == 10 || this.day == 19) {
                        s = Integer.toString(this.day);
                    } else {
                        s = null;
                    }
                    break;
                case MONTH:
                    if (this.toDate().equals(firstDay) || this.day == 1) {
                        s = Date.monthNames[this.month].substring(0, 3);
                    } else {
                        s = null;
                    }
                    break;
                case WEEK:
                    if (exactlyXWeeksSinceDate(MyDate.firstDay)) {
                        s = weeksSinceDate(MyDate.firstDay);
                    } else {
                        s = null;
                    }
                    break;
            }
        }
    
        public String weeksSinceDate(Date date) {
            return date != null ? Integer.toString(date.subtract(this.toDate()) / 7) : null;
        }
    
        public boolean exactlyXWeeksSinceDate(Date date) {
            return date != null ? date.subtract(this.toDate()) % 7 == 0 : false;
        }
    
        public int compareTo(MyDate o) {
            return this.date - o.date;
        }
    
        public Date toDate() {
            int year = this.date / 10000;
            Date myDate = null;
            try {
                myDate = new Date(year + "-" + this.month + "-" + this.day, Settings.DATE_YMD);
            } catch (InvalidDateException e) {
                e.printStackTrace();
            }
            return myDate;
        }
    
        @Override
        public String toString() {
            return s;
        }
     */
} 
//}
