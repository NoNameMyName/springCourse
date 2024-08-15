package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Roman Smykov", 3, 7.5);
        Student st2 = new Student("Mikhail Ivanov", 2, 8.5);
        Student st3 = new Student("Sasha Chuhalo", 5, 6.6);

        students.add(st1);
        students.add(st2);
        students.add(st3);

    }

    public List<Student> getStudents(){
        System.out.println("Method starts");
        System.out.println("Information from method students: ");
        System.out.println(students);
        return students;
    }

}
