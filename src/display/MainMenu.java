package display;

public enum MainMenu {
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
