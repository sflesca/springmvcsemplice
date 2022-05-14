package psw.spring.springmvcsemplice.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import psw.spring.springmvcsemplice.entities.Book;
import psw.spring.springmvcsemplice.entities.Cliente;
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

    @GetMapping("/one/{bid}")
    public Book getOne(@PathVariable long bid){return service.getBook(bid).get();}

    @GetMapping("/allbycat/{cid}")
    public List<Book> getAll(@PathVariable long cid){return service.getBooksByCatId(cid);}

    @PostMapping(path="/create/{cid}", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book b, @PathVariable("cid") long cid){
        return service.insBook(b.getTitle(),b.getAuthors(),b.getPrice(), cid);
    }
}
