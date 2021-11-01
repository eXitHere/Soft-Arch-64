package app;

import java.util.concurrent.Flow.Subscriber;

public class Main {
  public static void main(String[] args) {
    String[] testcase = { "123", "Hello", "Hello_World+++11234", "I_L0V3_SOFT__ARCHHHHHHHH" };
    // String[] testcase = { "Hello_World+++11234" };
    StringPublisher publisher = new StringPublisher();

    Subscriber<String> sub1 = new NumberSubscriber();
    Subscriber<String> sub2 = new SymbolSubscriber();
    Subscriber<String> sub3 = new AlphabetSubscriber();
    publisher.subscribe(sub1);
    publisher.subscribe(sub2);
    publisher.subscribe(sub3);

    for (String string : testcase) {
      System.out.println("Test : " + string);
      publisher.publish(string);
    }
  }
}