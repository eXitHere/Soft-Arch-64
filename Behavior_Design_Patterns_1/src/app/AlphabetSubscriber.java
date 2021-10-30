package app;

public class AlphabetSubscriber extends StringSubscriber {

  AlphabetSubscriber(){
    super("Alphabet");
  }

  @Override
  String use(String str) {
    // big thank : https://stackoverflow.com/questions/19886749/replace-alphabet-in-a-string-using-replace/19886836
    return str.replaceAll("[a-zA-Z]","");;
  }

}