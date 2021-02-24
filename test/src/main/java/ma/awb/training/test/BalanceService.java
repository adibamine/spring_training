package ma.awb.training.test;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

  public BigDecimal getAccountSolde(String accountNb) {
    return new BigDecimal(Math.random());
  }
}
