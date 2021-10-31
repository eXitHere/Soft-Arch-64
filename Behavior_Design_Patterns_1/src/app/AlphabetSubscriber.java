package app;

import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;

public class AlphabetSubscriber extends StringSubscriber {

  String name = "Alphabet";

  AlphabetSubscriber() {
    super("Alphabet");
  }

  @Override
  public void onNext(String item) {
    try {
      // big thank :
      // https://stackoverflow.com/questions/19886749/replace-alphabet-in-a-string-using-replace/19886836
      Writer file = new FileWriter(name + ".txt", true);
      // String newStr = item.replaceAll("[a-zA-Z]", "");
      String newStr = item.replaceAll("[^a-zA-Z]", "");
      // System.out.println(newStr);
      file.write(newStr + "\n");
      file.close();
    } catch (IOException error) {
      error.printStackTrace();
    }
  }

}