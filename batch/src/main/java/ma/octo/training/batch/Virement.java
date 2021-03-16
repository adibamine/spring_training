package ma.octo.training.batch;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Virement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String destinataire;
  @Column
  private BigDecimal amount;

  public Virement(String destinataire, BigDecimal amount) {
    this.destinataire = destinataire;
    this.amount = amount;
  }

  public Virement(VirementDto virementDto) {
    this.destinataire = virementDto.getDestinataire();
    this.amount = virementDto.getAmount();
  }

  public Virement() {
  }

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
    return "Virement{" +
        "id=" + id +
        ", destinataire='" + destinataire + '\'' +
        ", amount=" + amount +
        '}';
  }
}
