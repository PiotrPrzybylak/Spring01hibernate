package pl.coderslab.app.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.Author;

import java.util.List;


public interface AuthorDao extends JpaRepository<Author, Long> {

    Author findAuthorById(long id);

    Author findAuthorByEmail(String email);

    Author findAuthorByPesel(String pesel);

    List<Author> findAuthorsByLastName (String lastName);
}
