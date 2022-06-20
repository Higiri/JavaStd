package input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

  /**
   * 数値入力
   *
   * @return 数値
   */
  @SuppressWarnings("resource")
  public static int inputNum() {
    Scanner stdin = new Scanner(System.in);
    try {
      System.out.print("input > ");
      return stdin.nextInt();
    } catch (InputMismatchException e) {
      stdin.next();
    }
    return inputNum();
  }

  /**
   * 文字列入力
   *
   * @return 文字列
   */
  @SuppressWarnings("resource")
  public static String inputStr() {
    Scanner stdin = new Scanner(System.in);

    String line = "";
    while (line.isBlank()) {
      System.out.print("input > ");
      line = stdin.nextLine();
    }
    return line;
  }

}
