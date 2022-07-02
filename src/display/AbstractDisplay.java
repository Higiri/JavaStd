package display;

import scanner.ScannerManager;

public abstract class AbstractDisplay {
  public String LINE_SEPARATOR = System.lineSeparator();

  public abstract String createMenu();

  public abstract void execute();

  public String acceptOrder() {
    ScannerManager sm = ScannerManager.getInstance();
    return sm.getScanner().nextLine();
  }

  public void display(String str) {
    System.out.println(str);
  }

  public void inputSupportDisplay(String str) {
    System.out.print(str + " > ");
  }
}
