package hibernateTest;

import hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Aseniy", "Popov",
                    "IT", 350);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println(emp);
        }
        finally {
            factory.close();
        }
        System.out.println("Done");
    }
}
