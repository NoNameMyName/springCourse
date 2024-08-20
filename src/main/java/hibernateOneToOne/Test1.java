package hibernateOneToOne;

import hibernateOneToOne.entity.Detail;
import hibernateOneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();

            Employee emp = new Employee("Sasha", "Chuhalo",
                    "sales", 350);
            Detail detail = new Detail("Dnipro",
                    "+380975568471", "56fshgfh3333@gmail.com");

            session.beginTransaction();
            emp = session.get(Employee.class, 2);
            session.delete(emp);
//            session.save(emp);

            //emp.setEmpDetail(detail);
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
