package pl.witomir.ceneov2.search.provider;

import com.google.inject.Inject;
import pl.witomir.ceneov2.search.client.ApressHttpClient;
import pl.witomir.ceneov2.search.mapper.ApressMapper;
import pl.witomir.ceneov2.search.model.Book;

public class ApressDataProvider implements ProviderInterface {
    private final ApressHttpClient apressHttpClient;
    private ApressMapper apressMapper;

    @Inject
    public ApressDataProvider(ApressHttpClient apressHttpClient, ApressMapper apressMapper) {
        this.apressHttpClient = apressHttpClient;
        this.apressMapper = apressMapper;
    }

    public Book getBookData(String isbn) {
        String pageHtml = apressHttpClient.fetchPageHtml(isbn);
        String priceData = apressHttpClient.fetchPriceData(isbn);

        return apressMapper.mapToBook(priceData, pageHtml);
    }
}
