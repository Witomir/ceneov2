package pl.witomir.ceneov2.search.provider;

import com.google.inject.Inject;
import pl.witomir.ceneov2.search.client.AmazonHttpClient;
import pl.witomir.ceneov2.search.mapper.AmazonMapper;
import pl.witomir.ceneov2.search.model.Book;

public class AmazonDataProvider implements ProviderInterface {
    private AmazonHttpClient amazonHttpClient;
    private AmazonMapper bookMapper;

    @Inject
    public AmazonDataProvider(AmazonHttpClient amazonHttpClient, AmazonMapper bookMapper) {
        this.amazonHttpClient = amazonHttpClient;
        this.bookMapper = bookMapper;
    }

    public Book getBookData(String isbn) {
        try {
            String pageHtml = amazonHttpClient.getHtml(isbn);
            return bookMapper.mapToBook(pageHtml);
        } catch (Exception e) {
            return null;
        }
    }
}
