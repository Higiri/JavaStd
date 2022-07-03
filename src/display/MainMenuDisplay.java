package display;

import java.util.Arrays;

import input.InputCheck;

public class MainMenuDisplay extends AbstractDisplay {

  @Override
  public String createMenu() {
    int width = Arrays
        .stream(MainMenu.values())
        .mapToInt(s -> s.label.length())
        .max()
        .getAsInt() * 2 + 5;

    final String mainMenuMessage = "実行したいメニューを以下から選択してください。";

    StringBuilder menuStr = new StringBuilder();

    menuStr.append(mainMenuMessage);
    menuStr.append(LINE_SEPARATOR);

    menuStr.append("+".repeat(width));
    menuStr.append(LINE_SEPARATOR);
    for (MainMenu mainMenu : MainMenu.values()) {
      menuStr.append(String.format("%2s", mainMenu.itemNum));
      menuStr.append(": ");
      menuStr.append(mainMenu.label);
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
      display("");
    } while (!InputCheck.isMatchMainMenu(menuNum));

    switch (MainMenu.valueOf(Integer.parseInt(menuNum))) {
      case MEMBER:
        MemberMenuDisplay memberMenu = new MemberMenuDisplay();
        memberMenu.execute();
        break;
      case RESERVEMENU:
        System.out.println("予約管理");
        break;
      case STATISTICS:
        System.out.println("統計");
        break;
      case CANCEL:
        return;
      default:
        break;
    }

  }

}
