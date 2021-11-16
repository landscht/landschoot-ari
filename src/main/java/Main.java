import entities.Employee;
import entities.Entreprise;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

        em.getTransaction().commit();
        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setFirstname("Tony");
        employee.setLastname("Landschoot");
        employee.setEntreprise(entreprise);
        em.persist(employee);

        Employee employeeGabriel = new Employee();
        employeeGabriel.setFirstname("Gabriel");
        employeeGabriel.setLastname("Congin");
        employeeGabriel.setEntreprise(entreprise);
        em.persist(employeeGabriel);

        Employee employeeNicolas = new Employee();
        employeeNicolas.setFirstname("Nicolas");
        employeeNicolas.setLastname("Perreira");
        employeeNicolas.setEntreprise(entreprise);
        em.persist(employeeNicolas);

        Employee employeeSami = new Employee();
        employeeSami.setFirstname("Sami");
        employeeSami.setLastname("Lejeune");
        employeeSami.setEntreprise(entreprise);
        em.persist(employeeSami);

        em.getTransaction().commit();

        em.close();
    }

}
