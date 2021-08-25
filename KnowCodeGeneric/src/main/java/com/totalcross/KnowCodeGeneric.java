package com.totalcross;

import totalcross.ui.Button;
import totalcross.ui.MainWindow;
import totalcross.ui.gfx.Color;
import totalcross.sys.Settings;

public class KnowCodeGeneric extends MainWindow {
    
    WindowOne windowOne;

    public KnowCodeGeneric() {
        setUIStyle(Settings.MATERIAL_UI);
        setBackColor(Color.DARK);
    }

    @Override
    public void initUI() {

    windowOne = new WindowOne();
    windowOne.popup();
    

    }
}
