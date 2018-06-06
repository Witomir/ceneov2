package pl.witomir.ceneov2.search.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import pl.witomir.ceneov2.search.client.ApressHttpClient;
import pl.witomir.ceneov2.search.mapper.ApressMapper;
import pl.witomir.ceneov2.search.model.Book;

public class Apress implements ProviderInterface {
    private final ApressHttpClient client;
    private ApressMapper apressMapper;
    private final Gson builder;

    @Inject
    public Apress(ApressHttpClient client, GsonBuilder builder, ApressMapper apressMapper){
        this.builder = builder.create();
        this.client = client;
        this.apressMapper = apressMapper;
    }

    public Book getData(String isbn){
        String page = client.callApi(isbn);
        String apiResponse = client.callPriceApi(isbn);
        pl.witomir.ceneov2.search.model.apress.Book[] bookData = builder.fromJson(apiResponse, pl.witomir.ceneov2.search.model.apress.Book[].class);

        return apressMapper.mapToBook(bookData);
    }
}
