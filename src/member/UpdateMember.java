package member;

import input.Input;
import input.InputCheck;

public class UpdateMember {
  /**
   * メンバー情報変更メソッド<BR>
   *
   * @param member - 変更するメンバー
   */
  public static void changeMemberInfo(Member member) {
    member.show();
    System.out.println("どの項目を変更しますか。[1 - 4, 5(全て), 0(中断)]");

    int input = 0;
    do {
      input = Input.inputNum();
    } while (!InputCheck.isMatchChangeMemberInfo(input));

    switch (input) {
      case 1:
        changeName(member);
        return;
      case 2:
        changeRuby(member);
        return;
      case 3:
        changeGender(member);
        return;
      case 4:
        changeBirthday(member);
        return;
      default:
        return;
    }
  }

  /**
   * 名前を変更するメソッド
   *
   * @param member - メンバー
   */
  private static void changeName(Member member) {
    String name = "";
    do {
      System.out.println("名前を入力してください。 [氏 名]");
      name = Input.inputStr();
      if (name.equals("q")) {
        return;
      }
    } while (!InputCheck.isMatchName(name));
    member.setName(name);
  }

  /**
   * なまえを変更するメソッド
   *
   * @param member - メンバー
   */
  private static void changeRuby(Member member) {
    String ruby;
    do {
      System.out.println("名前を入力してください。 [みょうじ なまえ]");
      ruby = Input.inputStr();
      if (ruby.equals("q")) {
        return;
      }
    } while (!InputCheck.isMatchName(ruby));
    member.setRuby(ruby);
  }

  /**
   * 性別を変更するメソッド
   *
   * @param member - メンバー
   */
  private static void changeGender(Member member) {
    String gender = "";
    do {
      System.out.println("性別を入力してください。 [男/女/他]");
      gender = Input.inputStr();
      if (gender.equals("q")) {
        return;
      }
    } while (!InputCheck.isMatchGender(gender));
    member.setGender(gender);
  }

  /**
   * 誕生日を変更するメソッド
   *
   * @param member - メンバー
   */
  private static void changeBirthday(Member member) {
    String birthday = "";
    do {
      System.out.println("誕生日を入力してください。 [yyy/MM/dd]");
      birthday = Input.inputStr();
      if (birthday.equals("q")) {
        return;
      }
    } while (!InputCheck.isMatchBirthday(birthday));
    member.setBirthday(birthday);
  }

}
