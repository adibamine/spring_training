package ma.awb.training.test;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

  @Autowired
  private BalanceService balanceService;
  @Autowired
  private DepositRepository depositRepository;

  public String makeDeposit(String transmitterAccNb, String receiverAccNb, BigDecimal amount) {
    BigDecimal transmitterSolde = balanceService.getAccountSolde(transmitterAccNb);
    if (transmitterSolde.compareTo(amount) < 0) {
      return "SOLDE INDISPONIBLE";
    } else {
      depositRepository.saveDeposit(transmitterAccNb, receiverAccNb, amount);
      return "OPÉRATION EFFÉCTUÉE AVEC SUCCÈS";
    }
  }
}
