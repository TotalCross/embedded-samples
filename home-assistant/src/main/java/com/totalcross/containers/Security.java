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

public class Security extends Container {
    private Label lblTitle;

    private Button btnSecurityHome;
    private Button btnSecurityStatus;
    private Button btnSecuritStop;

    private ImageControl imgSecurity;

    static final int SIZEC = 100;

    @Override
    public void initUI() {
        Images.loadSecurity();

        // Creating label security
        lblTitle = new Label("Security");

        // creating image
        imgSecurity = new ImageControl(Images.imgSecurityGreen);

        // Criando buttons
        btnSecurityStatus = new Button("Armar Ausente");
        btnSecurityHome = new Button("Armar em Casa");
        btnSecuritStop = new Button("DESARMAR");

        // Configuring Buttons
        btnSecurityHome.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, btnSecurityHome.getFont().size + 1));
        btnSecurityStatus.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, btnSecurityStatus.getFont().size + 1));
        btnSecuritStop.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, btnSecuritStop.getFont().size + 1));

        // Configuring labels
        lblTitle.transparentBackground = true;
        lblTitle.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, lblTitle.getFont().size + 10));

        // Configuring container
        setBackColor(Colors.BACKGROUD_DEFAULT);
        setBorderRadius(5);
        setBorderStyle(BORDER_RAISED);
        setBackColor(Color.WHITE);

        add(lblTitle, LEFT + 40, TOP + 10);
        add(imgSecurity, SAME + 350, SAME, lblTitle);
        add(btnSecurityHome, LEFT + 20, SAME + 70);
        add(btnSecurityStatus, SAME + 250, SAME);
        add(btnSecuritStop, LEFT + 180, TOP + 70);

        btnSecuritStop.setVisible(false);
        this.resize();

        ActionButton();
    }

    public void ActionButton() {
        btnSecurityHome.addPressListener((event) -> {
            imgSecurity.setImage(btnSecurityHome.isPressed() ? Images.imgSecurityGreen : Images.imgSecurityRed);
            btnSecurityHome.setVisible(false);
            btnSecurityStatus.setVisible(false);
            btnSecuritStop.setVisible(true);
        });

        btnSecurityStatus.addPressListener((event) -> {
            imgSecurity.setImage(btnSecurityHome.isPressed() ? Images.imgSecurityGreen : Images.imgSecurityRed);
            btnSecurityHome.setVisible(false);
            btnSecurityStatus.setVisible(false);
            btnSecuritStop.setVisible(true);
        });

        btnSecuritStop.addPressListener((event) -> {
            imgSecurity.setImage(!btnSecurityHome.isPressed() ? Images.imgSecurityGreen : Images.imgSecurityRed);
            btnSecurityHome.setVisible(true);
            btnSecurityStatus.setVisible(true);
            btnSecuritStop.setVisible(false);
        });
    }
}
