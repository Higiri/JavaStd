package scanner;

import java.util.Scanner;

public class ScannerManager {
  /** スキャナーの宣言 */
  private Scanner stdin = null;
  /** スキャナーのインスタンス */
  public static ScannerManager instance = new ScannerManager();

  /**
   * コンストラクタの非公開<BR>
   *
   * スキャナーの2重起動を防ぐ
   */
  private ScannerManager() {
  }

  /**
   * スキャナーのインスタンスを取得するメソッド
   *
   * @return instance
   */
  public static ScannerManager getInstance() {
    return instance;
  }

  /**
   * 標準入力ストリームを開く
   */
  public void openScanner() {
    stdin = new Scanner(System.in);
  }

  /**
   * Scannerを取得するメソッド
   *
   * @return Scanner
   */
  public Scanner getScanner() {
    return stdin;
  }

  public void closeScanner() {
    try {
      if (stdin != null) {
        stdin.close();
      }
    } catch (IllegalStateException e) {
    }
  }

}
