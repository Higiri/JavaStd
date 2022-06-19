package member;

/**
 * .
 *
 * @author Higiri
 *
 */
public class Member {
  /** 番号 */
  private int number;
  /** 名前 */
  private String name;
  /** なまえ */
  private String ruby;
  /** 性別 */
  private String gender;
  /** 誕生日 */
  private String birthday;

  /** 番号初期値 */
  private static int COUNT = 1;
  /** 番号ベース値 */
  private final int BASE = 220000;

  /**
   * String配列でのコンストラクタ
   *
   * @param str - 配列 [0]名前 [1]ルビ [2]性別 [3]誕生日
   */
  public Member(String[] str) throws NumberFormatException, ArrayIndexOutOfBoundsException {
    this.number = BASE + COUNT++;
    this.name = str[0];
    this.ruby = str[1];
    this.gender = str[2];
    this.birthday = str[3];
  }

  /**
   * 番号取得するメソッド
   *
   * @return number - 番号
   */
  public int getNumber() {
    return number;
  }

  /**
   * 名前取得メソッド
   *
   * @return name - 名前
   */
  public String getName() {
    return name;
  }

  /**
   * なまえ取得メソッド
   *
   * @return ruby - なまえ
   */
  public String getRuby() {
    return ruby;
  }

  /**
   * 性別取得メソッド
   *
   * @return gender - 性別
   */
  public String getGender() {
    return gender;
  }

  /**
   * 誕生日取得メソッド
   *
   * @return birthday - 誕生日
   */
  public String getBirthday() {
    return birthday;
  }

  /**
   * 文字列化メソッド
   *
   * @return 文字列
   */
  @Override
  public String toString() {
    return this.number + "," + this.name + ","
        + this.ruby + "," + this.gender + "," + this.birthday;
  }

}
