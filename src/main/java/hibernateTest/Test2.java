package hibernateTest;

import hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> emps = session.createQuery("from Employee").getResultList();

            List<Employee> emps = session.createQuery("from Employee " +
                    "where name='Sasha' AND salary < 600").getResultList();

            for (Employee emp : emps) {
                System.out.println(emp);
            }

            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            factory.close();
        }
    }
}
