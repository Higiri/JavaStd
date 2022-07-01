package display;

public abstract class AbstractDisplay {
  public String LINE_SEPARATOR = System.lineSeparator();

  public abstract String createMenu();

  public abstract void execute();

  public void display(String str) {
    System.out.println(str);
  }

  public void inputSupportDisplay(String str) {
    System.out.print(str);
  }
}
