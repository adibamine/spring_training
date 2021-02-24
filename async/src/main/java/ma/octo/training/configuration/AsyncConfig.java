package ma.octo.training.configuration;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfig {

  @Bean(name = "threadPoolTaskExecutor")
  public Executor threadPoolTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(10);
    return executor;
  }

  @Bean(name = "simpleAsyncTaskExecutor")
  public Executor simpleAsyncTaskExecutor() {
    return new SimpleAsyncTaskExecutor();
  }
}
