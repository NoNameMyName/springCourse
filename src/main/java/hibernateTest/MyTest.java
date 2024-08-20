package hibernateTest;

import hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyTest {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = new Employee("Sasha", "Tulkov", "Police", 500);
            session.save(emp);
            session.createQuery("from Employee " +
                    "where name='Sasha' and salary < 400")
                    .getResultList().forEach(System.out::println);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
