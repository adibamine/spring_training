package ma.awb.training.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DepositServiceTest {

  @InjectMocks
  DepositService depositService;

  @Mock
  DepositRepository depositRepository;
  @Mock
  BalanceService balanceService;

  @Test
  public void makeDeposit_should_return_solde_indispo_if_balance_lwr_than_amount() {
    Mockito.when(balanceService.getAccountSolde("account1")).thenReturn(BigDecimal.valueOf(200));
    String result = depositService.makeDeposit("account1", "accont2", BigDecimal.valueOf(30000));
    assertEquals("SOLDE INDISPONIBLE", result);
    Mockito.verify(depositRepository, Mockito.times(0)).saveDeposit(any(), any(), any());
  }

  @Test
  public void makeDeposit_should_validate_transaction_if_balance_grtr_than_amount() {
    Mockito.when(balanceService.getAccountSolde("account1")).thenReturn(BigDecimal.valueOf(100000));
    String result = depositService.makeDeposit("account1", "accont2", BigDecimal.valueOf(30000));
    assertEquals("OPÉRATION EFFÉCTUÉE AVEC SUCCÈS", result);
    Mockito.verify(depositRepository, Mockito.times(1))
        .saveDeposit("account1", "accont2", BigDecimal.valueOf(30000));
  }
}