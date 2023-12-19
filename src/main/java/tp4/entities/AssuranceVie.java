package tp4.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte {

    private LocalDate dateFin;

    private Double taux;

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public AssuranceVie(String numero, Double solde, Set<Client> clients, LocalDate dateFin, Double taux) {
        super(numero, solde, clients);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public AssuranceVie(LocalDate dateFin, Double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public AssuranceVie() {

    }
}