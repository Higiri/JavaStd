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
   * 名前の文字列ルールに準拠しているか判定するメソッド
   * 氏名の間にスペースを入れること
   *
   * @param str - 判定する文字列
   * @return true OK / false NG
   */
  public static Boolean isMatchName(String str) {
    Pattern pattern = Pattern.compile("^[^\\s]+[\\s][^\\s]+");
    if (str.length() <= 20 || pattern.matcher(str).find()) {
      return true;
    }
    return false;
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