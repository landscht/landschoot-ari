import entities.Employee;

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

        Employee employee = new Employee();
        employee.setFirstname("Tony");
        employee.setLastname("Landschoot");
        em.persist(employee);

        em.close();
    }

}
