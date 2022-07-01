package member;

import java.util.List;
import java.util.stream.Collectors;

import input.Input;
import input.InputCheck;

public class FilterMember {

  /**
   * Idで抽出し、リストを返す
   *
   * @param memberList - メンバーリスト
   * @return 一致したリスト
   */
  public static List<Member> filterMemberById(List<Member> memberList) {
    String str;
    do {
      System.out.println("IDを入力してください。");
      str = Input.inputStr();
      if (str.equals("q")) {
        return null;
      }
    } while (!InputCheck.isMatchId(str));
    int num = Integer.parseInt(str);
    return memberList.stream()
        .filter(item -> item.getId() == num)
        .collect(Collectors.toList());
  }

  /**
   * Idで1人のメンバーを抽出するメソッド<BR>
   * 条件抽出で一致が1人になるまで再帰
   *
   * @param memberList - メンバーリスト
   * @return メンバー1人
   */
  public static Member filterOneMemberById(List<Member> memberList) {
    String str;
    do {
      System.out.println("IDを入力してください。");
      str = Input.inputStr();
      if (str.equals("q")) {
        return null;
      }
    } while (!InputCheck.isMatchId(str));
    int num = Integer.parseInt(str);

    List<Member> filteredList = memberList.stream()
        .filter(item -> item.getId() == num)
        .collect(Collectors.toList());

    switch (filteredList.size()) {
      case 0:
        return null;
      case 1:
        return filteredList.get(0);
      default:
        System.out.println();
        filteredList.stream()
            .filter(item -> item.getId() == num)
            .forEach(System.out::println);
        return filterOneMemberById(filteredList);
    }
  }

}
