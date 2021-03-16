package ma.octo.training.batch.configuration;

import java.math.BigDecimal;
import ma.octo.training.batch.Virement;
import ma.octo.training.batch.VirementDto;
import ma.octo.training.batch.VirementException;
import org.springframework.batch.item.ItemProcessor;

public class VirementItemProcessor implements ItemProcessor<VirementDto, Virement> {

  @Override
  public Virement process(final VirementDto virementDto) {
    String destinataire = virementDto.getDestinataire().replaceAll("\\s+", "");
    if (destinataire.length() != 15) {
      throw new VirementException("account.size.invalid");
    }
    BigDecimal amount = virementDto.getAmount();
    Virement nvVirement = new Virement(destinataire, amount);
    return nvVirement;
  }
}