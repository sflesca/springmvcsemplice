package psw.spring.springmvcsemplice.services;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psw.spring.springmvcsemplice.entities.Book;
import psw.spring.springmvcsemplice.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    @Autowired
    BookRepository rep;


    public List<Book> getBooks(){
        return rep.findAll();
    }

    public Optional<Book> getBook(long id){ return rep.findById(id);}

    public void addBook(@NotNull Book b){
        rep.save(b);
    }
}
