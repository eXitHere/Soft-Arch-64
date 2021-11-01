package app;

public class NumberSubscriber extends StringSubscriber {

  NumberSubscriber() {
    super("Number");
  }

  @Override
  public boolean check(String item) {
    return item.matches(".*[0-9].*");
  }

}