package com.totalcross.sample.dashboard.view.components;

import com.totalcross.sample.dashboard.util.Colors;
import com.totalcross.sample.dashboard.util.Fonts;

import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.gfx.Graphics;
import totalcross.ui.image.Image;
import totalcross.ui.image.ImageException;
import totalcross.util.UnitsConverter;

public class SideMenuButton extends Button {
    Image image;
    String text;

    public SideMenuButton(String text, Image image) {
        setBackColor(0x373737);
        this.text = text;
        this.image = image;
        transparentBackground = true;
        setFont(Fonts.MontserratLight7);
        setForeColor(Colors.COLOR_WHITE);
    }

    @Override
    public int getPreferredWidth() {
        return UnitsConverter.toPixels(DP + 104) / UnitsConverter.toPixels(DP + 93) * Settings.screenHeight * 15 / 100;
    }

    @Override
    public int getPreferredHeight() {
        return Settings.screenHeight * 15 / 100;
    }

    @Override
    public void onPaint(Graphics g) {
        super.onPaint(g);

        int imgWidth = image.getWidth();
        int imgHeight = image.getHeight();
        int scale = (int) (height * 0.4);
        try {
            image = image.getSmoothScaledInstance(scale, scale);
        } catch (ImageException e) {
            e.printStackTrace();
        }
        

        int imgY = (int)((1.0 * UnitsConverter.toPixels(DP + 26) / UnitsConverter.toPixels(DP + 93)) * Settings.screenHeight*15/100);
        g.drawImage(image, (getWidth() - imgWidth) / 2, imgY);
        g.foreColor = Colors.COLOR_WHITE;
        g.drawText(text, (getWidth() - font.fm.stringWidth(text)) / 2,
                imgY + imgHeight + UnitsConverter.toPixels(DP + 9));
    }
}
