package pl.coderslab.app;

import org.springframework.core.convert.converter.Converter;

public class PublisherConverter implements Converter<String, Publisher> {

    private PublisherDao publisherDao;

    public PublisherConverter(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @Override
    public Publisher convert(String source) {
        return publisherDao.byId(Integer.parseInt(source));
    }
}
