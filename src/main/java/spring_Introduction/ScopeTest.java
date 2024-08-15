package spring_Introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Dog myDog = context.getBean("dogBean", Dog.class);
        Dog yourDog = context.getBean("dogBean", Dog.class);

        System.out.println("Собаки ссылаються на один и тот же обьект? " + (myDog == yourDog));

        System.out.println(myDog);
        System.out.println(yourDog);
        context.close();
    }
}
