package pl.coderslab.app.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.Author;
import pl.coderslab.app.Book;
import pl.coderslab.app.Category;
import pl.coderslab.app.Publisher;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {

    Book findBookByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(Long categoryId);

    List<Book> findAllByRating(int rating);

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByPublisher(Publisher publisher);

    Book findFirstByCategoryOrderByTitle(Category category);

    List<Book> findAllByOrderByTitleAsc();

    @Query("select b from Book b where b.title = ?1")
    List<Book> findByTitleUsingQuery(String title);

    @Query("select b from Book b where b.category = ?1")
    List<Book> findBooksByCategoryUsingQuery(Category category);
}
