package pl.coderslab.app;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HibernateBookDao {

    @PersistenceContext
    private EntityManager manager;

    public List<Book> all() {
        return manager.createQuery("SELECT book FROM Book book").getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        Query query = manager.createQuery("SELECT book FROM Book book WHERE book.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public void save(Book book) {
        manager.persist(book);
    }
}
