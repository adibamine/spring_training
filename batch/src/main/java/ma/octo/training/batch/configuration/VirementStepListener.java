package ma.octo.training.batch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VirementStepListener implements StepExecutionListener {

  @Override
  public void beforeStep(StepExecution stepExecution) {
    log.info("== Step {} ===", stepExecution.getStepName());
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {
    log.info("read count: {} / write count: {} / read skip: {} / write skip: {} /process skip {}",
        stepExecution.getReadCount(), stepExecution.getWriteCount(),
        stepExecution.getReadSkipCount(),
        stepExecution.getWriteSkipCount(), stepExecution.getProcessSkipCount());
    return stepExecution.getExitStatus();
  }
}
