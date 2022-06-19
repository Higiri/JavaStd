package conferenceReserve;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
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
   * メインメソッド
   * （テスト）
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {

    // ファイルデータ読み込み
    List<String[]> memberListStr = new ArrayList<>();
    try {
      memberListStr = FileIO.readCsv(Paths.get("./resource/member.csv"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // メンバーデータをファイルから登録
    List<Member> memberList = new ArrayList<>();
    for (String[] m : memberListStr) {
      memberList.add(new Member(m));
    }

    // メンバーを若い順に表示
    memberList.stream()
        //        .sorted(Comparator.comparing(Member::getBirthday).reversed())
        .forEach(System.out::println);

    try {
      FileIO.writeCsv(memberList, Paths.get("./resource/members.csv"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
