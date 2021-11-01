package app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

abstract public class StringSubscriber implements Subscriber<String> {
  private Subscription subscription; // not use
  private String name;

  public StringSubscriber(String name) {
    this.name = name;
  }

  abstract public boolean check(String item);

  @Override
  public void onComplete() {

    System.out.println("Complete!");
  }

  @Override
  public void onError(Throwable throwable) {
    System.out.println("Error! " + throwable.toString());
  }

  @Override
  public void onNext(String item) {
    System.out.println(this.getClass().getName() + " save " + item);
    try {
      FileWriter file = new FileWriter(this.name + ".txt", true);
      file.write(item + "\n");
      file.close();
    } catch (IOException error) {
      error.printStackTrace();
    }
    this.subscription.request(1);
  }

  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
  }

}