package member;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fileIO.FileIO;

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

  public void addMember(Member member) {
    memberList.add(member);
  }

  //  public Memver addMember() {
  //    return new Member(name, ruby, gender, birthday);
  //  }

}
