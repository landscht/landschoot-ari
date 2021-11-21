import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Entreprise entreprise = new Entreprise();
        entreprise.setNom("davidson");
        em.persist(entreprise);

        Projet myDev = new Projet();
        myDev.setNom("myDev");
        em.persist(myDev);

        Projet fast = new Projet();
        fast.setNom("fast");
        em.persist(fast);

        Equipe adeo = new Equipe();
        adeo.setName("adeo");
        em.persist(adeo);

        Equipe cds = new Equipe();
        cds.setName("cds");
        em.persist(cds);

        em.getTransaction().commit();
        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setFirstname("Tony");
        employee.setLastname("Landschoot");
        employee.setAdresse(new Adresse("306 rue du blocus"));
        employee.setEquipe(adeo);
        employee.setEntreprise(entreprise);
        employee.setProjets(Arrays.asList(fast, myDev));
        em.persist(employee);

        Employee employeeGabriel = new Employee();
        employeeGabriel.setFirstname("Gabriel");
        employeeGabriel.setLastname("Congin");
        employeeGabriel.setEquipe(cds);
        employeeGabriel.setAdresse(new Adresse("rue du molinel"));
        employeeGabriel.setEntreprise(entreprise);
        employeeGabriel.setProjets(Collections.singletonList(fast));
        em.persist(employeeGabriel);

        Employee employeeNicolas = new Employee();
        employeeNicolas.setFirstname("Nicolas");
        employeeNicolas.setAdresse(new Adresse("btwin village"));
        employeeNicolas.setLastname("Perreira");
        employeeNicolas.setEquipe(cds);
        employeeNicolas.setEntreprise(entreprise);
        employeeNicolas.setProjets(Collections.singletonList(fast));
        em.persist(employeeNicolas);

        Employee employeeSami = new Employee();
        employeeSami.setFirstname("Sami");
        employeeSami.setLastname("Lejeune");
        employeeSami.setEquipe(adeo);
        employeeSami.setAdresse(new Adresse("halluin"));
        employeeSami.setEntreprise(entreprise);
        employeeSami.setProjets(Collections.singletonList(myDev));
        em.persist(employeeSami);

        em.getTransaction().commit();

        em.close();
    }

}
