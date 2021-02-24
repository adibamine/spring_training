package ma.awb.training.test;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepositRepository {

  public void saveDeposit(String transmitterAccNb, String receiverAccNb, BigDecimal Amount) {
    log.info("saving deposit succesfuly");
  }

}
