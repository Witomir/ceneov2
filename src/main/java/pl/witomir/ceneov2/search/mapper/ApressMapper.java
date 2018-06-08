package pl.witomir.ceneov2.search.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.witomir.ceneov2.search.client.ApressHttpClient;
import pl.witomir.ceneov2.search.model.Book;
import pl.witomir.ceneov2.currency.Currency;
import pl.witomir.ceneov2.currency.PriceExtractor;
import pl.witomir.ceneov2.search.model.apress.ApressBookModel;

public class ApressMapper {

    private Gson gson;
    private static final String titleLinkSelector = ".result-item-0  > h4 > a";

    @Inject
    public ApressMapper(GsonBuilder gsonBuilder) {
        this.gson = gsonBuilder.create();
    }

    public Book mapToBook(String priceApiResponse, String fullPage) {
        ApressBookModel[] apressBookModelData = gson.fromJson(priceApiResponse, ApressBookModel[].class);
        Document document = Jsoup.parse(fullPage);
        String title = document.selectFirst(titleLinkSelector).text();
        String link = document.selectFirst(titleLinkSelector).attr("href");
        Currency currency = PriceExtractor.getCurrency(apressBookModelData[0].getPrice().getBestPriceFmt());
        Double price = PriceExtractor.getAmount(apressBookModelData[0].getPrice().getBestPriceFmt());

        return new Book()
                .setTitle(title)
                .setLink(ApressHttpClient.baseUri + link)
                .setPrice(price)
                .setCurrency(currency);
    }
}