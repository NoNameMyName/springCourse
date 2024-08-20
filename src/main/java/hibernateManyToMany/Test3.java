package hibernateManyToMany;

import hibernateManyToMany.entity.Child;
import hibernateManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session s = null;

        try {
            s = factory.getCurrentSession();


//            s.beginTransaction();
//
////            Section section = s.get(Section.class, 1);
////            System.out.println(section);
////            System.out.println(section.getChildren());
//
//            Child child = s.get(Child.class, 5);
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            s.getTransaction().commit();
//            System.out.println("Done!");
            s.beginTransaction();

            Section section = s.get(Section.class, 1);

            s.delete(section);

            s.getTransaction().commit();
            System.out.println("Done!");


        }
        finally {
            s.close();
            factory.close();
        }
    }
}

