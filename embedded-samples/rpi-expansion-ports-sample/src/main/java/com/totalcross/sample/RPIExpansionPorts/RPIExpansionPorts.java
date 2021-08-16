package com.totalcross.sample.RPIExpansionPorts;

import com.totalcross.sample.RPIExpansionPorts.SerialExpansion.SerialExpansion;
import com.totalcross.sample.RPIExpansionPorts.ui.ShowContainer;
import com.totalcross.sample.RPIExpansionPorts.utils.Fonts;
import com.totalcross.sample.RPIExpansionPorts.utils.Images;
import com.totalcross.sample.RPIExpansionPorts.utils.MaterialConstants;
import totalcross.sys.Settings;
import totalcross.ui.MainWindow;
import totalcross.ui.event.UpdateListener;

public class RPIExpansionPorts extends MainWindow implements SerialExpansion.SerialXpansionCallback {

    SerialExpansion Conection;
    int refreshTime = 150;
    int elapsedRefreshTime = 0;
 
    
    
    UpdateListener updateListener = new UpdateListener() {

        public void updateListenerTriggered(int elapsedMiliseconds) {
            elapsedRefreshTime += elapsedMiliseconds;

            if (elapsedRefreshTime >= refreshTime) {
                if(MaterialConstants.command.size()>0){
                    String c=MaterialConstants.command.removeFirst();
                    Conection.PortConnectorSendCommand(c+"*");
 
                        elapsedRefreshTime = 0;
                        return;
                }
                else{
                System.out.println("comandos vazios");
                }

                elapsedRefreshTime = 0;
                
            }
        }
    };
    public RPIExpansionPorts() {
        super("RPIExpansionPorts", NO_BORDER);
        setUIStyle(Settings.MATERIAL_UI);
        
    }

    @Override
    public void callback(String d) {
        MainWindow.getMainWindow().runOnMainThread(new Runnable() {
            @Override
            public void run() {

                if (d.contains(":") && d.split(":").length==2) {
                    String[] aux = d.split(":"); // dividea string no ponto onde ouver ':'
                        MaterialConstants.feedback[Integer.parseInt(aux[0])]=aux[1];
                    
                }
            }
        });
    }

    @Override
    public void initUI() {
        Fonts.loadFonts();
        Images.loadImages();
        super.initUI();

        ShowContainer container = new ShowContainer();
        swap(container);
  

        Conection = new SerialExpansion(this);
        try {
            Conection.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(3000);

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        defineMode(2, 6, '1');
        defineMode(9, 9, '1');
        defineMode(7, 8, '0');
        defineMode(10, 19, '0');
        MainWindow.getMainWindow().addUpdateListener(updateListener);
        

    }

    public void defineMode(int in, int f, char mode) {
        for (int i = in; i <= f; i++) {
            MaterialConstants.command.add("#"+i+","+mode);
            
        }


    }


    
}
