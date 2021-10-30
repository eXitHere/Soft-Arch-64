package app;

import java.io.File;
import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

abstract public class StringSubscriber implements Subscriber<String> {
  // private Subscription subscription;
  private String name = "";

  public StringSubscriber(String name) {
    try {
        this.name = name;
        // create new file
        File file = new File(name+".txt");
        file.createNewFile();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

  abstract String use(String str);

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
    try{
      Writer file = new FileWriter(name + ".txt", true);
      file.write(use(item) + "\n");
      file.close();
    }
    catch(IOException error) {
      error.printStackTrace();
    }
  }

  @Override
  public void onSubscribe(Subscription subscription) {
    // ?
    // this.subscription = subscription;
  }

}