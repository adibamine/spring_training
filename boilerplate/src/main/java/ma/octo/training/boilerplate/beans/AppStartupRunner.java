package ma.octo.training.boilerplate.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {

  @Autowired
  private ApplicationContext appContext;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("Application started");
    SpringApplication.exit(appContext, () -> 0);
  }
}
