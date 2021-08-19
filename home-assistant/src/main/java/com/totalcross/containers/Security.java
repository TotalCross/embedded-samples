package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import com.totalcross.util.Images;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;



public class Security extends Container{

    public Label lblTitle;

    public Button btnSecurityHome;
    public Button btnSecurityStatus;
    public Button btnSecuritStop;

    public ImageControl imgSecurity;
    
    static final int SIZEC = 100;

    @Override
    public void initUI() {
     Images.loadSecurity();
      
        //Criando label security 
        lblTitle = new Label("Security");

        //Criando imagem
        imgSecurity = new ImageControl(Images.imgSecurityGreen);

        //Criando buttons
        btnSecurityStatus = new Button("Armar Ausente");
        btnSecurityHome = new Button("Armar em Casa");
        btnSecuritStop = new Button("DESARMAR");

        //Configurando Botões
        btnSecurityHome.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, btnSecurityHome.getFont().size + 1));
        btnSecurityStatus.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, btnSecurityStatus.getFont().size + 1));
        btnSecuritStop.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, btnSecuritStop.getFont().size + 1));

        //Configurando label 
        lblTitle.transparentBackground = true;
        lblTitle.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTitle.getFont().size + 10));

        // Configurando o container
        setBackColor(Colors.BACKGROUD_DEFAULT);
        setBorderRadius(5);
        setBorderStyle(BORDER_RAISED);
        setBackColor(Color.WHITE);


        add(lblTitle, LEFT + 20, TOP + 10 );
        add(imgSecurity, LEFT + 200, SAME);
        add(btnSecurityHome, LEFT + 10, SAME + 62);
        add(btnSecurityStatus, SAME + 140, SAME);
        add(btnSecuritStop, LEFT + 90, TOP + 70);

        btnSecuritStop.setVisible(false);
        this.resize();
    
       ActionButton();
    }      

    public void ActionButton(){
      
        btnSecurityHome.addPressListener((event) -> {
            imgSecurity.setImage( btnSecurityHome.isPressed() ? Images.imgSecurityGreen:Images.imgSecurityRed);
            btnSecurityHome.setVisible(false);
            btnSecurityStatus.setVisible(false);
            btnSecuritStop.setVisible(true);
        });

        btnSecurityStatus.addPressListener((event) -> {
            imgSecurity.setImage( btnSecurityHome.isPressed() ? Images.imgSecurityGreen:Images.imgSecurityRed);
            btnSecurityHome.setVisible(false);
            btnSecurityStatus.setVisible(false);
            btnSecuritStop.setVisible(true);
        });

        btnSecuritStop.addPressListener((event) -> {
            imgSecurity.setImage(!btnSecurityHome.isPressed()? Images.imgSecurityGreen:Images.imgSecurityRed);
            btnSecurityHome.setVisible(true);
            btnSecurityStatus.setVisible(true);
            btnSecuritStop.setVisible(false);
        });
    }
}


