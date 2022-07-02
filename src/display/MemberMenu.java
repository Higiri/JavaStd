package display;

public enum MemberMenu {
  SHOW(1, "全メンバー表示"),
  FILTER(2, "フィルター表示"),
  REGISTER(3, "メンバー登録"),
  UPDATE(4, "メンバー情報変更"),
  DELETE(5, "メンバー情報削除"),
  BACK(8, "メインメニューへ戻る"),
  CANCEL(9, "終了"),
  ;

  public final int itemNum;
  public final String label;

  MemberMenu(int itemNum, String label) {
    this.itemNum = itemNum;
    this.label = label;
  }

  public static MemberMenu valueOf(int itemNum) {
    for (MemberMenu memberMenu : MemberMenu.values()) {
      if (memberMenu.itemNum == itemNum) {
        return memberMenu;
      }
    }
    return null;
  }
}
