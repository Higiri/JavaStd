package main;

import display.MainMenuDisplay;
import scanner.ScannerManager;

public class Main {

  public static void main(String[] args) {
    try {
      ScannerManager.getInstance().openScanner();

      MainMenuDisplay mainMenu = new MainMenuDisplay();
      //mainMenu.execute();
      mainMenu.execute();

    } catch (Exception e) {
      System.out.println(e);
    } finally {
      ScannerManager.getInstance().closeScanner();
    }

  }

}
