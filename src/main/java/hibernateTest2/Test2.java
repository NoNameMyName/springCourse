package hibernateTest2;

import hibernateTest2.entity.Detail;
import hibernateTest2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;

        try {
//            Employee employee = new Employee("Nikolay", "Ivanov",
//                    "HR", 250);
//
//            Detail detail = new Detail("New-York",
//                    "+465418103", "rhjnn23kdsf@gmail.com");

//            detail.setEmployee(employee);
//            employee.setEmpDetail(detail);

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

//            session.save(detail);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
