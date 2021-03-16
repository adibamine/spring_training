package ma.octo.training.batch;

import java.math.BigDecimal;

public class VirementDto {

  private String destinataire;
  private BigDecimal amount;

  public String getDestinataire() {
    return destinataire;
  }

  public void setDestinataire(String destinataire) {
    this.destinataire = destinataire;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "VirementDto{" +
        "destinataire='" + destinataire + '\'' +
        ", amount=" + amount +
        '}';
  }
}
