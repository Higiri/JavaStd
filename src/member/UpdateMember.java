package member;

import java.util.List;

import input.Input;
import input.InputCheck;

public class UpdateMember {

  /**
   * メンバー情報変更メソッド<BR>
   * フィルター機能でメンバーを選択する。
   *
   * @param memberList - メンバーリスト
   */
  public static void updateMemberInfo(List<Member> memberList) {

  }

  /**
   * メンバー情報変更メソッド<BR>
   *
   * @param member - 変更するメンバー
   */
  public static void updateMemberInfo(Member member) {
    member.show();
    System.out.println("登録情報を変更します（変更しないときは'q'を入力");
    updateName(member);
    updateRuby(member);
    updateGender(member);
    updateBirthday(member);
  }

  /**
   * 名前を変更するメソッド
   *
   * @param member - メンバー
   */
  private static void updateName(Member member) {
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
  private static void updateRuby(Member member) {
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
  private static void updateGender(Member member) {
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
  private static void updateBirthday(Member member) {
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
