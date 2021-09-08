package com.totalcross.containers;

import com.totalcross.util.Colors;
import com.totalcross.util.Fonts;
import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.Radio;
import totalcross.ui.ScrollContainer;
import totalcross.ui.Switch;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;

public class Demo extends ScrollContainer {

  private Container First;
  private Container Second;
  private Container Third;
  private Container Fourth;

  private Label lblTitle;
  private Label lblSubTitle;
  private Label lblIdioma;
  private Label lblNumericFormatting;
  private Label lblNumericFormattingSub;
  private Label lblHourFormat;
  private Label lblHourFormatSub;
  private Label lblTheme;
  private Label lblControlPanel;
  private Label lblControlPanelSub;
  private Label lbl01;
  private Label lbl01Sub;
  private Label lblOcult;
  private Label lblOcultSub;
  private Label lblVibrar;
  private Label lblVibrarSub;
  private Label lblNotify;
  private Label lblNotifySub;
  private Label lblMode;
  private Label lblModeSub;
  private Label lblClose;
  private Label lblCloseSub;
  private Label lblShortcuts;
  private Label lblShortcutsSub;
  private Label lblTitleModulo;
  private Label lblTitleTokens;
  private Label lblTokensSub;
  private Label lblTitleTokensAccess;
  private Label lblTokensAccessSub;
  private Label lblTokensAccessStatus;

  private Button Edit;
  private Button CreateToken;
  private Button Exit;

  private ComboBox cbnIdioma;
  private ComboBox cbnNumericFormatting;
  private ComboBox cbnHourFormat;
  private ComboBox cbnTheme;
  private ComboBox cbnControlPane;

  private Switch sldOcult;
  private Switch sldVibrar;
  private Switch sldNotify;
  private Switch sldMode;
  private Switch sldClose;
  private Switch sldShorcuts;

  private Radio auto;
  private Radio Claro;
  private Radio Escuro;

  @Override
  public void initUI() {
      setScrollBars(false, true);
      setBackForeColors(0xF7F7F7, 0x000000);

      First = new Container();
      Second = new Container();
      Third = new Container();
      Fourth = new Container();

      lblTitle = new Label("Demo User");
      lblSubTitle = new Label("Você está logado como Demo User. Você é um proprietário.");
      lblIdioma = new Label("Idioma");
      lblNumericFormatting = new Label("Formatação numérica");
      lblNumericFormattingSub = new Label("Choose how numbers are formatted.");
      lblHourFormat = new Label("Formato de hora");
      lblHourFormatSub = new Label("Escolha como os horários são formatados.");
      lblTheme = new Label("Tema");
      lblControlPanel = new Label("Painel de controle");
      lblControlPanelSub = new Label("Escolha um painel padrão para este dispositivo.");
      lbl01 = new Label("Altere a ordem e oculte os itens da barra lateral");
      lbl01Sub = new Label(
          "Pode também pressionar e segurar o cabeçalho da " + "barra lateral \n para ativar o modo de edição.");
      lblOcult = new Label("Sempre ocultar a barra lateral");
      lblOcultSub = new Label("Isto irá ocultar a barra lateral por padrão, semelhante à \n experiência móvel.");
      lblVibrar = new Label("Vibrar");
      lblVibrarSub = new Label("Ative ou desative a vibração neste dispositivo ao controlar \n dispositivos.");
      lblNotify = new Label("Notificações push");
      lblNotifySub = new Label("Envie notificações para este dispositivo");
      lblMode = new Label("Modo Avançado");
      lblModeSub = new Label("Desbloqueia recursos avançados.");
      lblClose = new Label("Fechar a conexão automaticamente");
      lblCloseSub = new Label("Devemos fechar a conexão com o servidor depois de ficar oculto por \n 5 minutos?");
      lblShortcuts = new Label("Atalhos de Teclado");
      lblShortcutsSub = new Label("Ativar ou desativar atalhos de teclado para executar várias ações na \n IU.");
      lblTitleModulo = new Label("Módulos de Autenticação Multifator");
      lblTitleTokens = new Label("Tokens de atualização");
      lblTokensSub = new Label(
          "Cada token de atualização representa uma sessão de login. Os tokens de atualização serão \n"
              + "removidos automaticamente quando você clicar em efetuar logout. Os tokens de \n"
              + "atualização a seguir estão ativos na sua conta no momento.");
      lblTitleTokensAccess = new Label("Tokens de acesso de longa duração");
      lblTokensAccessSub = new Label(
          "Crie tokens de acesso de longa duração para permitir que seus scripts interajam com \n sua instância do Home Assistant. Cada token será válido por 10 anos a partir da criação. Os \n"
              + "seguintes tokens de acesso de longa duração estão atualmente ativos");
      lblTokensAccessStatus = new Label("Você ainda não tem tokens de acesso de longa duração.");

      Edit = new Button("EDITAR");
      CreateToken = new Button("CRIAR TOKEN");
      Exit = new Button("SAIR");

      sldOcult = new Switch();
      sldVibrar = new Switch();
      sldNotify = new Switch();
      sldMode = new Switch();
      sldClose = new Switch();
      sldShorcuts = new Switch();

      auto = new Radio("Automático");
      Claro = new Radio("Claro");
      Escuro = new Radio("Escuro");

      // Setting Labels
      lblTitle.transparentBackground = true;
      lblSubTitle.transparentBackground = true;
      lblIdioma.transparentBackground = true;
      lblNumericFormatting.transparentBackground = true;
      lblNumericFormattingSub.transparentBackground = true;
      lblHourFormat.transparentBackground = true;
      lblHourFormatSub.transparentBackground = true;
      lblTheme.transparentBackground = true;
      lblControlPanel.transparentBackground = true;
      lblControlPanelSub.transparentBackground = true;
      lbl01.transparentBackground = true;
      lbl01Sub.transparentBackground = true;
      lblOcult.transparentBackground = true;
      lblOcultSub.transparentBackground = true;
      lblVibrar.transparentBackground = true;
      lblVibrarSub.transparentBackground = true;
      lblNotify.transparentBackground = true;
      lblNotifySub.transparentBackground = true;
      lblMode.transparentBackground = true;
      lblModeSub.transparentBackground = true;
      lblClose.transparentBackground = true;
      lblCloseSub.transparentBackground = true;
      lblShortcuts.transparentBackground = true;
      lblShortcutsSub.transparentBackground = true;
      lblTitleModulo.transparentBackground = true;
      lblTitleTokens.transparentBackground = true;
      lblTokensSub.transparentBackground = true;
      lblTitleTokensAccess.transparentBackground = true;
      lblTokensAccessSub.transparentBackground = true;
      lblTokensAccessStatus.transparentBackground = true;

      lblTitle.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 40));
      lblSubTitle.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblIdioma.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblNumericFormatting.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblNumericFormattingSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblHourFormat.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblHourFormatSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblTheme.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblControlPanel.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblControlPanelSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lbl01.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lbl01Sub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblOcult.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblOcultSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblVibrar.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblVibrarSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblNotify.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblNotifySub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblMode.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblModeSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblClose.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblCloseSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblShortcuts.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblShortcutsSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblTitleModulo.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblTitleTokens.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblTokensSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblTitleTokensAccess.setFont(Font.getFont(Fonts.FONT_DEFAULT, true, 15));
      lblTokensAccessSub.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));
      lblTokensAccessStatus.setFont(Font.getFont(Fonts.FONT_DEFAULT, false, 15));

      // Configuring Radio Button
      auto.transparentBackground = true;
      Claro.transparentBackground = true;
      Escuro.transparentBackground = true;

      // Adding Array Items
      String[] itemsIdioma = { "Afrikaans", "عربية", "Български", "বাংলা", "Bosanski", "Català", "Čeština", "Cymraeg",
          "Dansk", "Deutsch", "Ελληνικά", "English", "English (GB)", "Esperanto", "Español", "Español (Latin America)",
          "Eesti", "Euskara", "فارسی", "Suomi", "Frysk", "Français", "Galego", "Schwiizerdütsch", "עברית", "हिन्दी",
          "Hrvatski", "Magyar", "Հայերեն", "Indonesia", "Italiano", "Íslenska", "日本語", "Kartuli", "한국어",
          "Lëtzebuergesch", "Lietuvių", "Latviešu", "Nederlands", "Norsk Bokmål", "Norsk Nynorsk", "Polski",
          "Português", "Português (BR)", "Română", "Русский", "Slovenčina", "Slovenščina", "Српски", "Srpski",
          "Svenska", "தமிழ்", "తెలుగు", "ภาษาไทย", "Türkçe", "Українська", "اُردُو", "Tiếng  Việt", "简体中文", "繁體中文",
          "Test" };

      String[] itemsNumericFormatting = { "Auto (use language setting)", "1.234.567,89", "Use system locale",
          "1.234.567,89", "1,234,567.89", "1.234.567,89", "1 234 567,89", "None", "1234567.89" };

      String[] itemsHourFormat = { "Automático (usar configuração de idioma)", "13:30", "Use a localidade do sistema",
          "13:30", "12 horas (AM/PM)", "1:30 PM", "24 horas", "13:30" };

      String[] itemsTheme = { "Backend-selected", "default", "mock'" };

      // Creating combo box
      cbnIdioma = new ComboBox(itemsIdioma);
      cbnNumericFormatting = new ComboBox(itemsNumericFormatting);
      cbnHourFormat = new ComboBox(itemsHourFormat);
      cbnTheme = new ComboBox(itemsTheme);
      cbnControlPane = new ComboBox();

      // Setting up combo box
      cbnIdioma.caption = itemsIdioma[0];
      cbnNumericFormatting.caption = itemsNumericFormatting[0];
      cbnHourFormat.caption = itemsHourFormat[0];
      cbnTheme.caption = itemsTheme[0];
      cbnControlPane.caption = "defautl";
      cbnControlPane.enableSearch = false;

      // Adding containers to layout
      add(First, LEFT, TOP);
      add(Second, LEFT, TOP + 800);
      add(Third, LEFT, TOP + 850);
      add(Fourth, LEFT, TOP + 900);

      // Adding components to containers
      First.add(lblTitle, LEFT + 10, TOP);
      First.add(lblSubTitle, SAME, AFTER + 2);
      First.add(lblIdioma, SAME, AFTER + 5);
      First.add(lblNumericFormatting, SAME, AFTER + 12);
      First.add(lblNumericFormattingSub, SAME, AFTER + 2);
      First.add(lblHourFormat, SAME, AFTER + 12);
      First.add(lblHourFormatSub, SAME, AFTER + 2);
      First.add(lblTheme, SAME, AFTER + 12);
      First.add(auto, SAME + 5, AFTER + 12);
      First.add(Claro, SAME + 120, SAME);
      First.add(Escuro, SAME + 80, SAME);
      First.add(lblControlPanel, LEFT + 10, AFTER + 12);
      First.add(lblControlPanelSub, SAME, AFTER + 2);
      First.add(lbl01, SAME, AFTER + 12);
      First.add(lbl01Sub, SAME, AFTER + 2);
      First.add(lblOcult, SAME, AFTER + 12);
      First.add(lblOcultSub, SAME, AFTER + 2);
      First.add(lblVibrar, SAME, AFTER + 12);
      First.add(lblVibrarSub, SAME, AFTER + 2);
      First.add(lblNotify, SAME, AFTER + 12);
      First.add(lblNotifySub, SAME, AFTER + 2);
      First.add(lblMode, SAME, AFTER + 12);
      First.add(lblModeSub, SAME, AFTER + 2);
      First.add(lblClose, SAME, AFTER + 12);
      First.add(lblCloseSub, SAME, AFTER + 2);
      First.add(lblShortcuts, SAME, AFTER + 12);
      First.add(lblShortcutsSub, SAME, AFTER + 2);
      First.add(cbnIdioma, LEFT + 330, TOP + 63, 150, 40);
      First.add(cbnNumericFormatting, SAME, AFTER + 4, 150, 40);
      First.add(cbnHourFormat, SAME, AFTER + 4, 150, 40);
      First.add(cbnTheme, SAME, AFTER + 4, 150, 40);
      First.add(cbnControlPane, SAME, AFTER + 40, 150, 40);
      First.add(Edit, SAME + 55, AFTER + 15);
      First.add(sldOcult, SAME + 35, AFTER + 40);
      First.add(sldVibrar, SAME, AFTER + 50);
      First.add(sldNotify, SAME, SAME + 55);
      First.add(sldMode, SAME, AFTER + 35);
      First.add(sldClose, SAME, AFTER + 40);
      First.add(sldShorcuts, SAME, AFTER + 45);
      First.add(Exit, LEFT + 10, AFTER + 20);
      Second.add(lblTitleModulo, LEFT + 10, TOP + 20);
      Third.add(lblTitleTokens, LEFT + 10, TOP + 20);
      Third.add(lblTitleTokens, LEFT + 10, TOP + 20);
      Fourth.add(lblTitleTokensAccess, LEFT + 10, AFTER + 20);
      Fourth.add(lblTokensAccessSub, LEFT + 10, AFTER + 20);
      Fourth.add(lblTokensAccessStatus, LEFT + 10, AFTER + 20);
      Fourth.add(CreateToken, LEFT + 10, AFTER + 20);

      //Setting up the container
      First.setBackColor(Colors.BACKGROUD_DEFAULT);
      First.setBorderRadius(5);
      First.setBorderStyle(BORDER_RAISED);
      First.setBackColor(Color.WHITE);
      Second.setBackColor(Colors.BACKGROUD_DEFAULT);
      Second.setBorderRadius(5);
      Second.setBorderStyle(BORDER_RAISED);
      Second.setBackColor(Color.WHITE);
      Third.setBackColor(Colors.BACKGROUD_DEFAULT);
      Third.setBorderRadius(5);
      Third.setBorderStyle(BORDER_RAISED);
      Third.setBackColor(Color.WHITE);
      Fourth.setBackColor(Colors.BACKGROUD_DEFAULT);
      Fourth.setBorderRadius(5);
      Fourth.setBorderStyle(BORDER_RAISED);
      Fourth.setBackColor(Color.WHITE);

      // Setting container size
      First.setRect(LEFT, TOP, FILL, FILL);
      Second.setRect(LEFT, TOP + 800, FILL, FILL);
      Third.setRect(LEFT, TOP + 850, FILL, FILL);
      Fourth.setRect(LEFT, TOP + 900, FILL, FILL);

      First.resize();
      Second.resize();
      Third.resize();
      Fourth.resize();
  }
}
