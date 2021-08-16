package com.totalcross.ui;

import com.totalcross.knowcode.parse.CustomInitUI;
import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import com.totalcross.ui.components.CircleProgress;
import com.totalcross.ui.components.ControlPanel;
import com.totalcross.ui.components.DataGraph;
import com.totalcross.ui.components.SemiCircleProgress;
import com.totalcross.util.Fonts;
import com.totalcross.util.Positioning;

import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.anim.ControlAnimation;
import totalcross.ui.anim.PathAnimation;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;
import totalcross.ui.font.Font;
import totalcross.ui.image.ImageException;

public class MedicalPulse extends Container {
	
	private Container homeContainer;
	
	MedicalPulse(Container homeContainer) {
		this.homeContainer = homeContainer;
	}
	
	@Override
	public void initUI() {
		Container container = XmlContainerFactory.create("xml_files/medical_pulse.xml");
		XmlContainerLayout containerLayout = (XmlContainerLayout) container;
		containerLayout.setCustomInitUI(new CustomInitUI() {
			
			@Override
			public void postInitUI(XmlContainerLayout container) {
				// Fonts
				Control font;
				font = container.getControlByID("@+id/titleLabel");
				font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
				font = container.getControlByID("@+id/pulseLabel");
				font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
				font = container.getControlByID("@+id/pulseMinMaxLabel");
				font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
				font = container.getControlByID("@+id/heartLabel");
				font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
				font = container.getControlByID("@+id/maxBPMLabel");
				font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
				font = container.getControlByID("@+id/minBPMLabel");
				font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
				font = container.getControlByID("@+id/controlsLabel");
				font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
				font = container.getControlByID("@+id/notifyLabel");
				font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
				font = container.getControlByID("@+id/setAlarmLabel");
				font.setFont(Font.getFont("BarlowCondensed-Regular", false,font.getFont().size));
				
				try {
					Button backButton = (Button) container.getControlByID("@+id/imageButton");
					backButton.transparentBackground = false;
					backButton.setBackColor(0xFFFFFF);
					backButton.setImage(backButton.getImage().getScaledInstance(
					Positioning.getWidthDP(21), Positioning.getHeightDP(34)));
					backButton.addPressListener(new PressListener() {
						
						@Override
						public void controlPressed(ControlEvent arg0) {
							PathAnimation.create(MedicalPulse.this.asContainer, Settings.screenWidth, 0, new ControlAnimation.AnimationFinished(){
								@Override
								public void onAnimationFinished(ControlAnimation anim) {
									MedicalPulse.this.asContainer.setRect(Settings.screenWidth, KEEP, KEEP, KEEP);
								}
							}, 1500).with(
									PathAnimation.create(homeContainer,0,0,new ControlAnimation.AnimationFinished(){
										@Override
										public void onAnimationFinished(ControlAnimation anim) {
											homeContainer.setRect(LEFT, TOP, FILL, FILL);
										}
									}, 1500)).start();

						}
					});
				} catch (ImageException e) {
					e.printStackTrace();
				}
				
				DataGraph dataGraph = new DataGraph(50, 130);
				dataGraph.addValues(new int[] { 50, 75, 36, 47, 59, 63, 54, 52, 45 });
				dataGraph.setColor(0xFF0000);
				container.add(dataGraph, Positioning.getWidthDP(79), Positioning.getHeightDP(430),
				Positioning.getWidthDP(359), Positioning.getHeightDP(162));
				CircleProgress flowCircleProgress = new CircleProgress(20, MedicalHome.pulseMaxValue,
				65, "" + MedicalHome.pulseMaxValue);
				flowCircleProgress.setFont(Fonts.BARLOW_CONDENSED_54);
				flowCircleProgress.setFilledColor(0xFF0000);
				flowCircleProgress.setUnfilledColor(0x6B3333);
				flowCircleProgress.setBackColor(0x460000);
				flowCircleProgress.setTextColor(0xFFFFFF);
				container.add(flowCircleProgress, Positioning.getWidthDP(523),
				Positioning.getHeightDP(80), Positioning.getHeightDP(200),
				Positioning.getWidthDP(200));
				CircleProgress spo2CircleProgress = new CircleProgress(20, MedicalHome.pulseMaxValue,
				110, "" + MedicalHome.pulseMaxValue);
				spo2CircleProgress.setFont(Fonts.BARLOW_CONDENSED_54);
				spo2CircleProgress.setFilledColor(0xFF0000);
				spo2CircleProgress.setUnfilledColor(0x6B3333);
				spo2CircleProgress.setBackColor(0x460000);
				spo2CircleProgress.setTextColor(0xFFFFFF);
				container.add(spo2CircleProgress, Positioning.getWidthDP(523),
				Positioning.getHeightDP(389), Positioning.getHeightDP(200),
				Positioning.getWidthDP(200));
				SemiCircleProgress semiCircleProgress = new SemiCircleProgress(20, 99, 84,
				SemiCircleProgress.RIGHT);
				semiCircleProgress.setFilledColor(0xFF0000);
				semiCircleProgress.setUnfilledColor(0x6B3333);
				semiCircleProgress.setBackColor(0x460000);
				container.add(semiCircleProgress, Positioning.getWidthDP(281),
				Positioning.getHeightDP(48), Positioning.getWidthDP(161),
				Positioning.getHeightDP(336));
				Control img = container.getControlByID("@+id/heartImage");
				Control imgLabel = container.getControlByID("@+id/heartLabel");
				container.add(img);
				container.add(imgLabel);
				ControlPanel controlPanel = new ControlPanel(99, 42);
				controlPanel.setFont(Fonts.BARLOW_CONDENSED_25);
				controlPanel.setFilledColor(0xFF0000);
				controlPanel.setUnfilledColor(0x6B3333);
				controlPanel.setTextColor(0xFFFFFF);
				container.add(controlPanel, Positioning.getWidthDP(796), Positioning.getHeightDP(115),
				Positioning.getWidthDP(119), Positioning.getHeightDP(262));
				Button saveButton = (Button) container.getControlByID("@+id/saveButton");
				saveButton.setBorder(Button.BORDER_ROUND);
				saveButton.setFont(Fonts.BARLOW_CONDENSED_20);
				saveButton.roundBorderFactor = 2;
				saveButton.setBackForeColors(0xffffff, 0xFF0000);
				container.add(saveButton);
				Button cancelButton = (Button) container.getControlByID("@+id/cancelButton");
				cancelButton.transparentBackground = true;
				cancelButton.setBorder(Button.BORDER_OUTLINED);
				cancelButton.setFont(Fonts.BARLOW_CONDENSED_20);
				cancelButton.roundBorderFactor = 2;
				cancelButton.borderColor = 0xFF0000;
				cancelButton.setBackColor(0xFF0000);
				container.add(cancelButton);
			}
		});
		add(container, LEFT, TOP, FILL, FILL);
	}
	
}