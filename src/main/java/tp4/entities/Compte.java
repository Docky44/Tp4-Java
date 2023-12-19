package tp4.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private double solde;
    private String numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @ManyToMany(mappedBy = "comptes")
    private Set<Client> client;

    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    public Compte(String numero, Double solde, Set<Client> client) {
        this.numero = numero;
        this.solde = solde;
        this.client = client;
    }

    public Compte() {

    }
}
