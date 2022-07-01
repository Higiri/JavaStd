package display;

import java.util.Arrays;

public class MainMenuDisplay extends AbstractDisplay {

  @Override
  public String createMenu() {
    int width = Arrays
        .stream(MainMenu.values())
        .mapToInt(s -> s.label.length())
        .max()
        .getAsInt() * 2 + 6;

    final String mainMenuMessage = "実行したいメニューを以下から選択してください。";

    StringBuilder menuStr = new StringBuilder();

    menuStr.append(mainMenuMessage);
    menuStr.append(LINE_SEPARATOR);

    menuStr.append("+".repeat(width));
    menuStr.append(LINE_SEPARATOR);
    for (MainMenu mainMenu : MainMenu.values()) {
      menuStr.append(String.format("%3s", mainMenu.itemNum));
      menuStr.append("  ");
      menuStr.append(mainMenu.label);
      menuStr.append(LINE_SEPARATOR);
    }
    menuStr.append("+".repeat(width));
    menuStr.append(LINE_SEPARATOR);
    return menuStr.toString();
  }

  @Override
  public void execute() {
    // TODO 自動生成されたメソッド・スタブ

  }

}
