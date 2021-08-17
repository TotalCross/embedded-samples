package com.totalcross;
import totalcross.ui.MainWindow;
import totalcross.util.UnitsConverter;
import totalcross.ui.ImageControl;
import totalcross.sys.*;
import com.totalcross.util.Images;

import totalcross.ui.Container;
import totalcross.sys.Settings;
public class BinaryClockTC extends MainWindow {

    private ImageControl imageControl;
    private ImageControl ledSeconds1;
    private ImageControl ledSeconds2;
    private ImageControl ledSeconds3;
    private ImageControl ledSeconds4;
    private ImageControl ledSeconds5;
    private ImageControl ledSeconds6;
    private ImageControl ledMinutes1;
    private ImageControl ledMinutes2;
    private ImageControl ledMinutes3;
    private ImageControl ledMinutes4;
    private ImageControl ledMinutes5;
    private ImageControl ledMinutes6;
    private ImageControl ledHours1;
    private ImageControl ledHours2;
    private ImageControl ledHours3;
    private ImageControl ledHours4;
    private ImageControl ledHours5;
 
    static final int SIZE = 8;

    private int verification = 0;
    private int setSeconds = 0;
    private int setMinutes = 1;
    private int setHours = 1;
  

    private boolean[] positionsSeconds = new boolean[6];
    private boolean[] positionsMinutes = new boolean[6];
    private boolean[] positionsHours = new boolean[5];

    private String arrayHours[] = new String[3];
    private String getHours;
    private String getMinutes;
    private String getSeconds;
    

  
    public BinaryClockTC() {
        setUIStyle(Settings.MATERIAL_UI);
        setTitle("Binary Clock");
    }

    @Override
    public void initUI() { 
         Images.loadImage();

        imageControl = new ImageControl(Images.background);

        imageControl.scaleToFit = true;
        imageControl.strechImage = true;

        add(imageControl,LEFT,TOP,PARENTSIZE,PARENTSIZE); 

        SetHours();
        CreateLeds();

        Thread thread = new Thread(()->{
            Score();   
          });
          thread.start(); 

    }

    //Criando LED's
    public void CreateLeds(){

        Images.loadLed();
        ledHours1 = new ImageControl(Images.ledDark);
        ledHours2 = new ImageControl(Images.ledDark);
        ledHours3 = new ImageControl(Images.ledDark);
        ledHours4 = new ImageControl(Images.ledDark);
        ledHours5 = new ImageControl(Images.ledDark);
        ledMinutes1 = new ImageControl(Images.ledDark);
        ledMinutes2 = new ImageControl(Images.ledDark);
        ledMinutes3 = new ImageControl(Images.ledDark);
        ledMinutes4 = new ImageControl(Images.ledDark);
        ledMinutes5 = new ImageControl(Images.ledDark);
        ledMinutes6 = new ImageControl(Images.ledDark);
        ledSeconds1 = new ImageControl(Images.ledDark);
        ledSeconds2 = new ImageControl(Images.ledDark);
        ledSeconds3 = new ImageControl(Images.ledDark);
        ledSeconds4 = new ImageControl(Images.ledDark);
        ledSeconds5 = new ImageControl(Images.ledDark);
        ledSeconds6 = new ImageControl(Images.ledDark);

        //Criando botões
        Container container = new Container();
        add(container,CENTER,CENTER);

        container.add(ledHours1,LEFT,TOP);
        container.add(ledHours2,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledHours3,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledHours4,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledHours5,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        
        container.add(ledMinutes1,LEFT,AFTER + 10 );
        container.add(ledMinutes2,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledMinutes3,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledMinutes4,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledMinutes5,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledMinutes6,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);

        container.add(ledSeconds1,LEFT,AFTER + 10);
        container.add(ledSeconds2,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledSeconds3,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledSeconds4,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledSeconds5,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledSeconds6,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);

        container.resize();
        container.setRect(CENTER,CENTER,KEEP,KEEP);
        container.transparentBackground = true;
    }
    
    //Pegando a hora do sistema
    public void SetHours(){

       Time f24h = new Time();
          getHours = f24h.toString();

          for(int i = 0; i<3;i++){
            arrayHours = getHours.split(":");
          }
          getHours = arrayHours[0];
          getMinutes = arrayHours[1];
          getSeconds = arrayHours[2];
          setHours = Integer.parseInt(getHours);
          setMinutes = Integer.parseInt(getMinutes) + 1;
          setSeconds = Integer.parseInt(getSeconds) + 1;

          System.out.println(setHours);
          System.out.println(setMinutes);
          System.out.println(setSeconds);
    }
    
    //Verificando os segundos
    public void VerificationSeconds(){
        ledSeconds6.setImage(positionsSeconds[0] ?Images.ledRed:Images.ledDark);
        ledSeconds5.setImage(positionsSeconds[1] ?Images.ledRed:Images.ledDark);
        ledSeconds4.setImage(positionsSeconds[2] ?Images.ledRed:Images.ledDark);
        ledSeconds3.setImage(positionsSeconds[3] ?Images.ledRed:Images.ledDark);
        ledSeconds2.setImage(positionsSeconds[4] ?Images.ledRed:Images.ledDark);
        ledSeconds1.setImage(positionsSeconds[5] ?Images.ledRed:Images.ledDark);
    }
    
    //Verificando os minutos
    public void VerificationMinutes(){

        ledMinutes6.setImage(positionsMinutes[0] ?Images.ledRed:Images.ledDark);
        ledMinutes5.setImage(positionsMinutes[1] ?Images.ledRed:Images.ledDark);
        ledMinutes4.setImage(positionsMinutes[2] ?Images.ledRed:Images.ledDark);
        ledMinutes3.setImage(positionsMinutes[3] ?Images.ledRed:Images.ledDark);
        ledMinutes2.setImage(positionsMinutes[4] ?Images.ledRed:Images.ledDark);
        ledMinutes1.setImage(positionsMinutes[5] ?Images.ledRed:Images.ledDark);
    }
    
    //Verificando as horas
    public void VerificationHours(){
        ledHours5.setImage(positionsSeconds[0] ?Images.ledRed:Images.ledDark);
        ledHours4.setImage(positionsSeconds[1] ?Images.ledRed:Images.ledDark);
        ledHours3.setImage(positionsSeconds[2] ?Images.ledRed:Images.ledDark);
        ledHours2.setImage(positionsSeconds[3] ?Images.ledRed:Images.ledDark);
        ledHours1.setImage(positionsSeconds[4] ?Images.ledRed:Images.ledDark);         
    }  
    
    //Contando as horas
    public void Score(){

        while (true) {   
            //Contagem dos segundos
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if(verification == 0){
                for (int i = 0; i < 6; i++) {
                    positionsSeconds[i] = (((setSeconds >> i)&0x1)==1);
                    
                }
                for (int i = 5; i >=0; i--) {   
                   VerificationSeconds();
                }
                for (int i = 0; i < 6; i++) {
                    positionsMinutes[i] = (((setMinutes >> i)&0x1)==1);
                }
                for (int i = 5; i >=0; i--) {
                    VerificationMinutes();
                }
                for (int i = 0; i < 5; i++) {
                    positionsHours[i] = (((setHours >> i)&0x1)==1);
                    }
                   for (int i = 0; i < 4; i++) {
                       VerificationHours();
                      
                }
            verification++;
            }
            for (int i = 0; i < 6; i++) {
                positionsSeconds[i] = (((setSeconds >> i)&0x1)==1);
                
            }
            for (int i = 5; i >=0; i--) {   
               VerificationSeconds();
            }
            setSeconds++;
            setSeconds = setSeconds!=60?setSeconds:0;
            
            //Contagem dos minutos
            if(setSeconds == 60){
                for (int i = 0; i < 6; i++) {
                    positionsMinutes[i] = (((setMinutes >> i)&0x1)==1);
                }
                for (int i = 5; i >=0; i--) {
                    VerificationMinutes();
                   
                }
              
                setMinutes++;
                setMinutes = setMinutes!=60?setMinutes:0;
                //Contando horas
                    if(setMinutes == 59){
                        setMinutes = 1;
                      
                   for (int i = 0; i < 5; i++) {
                    positionsHours[i] = (((setHours >> i)&0x1)==1);
                    }
                   for (int i = 0; i < 4; i++) {
                       VerificationHours();
                   }
                
                   setHours++;
                   setHours = setHours!=24?setHours:0;
                    }
               }
            
        }
        
    }
}

