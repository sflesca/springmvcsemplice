package psw.spring.springmvcsemplice.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import psw.spring.springmvcsemplice.entities.Book;
import psw.spring.springmvcsemplice.services.BookService;

import java.util.List;

@RestController
@RequestMapping(path="/rest/book",
        produces="application/json")
@CrossOrigin(origins = "*")
public class BookRestController {

    @Autowired
    BookService service;

    @GetMapping("/all")
    public List<Book> getAll(){return service.getBooks();}
}
