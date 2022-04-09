package psw.spring.springmvcsemplice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import psw.spring.springmvcsemplice.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String getBooks(Model m){
        m.addAttribute("books", bookService.getBooks());
        return "bookslist.jsp";
    }
}
