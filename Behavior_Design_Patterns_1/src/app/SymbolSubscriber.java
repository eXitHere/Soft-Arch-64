package app;

public class SymbolSubscriber extends StringSubscriber {

  SymbolSubscriber() {
    super("Symbol");
  }

  @Override
  public boolean check(String item) {
    return item.matches(".*[^a-zA-Z0-9].*");
  }

}