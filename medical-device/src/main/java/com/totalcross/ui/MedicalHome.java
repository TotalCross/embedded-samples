package com.totalcross.ui;

import com.totalcross.knowcode.parse.CustomInitUI;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;
import com.totalcross.ui.components.SemiCircleProgress;
import com.totalcross.util.Positioning;

import totalcross.sys.Settings;
import totalcross.sys.Time;
import totalcross.ui.*;
import totalcross.ui.anim.ControlAnimation;
import totalcross.ui.anim.PathAnimation;
import totalcross.ui.event.DragEvent;
import totalcross.ui.event.PenEvent;
import totalcross.ui.event.PenListener;
import totalcross.ui.font.Font;
import totalcross.util.Date;

public class MedicalHome extends Container {

    public static int pulseValue = 110;
    public static int pulseMinValue = 50;
    public static int pulseMaxValue = 130;
    public static int oxygenValue;
    public static int oxygenMaxValue;
    private static Date date = new Date();
    private static Time time = new Time();
    private Container container;
    private static final String[] DAYS_OF_WEEK = { "SUN", "MON", "THU", "WED", "TUE", "FRI", "SAT" };

    @Override
    public void initUI() {
        container = XmlContainerFactory.create("xml_files/medical_home.xml");
        XmlContainerLayout containerLayout = (XmlContainerLayout) container;
        containerLayout.setCustomInitUI(new CustomInitUI() {

            @Override
            public void postInitUI(XmlContainerLayout container) {
                Container medicalPulse = new MedicalPulse(MedicalHome.this.container);
                add(medicalPulse,Settings.screenWidth,TOP,PARENTSIZE,PARENTSIZE);
                Container medicalOxygen = new MedicalOxygen(MedicalHome.this.container);
                add(medicalOxygen,-Settings.screenWidth,TOP,PARENTSIZE,PARENTSIZE);
                // Fonts
                Control font;
                font = container.getControlByID("@+id/oxygenTopLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                font = container.getControlByID("@+id/timeLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                font = container.getControlByID("@+id/oxygenLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                font = container.getControlByID("@+id/percentLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                font = container.getControlByID("@+id/oxygenMinMaxLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                container.getControlByID("@+id/lungsLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                container.getControlByID("@+id/pulseTopLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                font = container.getControlByID("@+id/pulseLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                font = container.getControlByID("@+id/pulseMinMaxLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                font = container.getControlByID("@+id/heartLabel");
                font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
                Divider oxygenDivider = new Divider();
                oxygenDivider.setBackColor(0x00A8DB);
                Divider pulseDivider = new Divider();
                pulseDivider.setBackColor(0xFF0000);
/*                container.add(oxygenDivider, Positioning.getWidthDP(89), Positioning.getHeightDP(388),
                        Positioning.getWidthDP(55), Positioning.getHeightDP(1));
                container.add(pulseDivider, Positioning.getWidthDP(803), Positioning.getHeightDP(388),
                        Positioning.getWidthDP(55), Positioning.getHeightDP(1));*/
                Label dateLabel = (Label) container.getControlByID("@+id/timeLabel");
                dateLabel.setText(time.toString().substring(0, 5) + " - " + DAYS_OF_WEEK[date.getDayOfWeek()] + ", "
                        + date.toString().substring(0, date.toString().length() - 4)
                        + date.toString().substring(date.toString().length() - 2, date.toString().length()));
                container.add(dateLabel);
                SemiCircleProgress oxygenSemiCircleProgress = new SemiCircleProgress(20, 99, 84,
                        SemiCircleProgress.LEFT);
                oxygenSemiCircleProgress.setFilledColor(0x00A8DB);
                oxygenSemiCircleProgress.setUnfilledColor(0x1A5364);
                oxygenSemiCircleProgress.setUseGradient(true);
                oxygenSemiCircleProgress.setGradientBack(0x22202A);
                oxygenSemiCircleProgress.setGradientFore(0x142D3B);
                container.add(oxygenSemiCircleProgress, Positioning.getWidthDP(255), Positioning.getHeightDP(96),
                        Positioning.getWidthDP(211), Positioning.getHeightDP(448));
                SemiCircleProgress pulseSemiCircleProgress = new SemiCircleProgress(20, 99, 84,
                        SemiCircleProgress.RIGHT);
                pulseSemiCircleProgress.setFilledColor(0xFF0000);
                pulseSemiCircleProgress.setUnfilledColor(0x55474D);
                pulseSemiCircleProgress.setUseGradient(true);
                pulseSemiCircleProgress.setGradientBack(0x241F28);
                pulseSemiCircleProgress.setGradientFore(0x321218);
                container.add(pulseSemiCircleProgress, Positioning.getWidthDP(495), Positioning.getHeightDP(96),
                        Positioning.getWidthDP(211), Positioning.getHeightDP(448));
                container.add(container.getControlByID("@+id/lungsImage"));
                container.add(container.getControlByID("@+id/lungsLabel"));
                container.add(container.getControlByID("@+id/heartImage"));
                container.add(container.getControlByID("@+id/heartLabel"));
                oxygenSemiCircleProgress.addPenListener(new PenListener() {

                    @Override
                    public void penDown(PenEvent pe) {
                        if (!Settings.fingerTouch || !hadParentScrolled()) {
                            PathAnimation.create(MedicalHome.this.container, Settings.screenWidth, 0, new ControlAnimation.AnimationFinished(){
                                @Override
                                public void onAnimationFinished(ControlAnimation anim) {
                                    MedicalHome.this.container.setRect(Settings.screenWidth, KEEP, SCREENSIZE, KEEP);
                                }
                            }, 1500).with(
                                    PathAnimation.create(medicalOxygen,0,0,new ControlAnimation.AnimationFinished(){
                                        @Override
                                        public void onAnimationFinished(ControlAnimation anim) {
                                            medicalOxygen.setRect(0, TOP, FILL, FILL);
                                        }
                                    }, 1500)).start();
                        }
                    }

                    @Override
                    public void penDrag(DragEvent arg0) {
                    }

                    @Override
                    public void penDragEnd(DragEvent arg0) {
                    }

                    @Override
                    public void penDragStart(DragEvent arg0) {
                    }

                    @Override
                    public void penUp(PenEvent pe) {
                        if (!Settings.fingerTouch || !hadParentScrolled()) {
                            PathAnimation.create(MedicalHome.this.container, Settings.screenWidth, 0, new ControlAnimation.AnimationFinished(){
                                @Override
                                public void onAnimationFinished(ControlAnimation anim) {
                                    MedicalHome.this.container.setRect(Settings.screenWidth, KEEP, SCREENSIZE, KEEP);
                                }
                            }, 1500).with(
                                    PathAnimation.create(medicalOxygen,0,0,new ControlAnimation.AnimationFinished(){
                                        @Override
                                        public void onAnimationFinished(ControlAnimation anim) {
                                            medicalOxygen.setRect(0, TOP, FILL, FILL);
                                        }
                                    }, 1500)).start();
                        }
                    }

                });
                pulseSemiCircleProgress.addPenListener(new PenListener() {

                    @Override
                    public void penDown(PenEvent pe) {
                        if (!Settings.fingerTouch || !hadParentScrolled()) {
                            PathAnimation.create(MedicalHome.this.container, -Settings.screenWidth, 0, new ControlAnimation.AnimationFinished(){
                                @Override
                                public void onAnimationFinished(ControlAnimation anim) {
                                    MedicalHome.this.container.setRect(-Settings.screenWidth, KEEP, SCREENSIZE, KEEP);
                                }
                            }, 1500).with(
                                    PathAnimation.create(medicalPulse,0,0,new ControlAnimation.AnimationFinished(){
                                        @Override
                                        public void onAnimationFinished(ControlAnimation anim) {
                                            medicalPulse.setRect(LEFT, TOP, FILL, FILL);
                                        }
                                    }, 1500)).start();
                        }
                    }

                    @Override
                    public void penDrag(DragEvent arg0) {
                    }

                    @Override
                    public void penDragEnd(DragEvent arg0) {
                    }

                    @Override
                    public void penDragStart(DragEvent arg0) {
                    }

                    @Override
                    public void penUp(PenEvent pe) {
                        if (!Settings.fingerTouch || !hadParentScrolled()) {
                            PathAnimation.create(MedicalHome.this.container, -Settings.screenWidth, 0, new ControlAnimation.AnimationFinished(){
                                @Override
                                public void onAnimationFinished(ControlAnimation anim) {
                                    MedicalHome.this.container.setRect(-Settings.screenWidth, KEEP, SCREENSIZE, KEEP);
                                }
                            }, 1500).with(
                                    PathAnimation.create(medicalPulse,0,0,new ControlAnimation.AnimationFinished(){
                                        @Override
                                        public void onAnimationFinished(ControlAnimation anim) {
                                            medicalPulse.setRect(LEFT, TOP, FILL, FILL);
                                        }
                                    }, 1500)).start();
                        }
                    }

                });
            }

        });
        add(container, LEFT, TOP, FILL, FILL);
    }

}
