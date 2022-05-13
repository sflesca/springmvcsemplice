package psw.spring.springmvcsemplice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import psw.spring.springmvcsemplice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
