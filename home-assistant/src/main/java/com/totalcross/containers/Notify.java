package com.totalcross.containers;

import com.totalcross.util.Colors;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.ScrollContainer;
import totalcross.ui.gfx.Color;

public class Notify extends  ScrollContainer {
   
    public Container ContainerMensagem;

    public Label lblTitle;
    public Label lblMensagem;
    public Label lblTime;

    public Button exit;

    @Override
    public void initUI() {

            setScrollBars(false, true);
            setBackForeColors(0xF7F7F7, 0x000000);
      
            ContainerMensagem = new Container();

            lblTitle = new Label("Motion Detected!");
            lblMensagem = new Label("There was motion detected in the backyard.");
            lblTime = new Label("5 horas atrás");

            exit = new Button("DISPENSAR");

            lblTitle.transparentBackground = true;
            lblMensagem.transparentBackground = true;
            lblTime.transparentBackground = true;

           /*  lblTitle.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 20));
            lblMensagem.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 10));
            lblTime.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 10)); */

            /* lblTitle.setBackColor(Color.BLACK);
            lblMensagem.setBackColor(Color.BLACK);
            lblTime.setBackColor(Color.BLACK);  */

            add(ContainerMensagem,CENTER,CENTER);

            ContainerMensagem.add(lblTitle, LEFT + 10 , TOP + 10);
            ContainerMensagem.add(lblMensagem, LEFT + 10 , AFTER + 10);
            ContainerMensagem.add(lblTime, LEFT + 80 , AFTER + 10);
            ContainerMensagem.add(exit, LEFT + 10 , AFTER + 10);

            // Configurando o container
            setBackColor(Colors.BACKGROUD_DEFAULT);
            setBorderRadius(5);
            setBorderStyle(BORDER_RAISED);
            setBackColor(Color.WHITE);

           // setRect(CENTER,CENTER, KEEP, KEEP);
            this.resize();
            
    }
}
