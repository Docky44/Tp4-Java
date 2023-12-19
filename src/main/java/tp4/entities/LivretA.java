package tp4.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "livretA")
public class LivretA extends Compte {

    private Double taux;


    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
    public LivretA(String numero, Double solde, Set<Client> clients, Double taux) {
        super(numero, solde, clients);
        this.taux = taux;
    }

    public LivretA(Double taux) {
        this.taux = taux;
    }

    public LivretA() {

    }
}
