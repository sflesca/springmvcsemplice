package psw.spring.springmvcsemplice.services;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psw.spring.springmvcsemplice.entities.Book;
import psw.spring.springmvcsemplice.entities.Category;
import psw.spring.springmvcsemplice.repositories.BookRepository;
import psw.spring.springmvcsemplice.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    @Autowired
    BookRepository rep;

    @Autowired
    CategoryRepository catrep;


    public List<Book> getBooks(){
        return rep.findAll();
    }

    public List<Book> getBooksByCatId(long id){
        return rep.getByCategory(id);
    }

    public Optional<Book> getBook(long id){ return rep.findById(id);}

    public void addBook(@NotNull Book b){
        rep.save(b);
    }

    public Book insBook(@NotNull String title, @NotNull String authors, @NotNull double price, long cid){
        Optional<Category> oc = catrep.findById(cid);
        if (oc.isPresent()) {
            Book b = new Book();
            b.setAuthors(authors);
            b.setTitle(title);
            b.setPrice(price);
            b.setCategory(oc.get());
            return rep.save(b);
        }
        throw new RuntimeException("La categoria non esiste");
    }
}
