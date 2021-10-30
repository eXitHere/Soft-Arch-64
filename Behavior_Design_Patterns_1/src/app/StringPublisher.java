package app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

// Publisher require <>
public class StringPublisher implements Publisher<String> {
  private final ExecutorService executorService = ForkJoinPool.commonPool();;
  private List<StringSubscription> subscriptions = new ArrayList<>();

  @Override
  public void subscribe(Subscriber subscriber) {
    StringSubscription subscription = new StringSubscription(subscriber, executorService);
    subscriptions.add(subscription);
    subscriber.onSubscribe(subscription);
  }

  public void publish(String inp) {
    for (StringSubscription stringSubscription : subscriptions) {
      stringSubscription.publish(inp);
    }
  }
}