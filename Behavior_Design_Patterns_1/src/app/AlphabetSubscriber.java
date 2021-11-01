package app;

public class AlphabetSubscriber extends StringSubscriber {

  AlphabetSubscriber() {
    super("Alphabet");
  }

  @Override
  public boolean check(String item) {
    return item.matches(".*[a-zA-Z].*");
  }

}