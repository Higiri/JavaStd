package conferenceReserve;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fileIO.FileIO;
import member.Member;

/**
 * メインクラス
 *
 * @author Higiri
 *
 */
public class ConferenceReserve {

  /**
   * あ
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    List<String[]> memberListStr = new ArrayList<>();
    try {
      memberListStr = FileIO.readCsv(Paths.get("./resource/member.csv"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<Member> memberList = new ArrayList<>();
    for (String[] m : memberListStr) {
      memberList.add(new Member(m[0], m[1], m[2], m[4]));
    }

    memberList.stream()
        .sorted(Comparator.comparing(Member::getBirthday).reversed())
        .forEach(System.out::println);
  }

}
