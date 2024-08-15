package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Main method starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("Uni", UniLibrary.class);

        try {
            String bookName = uniLibrary.returnBook();
            System.out.println("To library was returned " + bookName);
        }
        catch (Exception e){
            System.out.println(e);
        }

        context.close();
        System.out.println("Main method ends");
    }
}
