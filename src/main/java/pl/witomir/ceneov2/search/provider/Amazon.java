package pl.witomir.ceneov2.search.provider;

import com.google.inject.Inject;
import pl.witomir.ceneov2.search.client.AmazonHttpClient;
import pl.witomir.ceneov2.search.mapper.AmazonMapper;
import pl.witomir.ceneov2.search.model.Book;

public class Amazon implements ProviderInterface {
    private AmazonHttpClient client;
    private AmazonMapper bookMapper;

    @Inject
    public Amazon(AmazonHttpClient client, AmazonMapper bookMapper) {
        this.client = client;
        this.bookMapper = bookMapper;
    }

    public Book getData(String isbn) {
        String pageHtml = client.getHtml(isbn);
        return bookMapper.mapToBook(pageHtml);
    }
}
