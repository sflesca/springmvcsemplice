package psw.spring.springmvcsemplice.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import psw.spring.springmvcsemplice.entities.Category;
import psw.spring.springmvcsemplice.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping(path="/rest/cat",
        produces="application/json")
@CrossOrigin(origins = "*")
public class CategoryRestController {
    @Autowired
    CategoryService service;

    @GetMapping("/all")
    public List<Category> getAll(){return service.getAll();}
}
