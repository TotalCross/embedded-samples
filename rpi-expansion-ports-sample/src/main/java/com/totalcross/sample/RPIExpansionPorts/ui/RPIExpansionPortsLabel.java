package com.totalcross.sample.RPIExpansionPorts.ui;
import com.totalcross.sample.RPIExpansionPorts.utils.Fonts;
import java.math.BigDecimal;
import com.totalcross.sample.RPIExpansionPorts.utils.Colors;
import com.totalcross.sample.RPIExpansionPorts.utils.Images;
import com.totalcross.sample.RPIExpansionPorts.utils.MaterialConstants;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.event.UpdateListener;

public class RPIExpansionPortsLabel extends Label {
    private char type;
    private String port;
    int refreshTime = 200;
    int elapsedRefreshTime = 0;
    int idle = 0;
    ImageControl im;
    private boolean termoMode;

    UpdateListener updateListener = new UpdateListener() {

        public void updateListenerTriggered(int elapsedMiliseconds) {
            elapsedRefreshTime += elapsedMiliseconds;
            idle += elapsedMiliseconds;

            if (elapsedRefreshTime >= refreshTime) {

                String feedback = MaterialConstants.feedback[appId];
                if (feedback != "" && feedback != null) {
                    if (type == '>')
                    
                        if(im!=null){
                        if (feedback.equals("0")){
                            im.setImage(Images.status_grey);
                            setText("OFF");
                        }
                        else{
                            setText("ON");
                            im.setImage(Images.status);
                        }
                        }else{
                            if (feedback.equals("0"))
                            setText("OFF");
                            else
                            setText("ON");

                        }
                       
                        else{
                            if (termoMode){
                                setText(thermometer( feedback));
                            }
                            else{
                                setText(feedback);
                            }
                        }
                        MaterialConstants.command.add(type+port);                       
                        MaterialConstants.feedback[appId]="";
                        elapsedRefreshTime = 0;
                        idle=0;
                        return;
                    }
                    else if(elapsedRefreshTime>2000){
                        MaterialConstants.command.add(type+port);
                        idle=0;
                        return;
                    }
                    elapsedRefreshTime = 0;
                    
            }
        
                
        }
    };
	public RPIExpansionPortsLabel(String string,int type,ImageControl im) {
        super(string);
        termoMode=false;
        if(im!= null){
            this.im=im;
            this.im.transparentBackground=true;
            this.im.scaleToFit=true;
        }
        transparentBackground=true;
        setForeColor(Colors.FONT_COLOR);
        switch(type){
            case 1:
                setFont(Fonts.Title);
                break;
            case 2:
                setFont(Fonts.TextBold);
                break;
            case 3:
                setFont(Fonts.TextRegular);
                break;
            case 4:
                setFont(Fonts.Value);
                break;
            
        }
    }
    public RPIExpansionPortsLabel(String string,int type){
        this(string, type, null);
    }

	public void setSendCommand(char type,String port){
        this.type=type;
        this.port=port;
        MainWindow.getMainWindow().addUpdateListener(updateListener);
        MaterialConstants.feedback[appId]="0";


    }
    public void setTermoMode(){
        termoMode=true;
    }
    private String thermometer(String analog){
        double in= (double) Integer.parseInt(analog);
        if(in!=0){
            double Resistance=(double)(((1024.0*10000.0)/in) - 10000.0);
            double Temp = Math.log(Resistance);
            Temp = 1 / (0.001129148 + (0.000234125 * Temp) + (0.0000000876741 * Temp * Temp * Temp));
            Temp = Temp - 273.15;
            BigDecimal bd = new BigDecimal(Math.round(Temp));
            String result= (bd.toString());
            return result;
        }
        else
            return "0";
    }
}