package spring_Introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import javax.annotation.PostConstruct;

@Component("dogBean")
//@Scope("prototype")
public class Dog implements Pet{
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @PostConstruct
    public void init(){
        System.out.println("Class Dog: init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Class Dog: destroy method");
    }

    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bow-Wow");
    }
}
