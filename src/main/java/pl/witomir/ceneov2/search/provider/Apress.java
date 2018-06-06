package pl.witomir.ceneov2.search.provider;

import com.google.inject.Inject;
import pl.witomir.ceneov2.search.client.ApressHttpClient;
import pl.witomir.ceneov2.search.mapper.ApressMapper;
import pl.witomir.ceneov2.search.model.Book;

public class Apress implements ProviderInterface {
    private final ApressHttpClient client;
    private ApressMapper apressMapper;

    @Inject
    public Apress(ApressHttpClient client, ApressMapper apressMapper) {
        this.client = client;
        this.apressMapper = apressMapper;
    }

    public Book getData(String isbn) {
        String pageHtm = client.fetchPageHtml(isbn);
        String priceData = client.callPriceData(isbn);

        return apressMapper.mapToBook(priceData, pageHtm);
    }
}
