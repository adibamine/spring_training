package ma.octo.training.batch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VirementJobListener implements JobExecutionListener {

  @Override
  public void beforeJob(JobExecution jobExecution) {
    log.info("Début du batch {}", jobExecution.getJobInstance().getJobName());
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    log.info("Exit code: {}", jobExecution.getExitStatus().getExitCode());
    log.info("Fin du batch {}", jobExecution.getJobInstance().getJobName());
    log.info("Fin du batch: {}", jobExecution.getEndTime().toString());
  }
}
