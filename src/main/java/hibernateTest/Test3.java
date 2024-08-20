package hibernateTest;

import hibernateTest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Oleg", "Sidorov",
                    "Sales", 700);

            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();

            int id = emp.getId();

//            session = factory.getCurrentSession();

//            session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.getTransaction().commit();

            System.out.println(employee);

            System.out.println("Done");

        }
        finally {
            factory.close();
        }
    }
}
