package tp4;

import tp4.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banques");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        Adresse adressePrincipal = new Adresse(14,"Allée de la réjannerie", 44600, "Saint-Nazaire");
        Banques banque = new Banques("Caisse d'épargne");
        em.persist(banque);


        Client client = new Client( "PIERRE", "Simon", LocalDate.now(), adressePrincipal, banque);
        em.persist(client);

        AssuranceVie assuranceVie = new AssuranceVie("contrat d'assurance décès", 457.00, Set.of(client), LocalDate.now(), 5.00);
        em.persist(assuranceVie);

        Adresse adresseLivraison = new Adresse(12,"allée de beau regard", 44000, "Nantes");
        Client clientBoutique = new Client("ROUSSEL", "Julien", LocalDate.now(), adresseLivraison, banque);
        em.persist(clientBoutique);

        Set<Client> clients = new HashSet<>();
        clients.add(client);
        clients.add(clientBoutique);

        Compte compte = new Compte("1458-7854-748-544", 100000000.00, clients);
        em.persist(compte);

        LivretA livretA = new LivretA("7458-CB589-fd84", 4578200.00, Set.of(client),2.50);
        em.persist(livretA);

        Operation operation = new Operation(LocalDateTime.now(), 450.00, "Impot", compte);
        em.persist(operation);

        Virement virement = new Virement(LocalDateTime.now(), 0.50, "Paiement du rat", compte, "Le rat");
        em.persist(virement);


        et.commit();

        em.close();
        emf.close();
    }
}