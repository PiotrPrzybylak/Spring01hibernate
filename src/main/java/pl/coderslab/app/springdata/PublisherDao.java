package pl.coderslab.app.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.Publisher;


public interface PublisherDao extends JpaRepository<Publisher, Long> {

    Publisher findPublisherByNip(String nip);

    Publisher findPublisherByRegon(String regon);

    Publisher findPublishersById (long id);
}
