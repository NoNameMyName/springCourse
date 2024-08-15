package aop.aspects;

import aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    @Before("execution (* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: logging list of got students before getStudents method");
    }

    @AfterReturning(pointcut = "execution (* getStudents())", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){
        Student fisrstStudent = students.get(1);
        String nameSurname = fisrstStudent.getNameSurname();
        nameSurname = "Mr. " + nameSurname;
        fisrstStudent.setNameSurname(nameSurname);

        System.out.println("afterReturningGetStudentsLoggingAdvice: logging list of got students after getStudents method");
    }

    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
        System.out.println("afterThrowingGetStudentsLoggingAdvice: logging the exception was thrown\n" + exception);


    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: logging normal ending of method\n");
    }


}
