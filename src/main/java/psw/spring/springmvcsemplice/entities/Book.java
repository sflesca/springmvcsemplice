package psw.spring.springmvcsemplice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String authors;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
