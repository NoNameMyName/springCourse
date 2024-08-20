package hibernateOneToManyBi;

import hibernateOneToManyBi.entity.Department;
import hibernateOneToManyBi.entity.Employee;
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

//            Department department = new Department("Sales", 800, 1500);
//            Employee employee1 = new Employee("Roman", "Smykov", 900);
//            Employee employee2 = new Employee("Sasha", "Chuhalo", 1300);
//            Employee employee3 = new Employee("Anton", "Sidorov", 1000);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            department.addEmployeeToDepartment(employee3);
//
//
//            session.beginTransaction();
//
//            session.save(department);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done");

// *******************************************

            session.beginTransaction();

            System.out.println("Get department");
            Department department = session.get(Department.class, 3);

            System.out.println("Show department");
            System.out.println(department);
            System.out.println("show employees of the department");
            System.out.println(department.getEmps());

//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());

            session.getTransaction().commit();

            System.out.println("Done");

// *******************************************

//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 2);
//
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done");


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
