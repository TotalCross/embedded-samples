package com.totalcross.sample.dashboard.view;

import com.totalcross.sample.dashboard.util.Colors;
import com.totalcross.sample.dashboard.view.components.SideButtons;

import totalcross.sys.Settings;
import totalcross.ui.Container;
import totalcross.ui.Presenter;
import totalcross.ui.SlidingWindow;
import totalcross.ui.anim.ControlAnimation;
import totalcross.ui.anim.PathAnimation;
import totalcross.ui.anim.ControlAnimation.AnimationFinished;
import totalcross.util.UnitsConverter;

public abstract class SideMenuContainerView extends Container {

    private Container provider = new Container();
    static private SideButtons sideButtons = new SideButtons();

    public SideMenuContainerView() {
    }

    @Override
    public void initUI() {
        provider.setBackColor(Colors.COLOR_BLACK);
        add(sideButtons, LEFT, TOP, UnitsConverter.toPixels(DP + 104), PARENTSIZE);
        add(provider, AFTER, TOP, FILL, FILL);
        onView(provider);
        provider.setRect(Settings.screenWidth, KEEP, KEEP, KEEP);
        PathAnimation.create(provider, sideButtons.getX2(), provider.getY(), new AnimationFinished(){
        
            @Override
            public void onAnimationFinished(ControlAnimation anim) {
                provider.setRect(AFTER, TOP, FILL, FILL, sideButtons);
            }
        }, -1).start();

    }

    public abstract void onView(Container content);

}
