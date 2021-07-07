package pl.coderslab.app;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HibernatePublisherDao {

    @PersistenceContext
    private EntityManager manager;

    public List<Publisher> all() {
        return manager.createQuery("SELECT p FROM Publisher p").getResultList();
    }

    public Publisher byId(int id) {
        return manager.find(Publisher.class, (long)id);
    }
}
