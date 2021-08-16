package com.totalcross;

import totalcross.ui.MainWindow;
import totalcross.ui.Label;
import com.totalcross.knowcode.parse.SlidingNavigator;
import com.totalcross.UI.Calculating;
import com.totalcross.UI.Media;
import com.totalcross.UI.Navigation;
import com.totalcross.UI.Phone;

import totalcross.sys.Settings;
public class XmlApp extends MainWindow {
    
    public XmlApp() {
        setUIStyle(Settings.MATERIAL_UI);
    }

    @Override
    public void initUI() {
        
        try {
            new SlidingNavigator(this,0).present(Calculating.class);
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
