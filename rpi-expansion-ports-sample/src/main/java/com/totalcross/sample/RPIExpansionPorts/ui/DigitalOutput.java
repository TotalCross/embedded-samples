package com.totalcross.sample.RPIExpansionPorts.ui;

import com.totalcross.sample.RPIExpansionPorts.utils.Colors;
import com.totalcross.sample.RPIExpansionPorts.utils.MaterialConstants;

import totalcross.ui.Switch;
import totalcross.sys.SpecialKeys;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.ScrollContainer;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.KeyEvent;
import totalcross.ui.event.KeyListener;
import totalcross.ui.event.PressListener;
import totalcross.ui.layout.VBox;

public class DigitalOutput extends Container {
    @Override
    public void initUI(){
        super.initUI();
        ScrollContainer sc = new ScrollContainer(true, true);
        sc.setBorderStyle(sc.BORDER_ROUNDED);

        sc.setBackForeColors(Colors.SHADOW,Colors.SHADOW);

        add(sc, LEFT, TOP, FILL, FILL);

        RPIExpansionPortsLabel L5= new RPIExpansionPortsLabel("OFF",4);
        RPIExpansionPortsLabel L6= new RPIExpansionPortsLabel("OFF",4);
        RPIExpansionPortsLabel L9= new RPIExpansionPortsLabel("OFF",4);
        
        
        Switch D5=new Switch();
        D5.colorBallOn = Colors.LED_ONE_CIRCLE;
        D5.colorBarOn = Colors.LED_ONE;
        D5.colorBallOff = Colors.OFF_CIRCLE;
        D5.colorBarOff = Colors.OFF;
        D5.transparentBackground=true;

        Edit PWM5 = new Edit("999");
        PWM5.setBackForeColors(Colors.WHITE,Colors.WHITE);
        PWM5.transparentBackground=true;
        PWM5.setMode(Edit.CURRENCY);
        PWM5.setKeyboard(Edit.KBD_NUMERIC);
        
        D5.addPressListener(new PressListener(){
        
            @Override
            public void controlPressed(ControlEvent e) {
                    
                    if (L5.getText().contains("OFF")) {
                        MaterialConstants.command.add("+5,254");
                        L5.setText("254");
                        PWM5.setValue("254");
                    } else {
                        MaterialConstants.command.add("+5,0");
                        L5.setText("OFF");
                        PWM5.clear();
                    }
                
            }
        }); 
      
        PWM5.addKeyListener(new KeyListener() {
            @Override
            public void specialkeyPressed(KeyEvent e) {
                if (e.key == SpecialKeys.ENTER) {
                    String s = PWM5.getText();
                    if(!L5.getText().contains("OFF")){
                        if(Integer.parseInt(s)>254){
                            PWM5.setValue("254"); 
                            s="254";            
                        }
                        MaterialConstants.command.add("+5,"+s);
                        L5.setText(s);
                    }
                    else
                    PWM5.clear();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void actionkeyPressed(KeyEvent e) {}
        });
        
        Switch D6=new Switch();//
        D6.colorBallOn = Colors.LED_TWO_CIRCLE;
        D6.colorBarOn = Colors.LED_TWO;
        D6.colorBallOff = Colors.OFF_CIRCLE;
        D6.colorBarOff = Colors.OFF;
        D6.transparentBackground=true;

        Edit PWM6 = new Edit("999");
        PWM6.setBackForeColors(Colors.WHITE,Colors.WHITE);
        PWM6.transparentBackground=true;
        PWM6.setMode(Edit.CURRENCY);
        PWM6.setKeyboard(Edit.KBD_NUMERIC);

        D6.addPressListener(new PressListener(){
        
            @Override
            public void controlPressed(ControlEvent e) {
                
                if (L6.getText().contains("OFF")) {
                    MaterialConstants.command.add("+6,254");
                    L6.setText("254");
                    PWM6.setValue("254");
                } else {
                    MaterialConstants.command.add("+6,0");
                    L6.setText("OFF");
                    PWM6.clear();
                }
        }
            
            
        });
              
        PWM6.addKeyListener(new KeyListener() {
            @Override
            public void specialkeyPressed(KeyEvent e) {
                if (e.key == SpecialKeys.ENTER) {
                    String s = PWM6.getText();
                    
                   if(!L6.getText().contains("OFF")){
                        if(Integer.parseInt(s)>254){
                            PWM6.setValue("254"); 
                            s="254";            
                        }
                        MaterialConstants.command.add("+6,"+s);
                        L6.setText(s);
                        
                    }
                    else
                    PWM6.clear();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void actionkeyPressed(KeyEvent e) {}
        });

        Switch D9=new Switch();//
        D9.colorBallOn = Colors.LED_THREE_CIRCLE;
        D9.colorBarOn = Colors.LED_THREE;
        D9.colorBallOff = Colors.OFF_CIRCLE;
        D9.colorBarOff = Colors.OFF;
        D9.transparentBackground=true;

        Edit PWM9 = new Edit("999");
        PWM9.setBackForeColors(Colors.WHITE,Colors.WHITE);
        PWM9.transparentBackground=true;
        PWM9.setMode(Edit.CURRENCY);
        PWM9.setKeyboard(Edit.KBD_NUMERIC);

        D9.addPressListener(new PressListener(){
        
            @Override
            public void controlPressed(ControlEvent e) {
                
                if (L9.getText().contains("OFF")) {
                    MaterialConstants.command.add("+9,254");
                    L9.setText("254");
                    PWM9.setValue("254");
                } else {
                    MaterialConstants.command.add("+9,0");
                    L9.setText("OFF");
                    PWM9.clear();
                }
                
            }
        });
       
        PWM9.addKeyListener(new KeyListener() {
            @Override
            public void specialkeyPressed(KeyEvent e) {
                if (e.key == SpecialKeys.ENTER) {
                    String s = PWM9.getText();
                    
                   
                    if(!L9.getText().contains("OFF")){
                        if(Integer.parseInt(s)>254){
                            PWM9.setValue("254"); 
                            s="254";            
                        }
                        MaterialConstants.command.add("+9,"+s);
                        L9.setText(s);
                    }
                    else
                    PWM9.clear();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void actionkeyPressed(KeyEvent e) {}
        });
     

        VBox ButD= new VBox(VBox.LAYOUT_STACK_CENTER, VBox.ALIGNMENT_STRETCH);
        ButD.add(new RPIExpansionPortsLabel("Yellow",4));
        ButD.add(D5);
        ButD.add(new RPIExpansionPortsLabel("Blue",4));
        ButD.add(D6);
        ButD.add(new RPIExpansionPortsLabel("Red",4));
        ButD.add(D9);
        ButD.transparentBackground=true;
        ButD.setSpacing(MaterialConstants.COMPONENT_SPACING/2);

        VBox PWM= new VBox(VBox.LAYOUT_FILL, VBox.ALIGNMENT_STRETCH);
        PWM.add(PWM5);
        PWM.add(PWM6);
        PWM.add(PWM9);
        PWM.transparentBackground=true;
        PWM.setSpacing(MaterialConstants.BORDER_SPACING);

        

        RPIExpansionPortsLabel Lvalue = new RPIExpansionPortsLabel("Intensity",1);
        sc.add(Lvalue,RIGHT-MaterialConstants.BORDER_SPACING, TOP+MaterialConstants.BORDER_SPACING,PREFERRED,PREFERRED);
        sc.add(new RPIExpansionPortsLabel("Leds",1),LEFT+MaterialConstants.BORDER_SPACING*3,SAME);

        sc.add(ButD,SAME,AFTER+MaterialConstants.BORDER_SPACING,(int)(sc.getWidth()*0.17),PREFERRED);

        sc.add(PWM,RIGHT-MaterialConstants.BORDER_SPACING,SAME,Lvalue.getWidth(),
        (MaterialConstants.COMPONENT_SPACING + MaterialConstants.EDIT_HEIGHT) * 3);
    }
}