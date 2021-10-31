package app;

// import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Subscriber;

public class StringSubscription implements Subscription {
  private final Subscriber<String> subscriber;
  // private final ExecutorService executor;

  public StringSubscription(Subscriber<String> subscriber) {
    this.subscriber = subscriber;
    // this.executor = executorService;
  }

  @Override
  public void cancel() {
    // do noting :3
  }

  @Override
  public void request(long n) {
    if (n < 0) {
      IllegalArgumentException ex = new IllegalArgumentException();
      subscriber.onError(ex);
    } else {
      // executor.submit(() -> {
      // subscriber.onNext();
      // subscriber.onComplete();
      // });
    }
  }

  public void publish(String inp) {
    subscriber.onNext(inp);
  }

}