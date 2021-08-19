package com.totalcross.containers;
import totalcross.ui.gfx.Color;
import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import com.totalcross.util.Images;

import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.font.Font;

public class HomeMap extends Container {
    public Container homeMap;
    public Button btnLRoom;
    public Button btnKitchen;
    public Button btnGarage;
    public Button btnLigthExternal;
    public Button btnDBell;
    
    private OnUpdateListener upd;

    public Button btnCamera1;
    public Button btnCamera2;
    public Button btnCamera3;
    public Button btnCamera4;

    public boolean isSwitchKitchen() {
        return switchKitchen;
    }

    public void setSwitchKitchen(boolean switchKitchen) {
        this.switchKitchen = switchKitchen;
    }

    public boolean isSwitchLRoom() {
        return switchLRoom;
    }

    public void setSwitchLRoom(boolean switchLRoom) {
        this.switchLRoom = switchLRoom;
    }

    public boolean isSwitchGarage() {
        return switchGarage;
    }

    public void setSwitchGarage(boolean switchGarage) {
        this.switchGarage = switchGarage;
    }

    public boolean isSwitchPorch() {
        return switchPorch;
    }

    public void setSwitchPorch(boolean switchPorch) {
        this.switchPorch = switchPorch;
    }

    public boolean isSwitchExternal() {
        return switchExternal;
    }

    public void setSwitchExternal(boolean switchExternal) {
        this.switchExternal = switchExternal;
    }

    private boolean switchKitchen = false;
    private boolean switchLRoom = false;
    private boolean switchGarage= false;
    private boolean switchPorch= false;
    private boolean switchExternal = false;

    public Button btnTempLadder;
    public Button btnTempRoom;
    
    public ImageControl imgMap;
    
    static final int SIZEC = 100;
    
    public String tempLadder = "21°C";
    public String tempRoom = "21°C";

    private Lights lights;

    
    @Override
    public void initUI() {

        try {
            
            Images.loadMap();
    
            imgMap = new ImageControl(Images.imgMap);
    
            btnLRoom = new Button(Images.imgLigthBack);
            btnKitchen= new Button(Images.imgLigthBack);
            btnGarage = new Button(Images.imgLigthBack);
            btnDBell = new Button(Images.imgLigthBack);
            btnLigthExternal = new Button(Images.imgLigthBack);
           
            btnCamera1 = new Button(Images.imgCameraDireita);
            btnCamera2 = new Button(Images.imgCameraEsquerda);
            btnCamera3 = new Button(Images.imgCameraEsquerda);
            btnCamera4 = new Button(Images.imgCameraDireita);
    
            btnTempLadder = new Button(tempLadder);
            btnTempRoom = new Button(tempRoom);
    
            btnLRoom.transparentBackground = true;
            btnKitchen.transparentBackground = true;
            btnGarage.transparentBackground = true;
            btnDBell.transparentBackground = true;
            btnLigthExternal.transparentBackground = true;
    
            btnCamera1.transparentBackground = true;
            btnCamera2.transparentBackground = true; 
            btnCamera3.transparentBackground = true; 
            btnCamera4.transparentBackground = true;
    
            btnLRoom.setBorder(BORDER_NONE);
            btnKitchen.setBorder(BORDER_NONE);
            btnGarage.setBorder(BORDER_NONE);
            btnDBell.setBorder(BORDER_NONE);
            btnLigthExternal.setBorder(BORDER_NONE);
    
            btnCamera1.setBorder(BORDER_NONE);
            btnCamera2.setBorder(BORDER_NONE);
            btnCamera3.setBorder(BORDER_NONE);
            btnCamera4.setBorder(BORDER_NONE);
    
            btnTempLadder.setBackForeColors(Color.BLACK, Color.WHITE);
            btnTempRoom.setBackForeColors(Color.BLACK, Color.WHITE);
            
            btnTempLadder.setForeColor(Color.WHITE);
            btnTempRoom.setForeColor(Color.WHITE);
    
            btnTempLadder.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 20));
            btnTempRoom.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 20));
    
            btnTempLadder.setBorder(BORDER_ROUNDED);
            btnTempRoom.setBorder(BORDER_ROUNDED);
    
            add(imgMap,CENTER,CENTER);
    
            add(btnLRoom,CENTER - 5,TOP + 130);
            add(btnGarage,CENTER + 110,CENTER + 70);
            add(btnKitchen,CENTER - 170,CENTER - 50);
            add(btnDBell,CENTER - 130,CENTER + 210);
            add(btnLigthExternal,CENTER + 140,CENTER + 170);
    
            add(btnCamera1,CENTER - 190,CENTER - 165);
            add(btnCamera2,CENTER + 184,CENTER - 165);
            add(btnCamera3,CENTER + 184,CENTER + 165);
            add(btnCamera4,CENTER - 190,CENTER + 205);
    
            add(btnTempLadder,CENTER - 5,CENTER - 35,43,43);
            add(btnTempRoom,CENTER - 8,CENTER + 150,43,43);
    
             // Configurando o container
             setBackColor(Colors.BACKGROUD_DEFAULT);
             setBorderRadius(5);
             setBorderStyle(BORDER_RAISED);
             setBackColor(Color.WHITE);
      
             this.resize();
             
            } catch (Exception e) {
                Vm.debug(e.toString());
                //e.printStackTrace();
        }
        ActionButtonHome();
       

    }  

    public void setLights(Lights lights){
        this.lights = lights;
        lights.setOnUpdate(()->{
            if(this.lights.isSwtK() == true){
                btnKitchen.setImage(Images.imgLigthYellow);
                btnKitchen.transparentBackground = true;
            }else{
                btnKitchen.setImage(Images.imgLigthBack);
                btnKitchen.transparentBackground = true;
            }
            if(this.lights.isSwtG()  == true){
                btnGarage.setImage(Images.imgLigthYellow);
                btnGarage.transparentBackground = true;
            }else{
                btnGarage.setImage(Images.imgLigthBack);
                btnGarage.transparentBackground = true;
            }
            if(this.lights.isSwtLR()  == true){
                btnLRoom.setImage(Images.imgLigthYellow);
                btnLRoom.transparentBackground = true;
            }else{
                btnLRoom.setImage(Images.imgLigthBack);
                btnLRoom.transparentBackground = true;
            }
            if(this.lights.isSwtP() == true){
                btnDBell.setImage(Images.imgLigthYellow);
                btnDBell.transparentBackground = true;
            }else{
                btnDBell.setImage(Images.imgLigthBack);
                btnDBell.transparentBackground = true;
            }   

            
        });

    }

    public void setOnUpdate(OnUpdateListener upd){
        this.upd = upd;
    }
    //controle de luzes
    public void ActionButtonHome(){
        btnLRoom.addPressListener((event) -> {
            if(switchLRoom == false){
                btnLRoom.setImage(Images.imgLigthYellow);
                btnLRoom.transparentBackground = true;
                switchLRoom = true;
                upd.onUpdate();
            }else{
                btnLRoom.setImage(Images.imgLigthBack);
                btnLRoom.transparentBackground = true;
                switchLRoom = false;
                upd.onUpdate();
            }
        });

        btnKitchen.addPressListener((event) -> {
            if(switchKitchen == false){
                btnKitchen.setImage(Images.imgLigthYellow); 
                btnKitchen.transparentBackground = true;
                switchKitchen = true;
                upd.onUpdate();
            }else{
                btnKitchen.setImage(Images.imgLigthBack); 
                btnKitchen.transparentBackground = true;
                switchKitchen = false;
                upd.onUpdate();
            }
            
            
            });
        btnGarage.addPressListener((event) -> {
            if(switchGarage == false){
                btnGarage.setImage(Images.imgLigthYellow);
                btnGarage.transparentBackground = true;
                switchGarage = true;
                upd.onUpdate();  
            }else{
                btnGarage.setImage(Images.imgLigthBack);
                btnGarage.transparentBackground = true;
                switchGarage = false;
                upd.onUpdate();
            }
        });
        btnLigthExternal.addPressListener((event) -> {
            if(switchExternal == false){
                btnLigthExternal.setImage(Images.imgLigthYellow);       
                btnLigthExternal.transparentBackground = true;
                switchExternal = true;
                
            }else{
                btnLigthExternal.setImage(Images.imgLigthBack);       
                btnLigthExternal.transparentBackground = true;
                switchExternal = false;
            }
            });
        btnDBell.addPressListener((event) -> {
            if(switchPorch == false){
                btnDBell.setImage(Images.imgLigthYellow);
                btnDBell.transparentBackground = true;
                switchPorch = true;
                upd.onUpdate(); 
            }else{
                btnDBell.setImage(Images.imgLigthBack);
                btnDBell.transparentBackground = true;
                switchPorch = false;
                upd.onUpdate();
            }
                });
    }
}
