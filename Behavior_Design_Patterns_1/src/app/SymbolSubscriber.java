package app;

import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;

public class SymbolSubscriber extends StringSubscriber {

  String name = "Symbol";

  SymbolSubscriber() {
    super("Symbol");
  }

  @Override
  public void onNext(String item) {
    try {
      // big thank :
      // https://www.codegrepper.com/code-examples/java/how+to+remove+symbols+from+a+string+in+java
      Writer file = new FileWriter(name + ".txt", true);
      // String newStr = item.replaceAll("[^a-zA-Z0-9]", "");
      String newStr = item.replaceAll("[a-zA-Z0-9]", "");
      // System.out.println(newStr);
      file.write(newStr + "\n");
      file.close();
    } catch (IOException error) {
      error.printStackTrace();
    }
  }

}