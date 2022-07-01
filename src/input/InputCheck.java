package input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Pattern;

/**
 *
 * @author Higiri
 *
 */
public class InputCheck {

  /**
   * IDの数字ルールに準拠しているかを判定すうｒメソッド
   *
   * @param str - 文字列
   * @return true - 6桁の数字 / false - その他
   */
  public static Boolean isMatchId(String str) {
    if (100000 <= Integer.parseInt(str) && Integer.parseInt(str) < 1000000) {
      return true;
    }
    return false;
  }

  /**
   * 名前の文字列ルールに準拠しているか判定するメソッド<BR>
   * 名字 + スペース + 名前
   *
   * @param str - 判定する文字列
   * @return true - OK / false - NG
   */
  public static Boolean isMatchName(String str) {
    Pattern pattern = Pattern.compile("^[^\\s]+[\\s][^\\s]+");
    if (str.length() <= 20 || pattern.matcher(str).find()) {
      return true;
    }
    return false;
  }

  /**
   * 性別の文字列ルールに準拠しているか判定するメソッド<BR>
   * 「男」「女」「他」
   *
   * @param str
   * @return true - 男/女/他 / false - その他
   */
  public static Boolean isMatchGender(String str) {
    if (str.equals("男") || str.equals("女") || str.equals("他")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 誕生日が正しい形式であるか判定するメソッド
   *
   * @param str - 判定する文字列
   * @return true - OK / false - NG
   */
  public static Boolean isMatchBirthday(String str) {
    try {
      LocalDate.parse(str,
          DateTimeFormatter.ofPattern("uuuu/MM/dd").withResolverStyle(ResolverStyle.STRICT));
    } catch (DateTimeParseException e) {
      return false;
    }
    return true;
  }

  /**
   * メンバー情報変更の機能リストの数値範囲かを判定するメソッド
   *
   * @param num - 入力数値
   * @return true - 範囲内 / false - 範囲外
   */
  public static Boolean isMatchChangeMemberInfo(int num) {
    if (num < 0 || 5 < num) {
      return false;
    }
    return true;
  }

  /**
   *
   */
  public static void main(String[] args) {
    String str = "";
    do {
      str = Input.inputStr();
    } while (!isMatchBirthday(str));
    System.out.println(str);
  }
}