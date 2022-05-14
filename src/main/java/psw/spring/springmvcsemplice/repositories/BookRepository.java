package psw.spring.springmvcsemplice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import psw.spring.springmvcsemplice.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.category.id = :cid")
    public List<Book> getByCategory(@Param("cid") long categoryId);
}
