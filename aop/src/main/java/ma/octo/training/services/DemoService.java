package ma.octo.training.services;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

  public void perform(String action) {
    System.out.println("Performin action " + action);
  }

  public void handleEvent(String event) {
    System.out.println("Handling event " + event);
  }

  public String getName() {
    return "DemoService";
  }

  public void handleEventWithSleep(String event) throws InterruptedException {
    Thread.sleep(300);
    System.out.println("Handling event " + event);
  }

  public void fail() {
    throw new RuntimeException("Failing");
  }
}
