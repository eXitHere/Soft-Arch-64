package app;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

abstract public class StringSubscriber implements Subscriber<String> {
  private Subscription subscription;

  public StringSubscriber(String name) {
    try {
      File file = new File(name + ".txt");
      file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onComplete() {
    // debug
    System.out.println("Complete!");
  }

  @Override
  public void onError(Throwable throwable) {
    System.out.println("Error! " + throwable.toString());
  }

  @Override
  public void onNext(String item) {
  }

  @Override
  public void onSubscribe(Subscription subscription) {
    // ?
    this.subscription = subscription;
  }

}