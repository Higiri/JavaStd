package display;

import java.util.Arrays;

import input.InputCheck;

public class MemberMenuDisplay extends AbstractDisplay {

  @Override
  public String createMenu() {
    int width = Arrays
        .stream(MemberMenu.values())
        .mapToInt(s -> s.label.length())
        .max()
        .getAsInt() * 2 + 5;

    final String memberMenuMessage = "実行したいメニューを以下から選択してください。";

    StringBuilder menuStr = new StringBuilder();

    menuStr.append(LINE_SEPARATOR);
    menuStr.append(memberMenuMessage);
    menuStr.append(LINE_SEPARATOR);

    menuStr.append("+".repeat(width));
    menuStr.append(LINE_SEPARATOR);
    for (MemberMenu memberMenu : MemberMenu.values()) {
      menuStr.append(String.format("%2s", memberMenu.itemNum));
      menuStr.append(": ");
      menuStr.append(memberMenu.label);
      menuStr.append(LINE_SEPARATOR);
    }
    menuStr.append("+".repeat(width));
    return menuStr.toString();
  }

  @Override
  public void execute() {
    final String inputSupport = "メニュー番号";
    String menuNum;
    do {
      display(createMenu());
      inputSupportDisplay(inputSupport);
      menuNum = acceptOrder();
    } while (!InputCheck.isMatchMainMenu(menuNum));

    switch (MemberMenu.valueOf(Integer.parseInt(menuNum))) {
      case SHOW:
        MemberMenuDisplay memberMenu = new MemberMenuDisplay();
        memberMenu.execute();
        break;
      case FILTER:
        System.out.println("予約管理");
        break;
      case REGISTER:
        System.out.println("統計");
        break;
      case CANCEL:
        return;
      default:
        break;
    }
  }

}
