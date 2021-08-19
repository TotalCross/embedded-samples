package com.totalcross.containers;

import com.totalcross.util.Colors;

import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.event.DragEvent;
import totalcross.ui.event.PenEvent;
import totalcross.ui.event.PenListener;
import totalcross.ui.gfx.Coord;
import totalcross.ui.gfx.Graphics;

public class ArcSlider extends Container {

   int startAngle = 225;
   int endAngle = 315;
   int radius;

   class Handle extends Control {

      int pos = 0;
      Coord center;

      Handle(int pos) {
         this.pos = pos;
         center = getAnglePoint(pos);
         this.addPenListener(new PenListener() {
            boolean isDragging = false;

            @Override
            public void penDown(PenEvent arg0) {
               // System.out.println(arg0);
            }

            @Override
            public void penDrag(DragEvent arg0) {
               // if (isInside(arg0.x, arg0.y, 10))
               if (isDragging) {
                  // System.out.println(arg0);
                  int angle = findAngle(arg0.x, arg0.y);
                  if (angle != Handle.this.pos) {
                     Handle.this.pos = angle;
                     center = getCoordByAngle(Handle.this.pos);
                     repaint();
                  }
               }
            }

            @Override
            public void penDragEnd(DragEvent arg0) {
               // System.out.println(arg0);
               isDragging = false;
            }

            @Override
            public void penDragStart(DragEvent arg0) {
               if (isInside(arg0.x, arg0.y, 10)) {
                  // System.out.println(arg0);
                  isDragging = true;
               }
            }

            @Override
            public void penUp(PenEvent arg0) {
               // System.out.println(arg0);
            }
         });
      }

      @Override
      public void onPaint(Graphics g) {
         g.drawCircle(center.x, center.y, 10);
      }

      public boolean isInside(int x, int y, int radius) {
         int dx = Math.abs(x - center.x);
         int dy = Math.abs(y - center.y);

         if (dx > radius)
            return false;
         if (dy > radius)
            return false;

         if (dx + dy <= radius)
            return true;
         return (dx * dx + dy * dy <= radius * radius);
      }
   }

   @Override
   public void initUI() {
      super.initUI();
      this.radius = Math.min(width, height) / 3;
      add(new Handle(startAngle), 0, 0, width, height);
      add(new Handle(startAngle), 0, 0, width, height);
   }

   @Override
   public void onPaint(Graphics g) {
      super.onPaint(g);
      g.backColor = Colors.BACKGROUD_DEFAULT;
      g.fillRect(0, 0, width, height);
      g.drawArc(width / 2, height / 2, radius, 315, 225);
   }

   // Faz o mesmo que getAnglePoint, mas não consegui escolher entre as duas
   private Coord getCoordByAngle(int angle) {
      Coord result = new Coord();
      result.x = (width / 2) + (int) (Math.cos(Math.toRadians(angle)) * radius);
      result.y = (height / 2) - (int) (Math.sin(Math.toRadians(angle)) * radius);
      return result;
   }

   private Coord getAnglePoint(int angle) {
      Coord out = new Coord();
      this.getGraphics().getAnglePoint(width / 2, height / 2, radius, radius, angle, out);
      return out;
   }

   private int findAngle(int x, int y) {
      double theta = Math.toDegrees(Math.atan2((height / 2) - y, x - (width / 2)));
      theta = (theta + 360) % 360;
      return (int) theta;
   }
}