package ma.octo.training.batch.configuration;

import lombok.extern.slf4j.Slf4j;
import ma.octo.training.batch.Virement;
import ma.octo.training.batch.VirementDto;
import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VirementSkipListener implements SkipListener {

  @Override
  public void onSkipInRead(Throwable throwable) {
    log.error("** Erreur de lecture", throwable);
  }

  @Override
  public void onSkipInWrite(Object o, Throwable throwable) {
    log.error("** Erreur d'écriture", throwable);
    if (o instanceof Virement) {
      log.error(o.toString());
    }
  }

  @Override
  public void onSkipInProcess(Object o, Throwable throwable) {
    log.error("** Erreur de traitement", throwable.getMessage());
    if (o instanceof VirementDto) {
      log.error(o.toString());
    }
  }
}
