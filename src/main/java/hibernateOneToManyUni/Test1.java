package hibernateOneToManyUni;

import hibernateOneToManyUni.entity.Department;
import hibernateOneToManyUni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();

//            Department department = new Department("Sales", 400, 800);
//            Employee employee = new Employee("Sasha", "Chuhalo", 700);
//            Employee employee2 = new Employee("Oleg", "Tatarov", 400);
//
//            System.out.println(employee);
//
//            department.addEmployeeToDepartment(employee);
//            department.addEmployeeToDepartment(employee2);
//
//
//            session.beginTransaction();
//
//            session.save(department);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done");


//            session.beginTransaction();
//
//            Department department = session.get(Department.class, 2);
//
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
//
//            System.out.println("Done");

// *******************************************

            session.beginTransaction();
            Department department = session.get(Department.class, 1);

            session.delete(department);

            session.getTransaction().commit();
            System.out.println("Done");


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
