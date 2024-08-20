package hibernateManyToMany;

import hibernateManyToMany.entity.Child;
import hibernateManyToMany.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session s = null;

        try {
            s = factory.getCurrentSession();

            Section Section1 = new Section("Volleyball");
            Section Section2 = new Section("Chess");
            Section Section3 = new Section("Math");
            Child child1 = new Child("Igor", 10);
            child1.addSectionToChild(Section1);
            child1.addSectionToChild(Section2);
            child1.addSectionToChild(Section3);

            s.beginTransaction();

            s.delete(s.get(Child.class, 4));
            s.save(child1);

            s.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            s.close();
            factory.close();
        }
    }
}
