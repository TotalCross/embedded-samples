package com.totalcross;

import totalcross.io.IOException;
import totalcross.sys.Settings;
import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Check;
import totalcross.ui.ComboBox;
import totalcross.ui.Control;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.ProgressBar;
import totalcross.ui.Switch;
import totalcross.ui.Window;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;

public class WindowOne extends Window{
    
    Button btnMain;

    Image img;

    ImageControl imgTC;

    Label lblWithBackground; 
    Label lblWithoutBackground; 
    Label lblLagger; 
    Label lblSmall; 

    Check check;

    ProgressBar progressBar;

    Switch subtitles;

    ComboBox cbnColor;

    Edit simpleEdit;
    public WindowOne(){
        setBackColor(Color.DARK);
    }

    public void onPopup(){
        try {
            CreateButton();
            CreateCheckBox();
            CreateImage();
            CreateLabel();
           // CreateProgressBar();
           CreateSwitch();
           CreateComboBox();
           CreateEdit();
        } catch (IOException | ImageException e) {
            e.printStackTrace();
        }
    }

    public void CreateButton(){
        try {
            
            btnMain = new Button("Main");
    
            try {   
                img = new Image("images/logo_oficial_vertical.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
       
            btnMain.setText("Main");
    
            /* Apenas cor de fundo */
            btnMain.setBackColor(Color.BLACK);
    
            //btnMain.setImage(img);
    
    
            /* Cor de fundo/ Cor da letra */
            btnMain.setBackForeColors(Color.BLACK, Color.WHITE);
            
            btnMain.setBorder(BORDER_ROUNDED);
    
            btnMain.borderColor = Color.WHITE;
    
            //btnMain.setEnabled(true);
    
            /*  Font/ BoldSyle/ Size*/
            //btnMain.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, btnMain.getFont().size + 10));
            //btnMain.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, btnMain.getFont().size + 10));
            btnMain.setFont(Font.getFont(Font.DEFAULT, true, 20));
    
           //btnMain.setVisible(true);
            btnMain.transparentBackground = true;
    
             // btnMain.addPressListener((event) -> {  
                 /* Window principal / Window que será aberta */ 
             //   KnowCode.getMainWindow().swap(new CheckBox());
           // });
    
    
          // add(btnMain, CENTER,CENTER,getPreferredWidth() <=  48  ? DP +  96: btnMain.getPreferredWidth(),DP +  54);
          // add(btnMain, CENTER,CENTER,getPreferredWidth() <=  24? DP +  48  : btnMain.getPreferredWidth(), DP +  27);
    
                /* X/Y/W/H */
           add(btnMain, LEFT + 20,TOP + 20,200,100);
     
        } catch (Exception e) {
           e.printStackTrace();
        }
       
    }

    public void CreateCheckBox(){
        try {
           
                check = new Check("Check!");
        
                check.checkColor = Color.BLACK;
                check.textColor = Color.WHITE;
                check.autoSplit = true;
                check.textLeftGap = 20;
                check.setChecked(true);

                add(check, AFTER + 20,SAME + 10,btnMain);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    public void CreateLabel (){

        try {
            lblWithBackground = new Label("With Backgroud");
            lblWithoutBackground = new Label("Without Background");
            lblLagger = new Label("Lagger");
            lblSmall = new Label("Small");
    
    
            lblWithBackground.setBackColor(Color.WHITE);
            lblWithoutBackground.transparentBackground = true;
            lblLagger.setFont(Font.getFont(Font.DEFAULT, false, 40));
            lblSmall.setFont(Font.getFont(Font.DEFAULT, false, 10));
    
            add(lblWithBackground, SAME + 10, AFTER,imgTC);
            add(lblWithoutBackground, SAME, AFTER + 10);
            add(lblLagger, SAME, AFTER + 10);
            add(lblSmall, SAME, AFTER + 10);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void CreateImage() throws IOException, ImageException{

        try {
            img = new Image("images/logo_oficial_vertical.png");
    
            imgTC = new ImageControl(img);
            
            imgTC.scaleToFit = true;
            imgTC.centerImage = true;
            imgTC.transparentBackground = true; 
    
            add(imgTC, LEFT + 20,TOP + 120, 200, 200);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void CreateProgressBar (){
        try {
            final int max = Settings.onJavaSE ? 2000 : 200;

            // vertical ones
            progressBar = new ProgressBar();
            progressBar.vertical = true;
            progressBar.max = max;
            progressBar.textColor = Color.BLUE;
            progressBar.setBackColor(Color.CYAN);
            progressBar.setForeColor(Color.GREEN);
            add(progressBar, RIGHT, AFTER , PREFERRED, FILL);


            onSwapFinished();
        } catch (Exception ee) {
           ee.printStackTrace();
        }
    }

    @Override
    public void onSwapFinished() {
        final int ini = Vm.getTimeStamp();
        repaintNow();
        // runs the bench test
        int max = progressBar.max;
        for (int i = max; --i >= 0;) {
            int v = progressBar.getValue();
            v = (v + 1) % (progressBar.max + 1);
            Control.enableUpdateScreen = false; // since each setValue below updates the screen, we disable it to let it paint all at once at the end
            progressBar.setValue(i);
            if (Settings.onJavaSE) {
                Vm.sleep(20);
            }
        }
    }
    
    public void CreateRadioButton (){

    }

    public void CreateSwitch (){
        // Instance a simple switch
        subtitles = new Switch();

        // Set the colors up
        subtitles.colorBallOn = Color.getRGB(0,150,136);
        subtitles.colorBarOn = Color.GREEN;
        subtitles.colorBallOn = Color.getRGB(241,241,241);
        subtitles.colorBarOff = Color.BLACK;
        subtitles.centerText = true;
        subtitles.setBackColor(Color.BLACK);

        // Positions the switch 
        add(subtitles, SAME, AFTER, PREFERRED, PREFERRED,check);
    }

    public void CreateComboBox (){
        cbnColor = new ComboBox();

        cbnColor.setBackForeColors(Color.BLACK, Color.WHITE);

        cbnColor.add("Black");
        cbnColor.add("Black");
        cbnColor.add("Black");
        cbnColor.add("Black");
        cbnColor.add("Black");
        cbnColor.add("Black");
        cbnColor.add("Black");
        cbnColor.add("Black");
        cbnColor.add("Black");
        cbnColor.add("Black");
  
        cbnColor.borderColor = Color.WHITE;
        cbnColor.setBorderStyle(BORDER_TOP);
        cbnColor.checkColor = Color.WHITE;
        cbnColor.setBorderRadius(20);

        add(cbnColor,SAME,AFTER,PREFERRED,PREFERRED,subtitles);
    }

    public void CreateSlider (){

    }

    public void CreateEdit (){
        try{
            simpleEdit = new Edit();
            simpleEdit.caption = "Text View";
            simpleEdit.transparentBackground = true;
            simpleEdit.captionColor = Color.BLACK;
            simpleEdit.setForeColor(Color.WHITE);
            simpleEdit.setMode(Edit.NORMAL);

            add(simpleEdit, SAME, AFTER,PREFERRED,PREFERRED,cbnColor);
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
}
