package ma.octo.training.batch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BatchRunner {

  @Autowired
  private JobLauncher jobLauncher;
  @Autowired
  @Qualifier("virement_batch")
  private Job job;

  @Scheduled(cron = "*/10 * * * * *")
  public void run() {
    log.info("START ************");
    try {
      JobParameters jobParameters = new JobParametersBuilder().addLong("uniqueness", System.nanoTime()).toJobParameters();
      JobExecution jobExecution = jobLauncher.run(job, jobParameters);
    } catch (Exception e) {
      log.error("exception: {}", e);
    }
  }
}
