package pl.coderslab.app.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.Book;
import pl.coderslab.app.Category;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {

    Book findBookByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findAllByRating(int rating);
}
