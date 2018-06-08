package pl.witomir.ceneov2.search.provider;

import com.google.inject.Inject;
import pl.witomir.ceneov2.search.client.ApressHttpClient;
import pl.witomir.ceneov2.search.mapper.ApressMapper;
import pl.witomir.ceneov2.search.model.Book;

public class ApressDataProvider implements ProviderInterface {
    private ApressHttpClient apressHttpClient;
    private ApressMapper apressMapper;

    @Inject
    public ApressDataProvider(ApressHttpClient apressHttpClient, ApressMapper apressMapper) {
        this.apressHttpClient = apressHttpClient;
        this.apressMapper = apressMapper;
    }

    public Book getBookData(String isbn) {

        try {
            String pageHtml = apressHttpClient.fetchPageHtml(isbn);
            String priceData = apressHttpClient.fetchPriceData(isbn);
            return apressMapper.mapToBook(priceData, pageHtml);
        } catch (Exception e) {
            return null;
        }
    }
}
