package hibernateManyToMany;

import hibernateManyToMany.entity.Child;
import hibernateManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session s = null;

        try {
            s = factory.getCurrentSession();

            Section section = new Section("Football");
            Child child1 = new Child("Roman", 13);
            Child child2 = new Child("Sasha", 5);
            Child child3 = new Child("Oleg", 8);

            s.beginTransaction();

            s.save(section);

            section.addChildToSection(child1);
            section.addChildToSection(child2);
            section.addChildToSection(child3);

            s.save(child1);
            s.save(child2);
            s.save(child3);

            s.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            s.close();
            factory.close();
        }
    }
}
