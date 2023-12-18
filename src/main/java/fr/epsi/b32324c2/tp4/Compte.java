package fr.epsi.b32324c2.tp4;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int idClient;
    private int idBanque;
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

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdBanque() {
        return idBanque;
    }

    public void setIdBanque(int idBanque) {
        this.idBanque = idBanque;
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

    @ManyToMany
    @JoinTable(name = "compte_client",
            joinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))
    private Set<Client> client;

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", idBanque=" + idBanque +
                ", solde=" + solde +
                ", numero='" + numero + '\'' +
                '}';
    }
}
