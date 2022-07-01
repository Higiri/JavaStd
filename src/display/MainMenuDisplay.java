package display;

import java.util.Arrays;

public class MainMenuDisplay extends AbstractDisplay {

  private enum MainMenu {

    MemberMenu(1, "メンバー管理画面", MainMenuItem.Member),
    ReserveMenu(2, "予約管理画面", MainMenuItem.ReserveMenu),
    StatisticsMenu(3, "統計画面", MainMenuItem.Statistics),
    CancelMenu(99, "終了", null),
    ;

    public final int itemNum;
    public final String label;
    public final MainMenuItem mainMenuItem;

    MainMenu(int itemNum, String label, MainMenuItem mainMenuItem) {
      this.itemNum = itemNum;
      this.label = label;
      this.mainMenuItem = mainMenuItem;
    }

    public static MainMenu valueOf(int itemNum) {
      for (MainMenu mainMenu : MainMenu.values()) {
        if (mainMenu.itemNum == itemNum) {
          return mainMenu;
        }
      }
      return null;
    }
  }

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
