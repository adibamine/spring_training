package ma.octo.training.beans;

import lombok.extern.slf4j.Slf4j;
import ma.octo.training.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {

  @Autowired
  DemoService service;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    service.asyncMethodWithSimpleAsyncExecutor();
    service.asyncMethodWithConfiguredExecutor();
    log.info("asyncBean called");
  }
}