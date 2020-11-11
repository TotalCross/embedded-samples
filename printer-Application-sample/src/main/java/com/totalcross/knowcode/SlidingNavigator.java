package com.totalcross.knowcode;

import static totalcross.ui.Control.AFTER;
import static totalcross.ui.Control.FILL;
import static totalcross.ui.Control.LEFT;
import static totalcross.ui.Control.SCREENSIZE;
import static totalcross.ui.Control.TOP;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import totalcross.sys.Settings;
import totalcross.ui.Control;
import totalcross.ui.Window;
import totalcross.ui.anim.ControlAnimation;
import totalcross.ui.anim.PathAnimation;
import totalcross.ui.event.Event;

public class SlidingNavigator {

   Window window;
   Stack<XMLPresenter> presenters = new Stack<>();
   Map<Class<? extends XMLPresenter>, XMLPresenter> cache = new HashMap<>();

   public SlidingNavigator(Window window) {
      this.window = window;
   }

   public void present(Class<? extends XMLPresenter> presenterClass)
         throws InstantiationException, IllegalAccessException {
      final XMLPresenter presenter = cache.containsKey(presenterClass) ? cache.get(presenterClass)
            : presenterClass.newInstance();
      if (!cache.containsKey(presenterClass)) {
         cache.put(presenterClass, presenter);
      }

      if (presenters.isEmpty()) {
         window.add(presenter.content, LEFT, TOP, FILL, FILL);
      } else {
         XMLPresenter previous = presenters.lastElement();

         window.add(presenter.content, AFTER, TOP, SCREENSIZE, SCREENSIZE, previous.content);
         PathAnimation.create(previous.content, -Settings.screenWidth, 0, new ControlAnimation.AnimationFinished() {
            @Override
            public void onAnimationFinished(ControlAnimation anim) {
               window.remove(previous.content);
            }
         }, 1000).with(PathAnimation.create(presenter.content, 0, 0, new ControlAnimation.AnimationFinished() {
            @Override
            public void onAnimationFinished(ControlAnimation anim) {
               presenter.content.setRect(LEFT, TOP, FILL, FILL);
            }
         }, 1000)).start();
      }
      presenter.setNavigator(this);
      presenters.push(presenter);
      presenter.bind2();
      if (presenter.isFirstPresent) {
         presenter.onPresent();
         presenter.isFirstPresent = false;
      }
   }

   public void back(Event e) {
      if (presenters.size() < 2) {
         // nothing to do
         return;
      }

      XMLPresenter current = presenters.pop();
      XMLPresenter previous = presenters.lastElement();

      window.add(previous.content, -Settings.screenWidth, TOP, SCREENSIZE, SCREENSIZE);
      PathAnimation.create(current.content, Settings.screenWidth, 0, new ControlAnimation.AnimationFinished() {
         @Override
         public void onAnimationFinished(ControlAnimation anim) {
            window.remove(current.content);
         }
      }, 1000).with(PathAnimation.create(previous.content, 0, 0, new ControlAnimation.AnimationFinished() {
         @Override
         public void onAnimationFinished(ControlAnimation anim) {
            previous.content.setRect(LEFT, TOP, FILL, FILL);
         }
      }, 1000)).start();
   }

   public void home(Event e) {
      if (presenters.size() < 2) {
         // nothing to do
         return;
      }

      XMLPresenter home = presenters.firstElement();
      window.removeAll();
      window.add(home.content, LEFT, TOP, SCREENSIZE, SCREENSIZE);
      presenters.setSize(1);
   }

   public void onClick(Control target, Class<? extends XMLPresenter> presenterClass) {
      target.addPressListener((e) -> {
         try {
            SlidingNavigator.this.present(presenterClass);
         } catch (InstantiationException | IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      });
   }
}