package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspects {

//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* aop.UniLibrary.returnMagazine(..))")
//    private void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary(){}
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice(){
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: log #10 ");
//    }








//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing log #3");
//    }









    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeGetLoggingAdvice (JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")){
            Object[] args = joinPoint.getArgs();
            for (Object obj: args){
                if (obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Info about book: name - " + myBook.getName() + "\nAuthor - " + myBook.getAuthor());
                }
                else if (obj instanceof String){
                    System.out.println("Book was added by " + obj);
                }
            }
        }



        System.out.println("beforeGetLoggingAdvice: logging and try to take a book/magazine");
    }



//   public void beforeReturnBookAdvice (){
//        System.out.println("beforeReturnBookAdvice: try to return a book");
//    }
//
//    @Before("execution(public void aop.UniLibrary.getBook())")
//    public void beforeGetBookAdvice (){
//        System.out.println("beforeGetBookAdvice: try to take a book");
//    }

//    @Before("execution(public void getBook())")
//    public void beforeGetBookAdvice (){
//        System.out.println("beforeGetBookAdvice: try to take a book");
//    }

}
