package app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow.Subscription;
// import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

public class StringSubscription implements Subscription {
  private Subscriber<String> subscriber;
  private final ExecutorService executor;

  public StringSubscription(Subscriber<? super String> subscriber, ExecutorService executorService) {
    this.subscriber = (Subscriber<String>) subscriber;
    this.executor = executorService;
  }

  @Override
  public synchronized void cancel() {
  }

  @Override
  public synchronized void request(long n) {
    //
  }

  public synchronized void save(String inp) {
    executor.submit(() -> {
      try {
        subscriber.onNext(inp);
      } catch (Exception error) {
        subscriber.onError(error);
      }
    });
  }

  public boolean check(String item) {
    // System.out.print("check " + item + " ");
    // System.out.println(((StringSubscriber) this.subscriber).check(item));
    return ((StringSubscriber) this.subscriber).check(item);
  }

}