package display;

public enum MainMenu {
  MEMBER(1, "メンバー管理画面"),
  RESERVEMENU(2, "予約管理画面"),
  STATISTICS(3, "統計画面"),
  CANCEL(9, "終了"),
  ;

  public final int itemNum;
  public final String label;

  MainMenu(int itemNum, String label) {
    this.itemNum = itemNum;
    this.label = label;
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
