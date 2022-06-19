package input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

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
