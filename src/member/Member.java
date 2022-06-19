package member;

public class Member {
  private int number;
  private String name;
  private String ruby;
  private String gender;
  private String birthday;

  private static int NUM = 1;
  private final int NUM_BASE = 220000;

  /**
   * コンストラクタ
   * @param number
   * @param name
   * @param ruby
   * @param gender
   * @param birthday
   */
  public Member(int number, String name, String ruby, String gender, String birthday) {
    this.number = number;
    this.name = name;
    this.ruby = ruby;
    this.gender = gender;
    this.birthday = birthday;
  }

  public Member(String name, String ruby, String gender, String birthday) {
    this.number = NUM_BASE + NUM++;
    this.name = name;
    this.ruby = ruby;
    this.gender = gender;
    this.birthday = birthday;
  }

  /**
   * @return number
   */
  public int getNumber() {
    return number;
  }

  /**
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * @return ruby
   */
  public String getRuby() {
    return ruby;
  }

  /**
   * @return gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @return birthday
   */
  public String getBirthday() {
    return birthday;
  }

  /**
   *
   */
  @Override
  public String toString() {
    return this.number + ", " + this.name + ", " + this.gender + ", " + this.birthday;
  }

}
