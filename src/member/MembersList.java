package member;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fileIO.FileIO;
import input.Input;
import input.InputCheck;

public class MembersList {
  /** メンバーリスト */
  private List<Member> memberList = new ArrayList<>();

  /**
   * コンストラクタ<BR>
   * メンバーリスト生成
   */
  public MembersList() {
    try {
      List<String[]> memberListStr = FileIO.readCsv(Paths.get("./resource/member.csv"));
      for (String[] member : memberListStr) {
        memberList.add(new Member(member));
      }
    } catch (IOException | ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }

  /**
   * メンバー追加メソッド<BR>
   * 単純追加
   *
   * @param member - メンバー
   */
  public void addMember(Member member) {
    memberList.add(member);
  }

  /**
   * メンバー登録メソッド<BR>
   * 標準入力を促し、その入力値からメンバーを追加する
   */
  public void memberResister() {
    String name = "";
    String ruby = "";
    String gender = "";
    String birthday = "";

    do {
      System.out.println("名前を入力してください。 [氏 名]");
      name = Input.inputStr();
      if (name.equals("q")) {
        return;
      }
    } while (!InputCheck.isMatchName(name));
    do {
      System.out.println("名前を入力してください。 [みょうじ なまえ]");
      ruby = Input.inputStr();
      if (ruby.equals("q")) {
        return;
      }
    } while (!InputCheck.isMatchName(ruby));
    do {
      System.out.println("性別を入力してください。 [男/女/他]");
      gender = Input.inputStr();
      if (gender.equals("q")) {
        return;
      }
    } while (!InputCheck.isMatchGender(gender));
    do {
      System.out.println("誕生日を入力してください。 [yyy/MM/dd]");
      birthday = Input.inputStr();
      if (birthday.equals("q")) {
        return;
      }
    } while (!InputCheck.isMatchBirthday(birthday));
    addMember(new Member(name, ruby, gender, birthday));
  }

  /**
   * 登録されているメンバーをListで取得するメソッド
   *
   * @return memberList
   */
  public List<Member> getMemberList() {
    return memberList;
  }
}
