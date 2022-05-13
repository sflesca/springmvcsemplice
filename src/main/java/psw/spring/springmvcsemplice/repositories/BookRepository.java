package psw.spring.springmvcsemplice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import psw.spring.springmvcsemplice.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
