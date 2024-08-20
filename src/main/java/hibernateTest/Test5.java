package hibernateTest;

import hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 3);
//
//            session.delete(employee);

            session.createQuery("delete from Employee where name = 'Oleg'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}
