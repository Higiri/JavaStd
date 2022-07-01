package member;

import java.util.Date;

/**
 * .
 *
 * @author Higiri
 *
 */
public class Member {
  /** 番号 */
  private int id;
  /** パスワード */
  private String pass;
  /** 名前 */
  private String name;
  /** なまえ */
  private String ruby;
  /** 性別 */
  private String gender;
  /** 誕生日 */
  private String birthday;
  /** 登録日 */
  private Date registDay;

  /** 番号初期値 */
  private static int COUNT = 1;
  /** 番号ベース値 */
  private final int BASE = 220000;

  /**
   * String配列でのコンストラクタ
   *
   * @param str - 配列 [0]名前 [1]ルビ [2]性別 [3]誕生日
   */
  public Member(String[] str)
      throws NumberFormatException, ArrayIndexOutOfBoundsException {
    this.id = BASE + COUNT++;
    this.pass = "alpha" + String.valueOf(this.id);
    this.name = str[0];
    this.ruby = str[1];
    this.gender = str[2];
    this.birthday = str[3];
  }

  /**
   * String配列でのコンストラクタ
   *
   * @param str - 配列 [0]名前 [1]ルビ [2]性別 [3]誕生日
   */
  public Member(String name, String ruby, String gender, String birthday)
      throws NumberFormatException, ArrayIndexOutOfBoundsException {
    this.id = BASE + COUNT++;
    this.pass = "alpha" + String.valueOf(this.id);
    this.name = name;
    this.ruby = ruby;
    this.gender = gender;
    this.birthday = birthday;
  }

  /**
   * 番号取得するメソッド
   *
   * @return number - 番号
   */
  public int getId() {
    return id;
  }

  /**
   * パスワードを再設定するメソッド
   *
   * @param pass - パスワード
   */
  public void setPass(String pass) {
    this.pass = pass;
  }

  /**
   * @return pass
   */
  public String getPass() {
    return pass;
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
   * 名前を設定するメソッド
   *
   * @param name - 名前
   */
  public void setName(String name) {
    this.name = name;
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
   * なまえを設定するメソッド
   *
   * @param ruby - 名前
   */
  public void setRuby(String ruby) {
    this.ruby = ruby;
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
   * 性別を設定するメソッド
   *
   * @param gender - 性別
   */
  public void setGender(String gender) {
    this.gender = gender;
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
   * 誕生日を設定するメソッド
   *
   * @param birthday - 誕生日
   */
  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  /**
   * 文字列化メソッド
   *
   * @return 文字列
   */
  @Override
  public String toString() {
    return this.id + "," + this.name + ","
        + this.ruby + "," + this.gender + "," + this.birthday;
  }

  public void show() {
    System.out.println("名前    ;" + this.name);
    System.out.println("なまえ  :" + this.ruby);
    System.out.println("性別    :" + this.gender);
    System.out.println("誕生日  :" + this.birthday);
    System.out.println();
  }

}
