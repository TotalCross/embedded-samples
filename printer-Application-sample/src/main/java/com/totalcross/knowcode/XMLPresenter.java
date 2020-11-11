package com.totalcross.knowcode;

import java.lang.reflect.Field;

import com.totalcross.knowcode.parse.XmlContainerFactory;
import com.totalcross.knowcode.parse.XmlContainerLayout;

import totalcross.ui.Container;
import totalcross.ui.Control;

import static java.lang.Character.*;

public abstract class XMLPresenter {

   protected Container content;
   protected SlidingNavigator navigator;
   public boolean isFirstPresent = true;

   public XMLPresenter(Container content) {
      this.content = content;
   }

   public XMLPresenter() {
      bind();
   }

   private void bind() {
      final String clazzCanonicalName = this.getClass().getName();
      final int lastPeriodIdx = clazzCanonicalName.lastIndexOf('.');
      final String clazzName = lastPeriodIdx == -1 ? clazzCanonicalName
            : clazzCanonicalName.substring(lastPeriodIdx + 1);
      final String xmlName = snakeCaseFormat(
            clazzName.endsWith("Presenter") ? clazzName.substring(0, clazzName.length() - 9) : clazzName);

      content = XmlContainerFactory.create("xml/" + xmlName + ".xml");
   }

   public void bind2() {
      Field[] fields = this.getClass().getDeclaredFields();
      for (Field field : fields) {
         Control c = ((XmlContainerLayout) content).getControlByID("@+id/" + field.getName());
         if (c != null && field.getType().isAssignableFrom(c.getClass())) {
            try {
               // field.setAccessible(true);
               field.set(this, c);
            } catch (IllegalArgumentException | IllegalAccessException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }
   }

   public abstract void onPresent();

   public void setNavigator(SlidingNavigator navigator) {
      this.navigator = navigator;
   }

   private static String snakeCaseFormat(String name) {
      final StringBuilder result = new StringBuilder();

      boolean lastUppercase = false;

      for (int i = 0; i < name.length(); i++) {
         char ch = name.charAt(i);
         char lastEntry = i == 0 ? 'X' : result.charAt(result.length() - 1);
         if (ch == ' ' || ch == '_' || ch == '-' || ch == '.') {
            lastUppercase = false;

            if (lastEntry == '_') {
               continue;
            } else {
               ch = '_';
            }
         } else if (Character.isUpperCase(ch)) {
            ch = Character.toLowerCase(ch);
            // is start?
            if (i > 0) {
               if (lastUppercase) {
                  // test if end of acronym
                  if (i + 1 < name.length()) {
                     char next = name.charAt(i + 1);
                     if (!Character.isUpperCase(next) && /* Character. */isAlphabetic(next)) {
                        // end of acronym
                        if (lastEntry != '_') {
                           result.append('_');
                        }
                     }
                  }
               } else {
                  // last was lowercase, insert _
                  if (lastEntry != '_') {
                     result.append('_');
                  }
               }
            }
            lastUppercase = true;
         } else {
            lastUppercase = false;
         }

         result.append(ch);
      }
      return result.toString();
   }

   private static boolean isAlphabetic(char c) {
      return ((1 << Character.getType(c)) & ((1 << UPPERCASE_LETTER) | (1 << LOWERCASE_LETTER) | (1 << TITLECASE_LETTER)
            | (1 << MODIFIER_LETTER) | (1 << OTHER_LETTER) | (1 << LETTER_NUMBER))) != 0;
   }
}
