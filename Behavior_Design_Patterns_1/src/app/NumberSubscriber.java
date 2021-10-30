package app;

public class NumberSubscriber extends StringSubscriber {

  NumberSubscriber(){
    super("Number");
  }

  @Override
  String use(String str) {
    // big thank : https://stackoverflow.com/questions/23607583/how-to-replace-all-numbers-in-java-string#:~:text=The%20correct%20RegEx%20for%20selecting,%5D%22%2C%20%22%22)%20.
    // only [0-9]
    return str.replaceAll("\\d", "");
  }

}