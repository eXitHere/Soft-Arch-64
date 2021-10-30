package app;

public class SymbolSubscriber extends StringSubscriber {

  SymbolSubscriber(){
    super("Symbol");
  }

  @Override
  String use(String str) {
    // big thank : https://www.codegrepper.com/code-examples/java/how+to+remove+symbols+from+a+string+in+java
    // only [0-9]
    return str.replaceAll("[^a-zA-Z0-9]","");
  }

}