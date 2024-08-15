package aop;

import org.springframework.stereotype.Component;

@Component("Uni")
public class UniLibrary extends AbstractLibrary{

    @Override
    public void getBook(){
        System.out.println("We take a book from UniLibrary ");
        System.out.println("--------------------");
    }
    public void getMagazine(){
        System.out.println("We take a magazine from UniLibrary ");
        System.out.println("--------------------");
    }

    public String returnBook(){
        int a = 10/0;
        System.out.println("We return a book to UniLibrary");
        return "War and peace";
    }
    public void returnMagazine() {
        System.out.println("We return a magazine to UniLibrary");
        System.out.println("--------------------");
    }

    public void addBook(String personName, Book book){
        System.out.println("Add a book to UniLibrary");
        System.out.println("--------------------");
    }
    public void addMagazine(){
        System.out.println("Add a magazine to UniLibrary");
        System.out.println("--------------------");
    }
}
