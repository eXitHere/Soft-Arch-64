package app;

import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;

public class NumberSubscriber extends StringSubscriber {

  private String name = "Number";

  NumberSubscriber() {
    super("Number");
  }

  @Override
  public void onNext(String item) {
    try {
      // big thank :
      // https://stackoverflow.com/questions/23607583/how-to-replace-all-numbers-in-java-string#:~:text=The%20correct%20RegEx%20for%20selecting,%5D%22%2C%20%22%22)%20.
      // only [0-9]
      Writer file = new FileWriter(name + ".txt", true);
      String newStr = item.replaceAll("[^0-9]", "");
      // System.out.println(newStr);
      file.write(newStr + "\n");
      file.close();
    } catch (IOException error) {
      error.printStackTrace();
    }
  }

}