package psw.spring.springmvcsemplice.services;

import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Service;
import psw.spring.springmvcsemplice.entities.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private ArrayList<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(0,"Primo Libro","Io",9.99));
        books.add(new Book(1,"Secondo Libro","Tu",6.99));
    }

    public List<Book> getBooks(){
        return books;
    }

    public void addBook(@NotNull Book b){
        books.add(b);
    }
}
