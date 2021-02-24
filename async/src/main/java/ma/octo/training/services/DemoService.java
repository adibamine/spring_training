package ma.octo.training.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoService {

  @Async("threadPoolTaskExecutor")
  public void asyncMethodWithConfiguredExecutor() throws InterruptedException {
    Thread.sleep(2000);
    log.info("Execute asyncMethodWithConfiguredExecutor with configured executor - "
        + Thread.currentThread().getName());
  }

  @Async("simpleAsyncTaskExecutor")
  public void asyncMethodWithSimpleAsyncExecutor() throws InterruptedException {
    Thread.sleep(2000);
    log.info("Execute asyncMethodWithSimpleAsyncExecutor with configured executor - "
        + Thread.currentThread().getName());
  }
}
