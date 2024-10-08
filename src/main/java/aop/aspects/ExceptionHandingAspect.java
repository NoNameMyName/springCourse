package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(30)
public class ExceptionHandingAspect {

    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeGetExceptionHandingAdvice(){
        System.out.println("beforeGetExceptionHandingAdvice: exception when trying to take a book/magazine");
    }


}
