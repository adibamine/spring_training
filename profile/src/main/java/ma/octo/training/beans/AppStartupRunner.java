package ma.octo.training.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {

  @Value("${db.url:default}")
  private String url;

  @Override
  public void run(ApplicationArguments args) {
    log.info("database url : {}", url);
  }
}
