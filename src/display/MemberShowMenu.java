package display;

public enum MemberShowMenu {
  ID(1, "ID順"),
  NAME(2, "名前順"),
  GENDER(3, "性別順"),
  BIRTHDAY(4, "誕生日順"),
  REGISTDAY(5, "登録日順"),
  BACK(8, "メインメニューへ戻る"),
  CANCEL(9, "終了"),
  ;

  public final int itemNum;
  public final String label;

  MemberShowMenu(int itemNum, String label) {
    this.itemNum = itemNum;
    this.label = label;
  }

  public static MemberShowMenu valueOf(int itemNum) {
    for (MemberShowMenu memberShowMenu : MemberShowMenu.values()) {
      if (memberShowMenu.itemNum == itemNum) {
        return memberShowMenu;
      }
    }
    return null;
  }
}
