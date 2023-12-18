package tp4;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "banque")
public class Banques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany (mappedBy = "banque")
    private Set<Client> client;

    @Override
    public String toString() {
        return "Banques{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
