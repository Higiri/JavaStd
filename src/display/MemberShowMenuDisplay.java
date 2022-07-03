package display;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import input.InputCheck;
import member.Member;
import member.MembersList;

public class MemberShowMenuDisplay extends AbstractDisplay {

  @Override
  public String createMenu() {
    int width = Arrays
        .stream(MemberShowMenu.values())
        .mapToInt(s -> s.label.length())
        .max()
        .getAsInt() * 2 + 5;

    final String memberShowMessage = "実行したいメニューを以下から選択してください。";

    StringBuilder menuStr = new StringBuilder();

    menuStr.append(memberShowMessage);
    menuStr.append(LINE_SEPARATOR);

    menuStr.append("+".repeat(width));
    menuStr.append(LINE_SEPARATOR);
    for (MemberShowMenu memberShow : MemberShowMenu.values()) {
      menuStr.append(String.format("%2s", memberShow.itemNum));
      menuStr.append(": ");
      menuStr.append(memberShow.label);
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
    } while (!InputCheck.isMatchMemberShow(menuNum));

    // 取得したリスト
    List<Member> list = MembersList.getMemberList();
    int nameWidth = list
        .stream()
        .mapToInt(s -> s.getName().length())
        .max()
        .getAsInt() * 2 - 1;

    MemberMenuDisplay memberMenu = new MemberMenuDisplay();

    switch (MemberShowMenu.valueOf(Integer.parseInt(menuNum))) {
      case ID:
        display(Member.formatHeader(nameWidth));
        list
            .stream()
            .sorted(Comparator.comparing(Member::getId))
            .forEach(m -> display(m.formatShow(nameWidth)));
        display(Member.footer(nameWidth));
        memberMenu.execute();
        break;
      case NAME:
        display(Member.formatHeader(nameWidth));
        list
            .stream()
            .sorted(Comparator.comparing(Member::getRuby).thenComparing(Member::getId))
            .forEach(m -> display(m.formatShow(nameWidth)));
        display(Member.footer(nameWidth));
        memberMenu.execute();
        break;
      case GENDER:
        display(Member.formatHeader(nameWidth));
        list
            .stream()
            .sorted(Comparator.comparing(Member::getGender).thenComparing(Member::getId))
            .forEach(m -> display(m.formatShow(nameWidth)));
        display(Member.footer(nameWidth));
        memberMenu.execute();
        break;
      case BIRTHDAY:
        display(Member.formatHeader(nameWidth));
        list
            .stream()
            .sorted(Comparator.comparing(Member::getBirthday).thenComparing(Member::getId))
            .forEach(m -> display(m.formatShow(nameWidth)));
        display(Member.footer(nameWidth));
        memberMenu.execute();
        break;
      case REGISTDAY:
        display(Member.formatHeader(nameWidth));
        list
            .stream()
            .sorted(Comparator.comparing(Member::getRegistDay).thenComparing(Member::getId))
            .forEach(m -> display(m.formatShow(nameWidth)));
        display(Member.footer(nameWidth));
        memberMenu.execute();
        break;
      case BACK:
        memberMenu.execute();
      case CANCEL:
        return;
      default:
        break;
    }
  }

}
