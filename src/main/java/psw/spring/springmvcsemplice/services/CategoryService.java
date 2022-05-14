package psw.spring.springmvcsemplice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import psw.spring.springmvcsemplice.entities.Category;
import psw.spring.springmvcsemplice.repositories.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository rep;

    public List<Category> getAll(){
        return rep.findAll();
    }
}
