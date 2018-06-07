package pl.witomir.ceneov2.search.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.witomir.ceneov2.search.model.Book;
import pl.witomir.ceneov2.search.price.Currency;
import pl.witomir.ceneov2.search.price.PriceExtractor;

public class ApressMapper {

    private Gson builder;
    private String baseUri = "https://www.apress.com";
    private String titleLinkSelector = ".result-item-0  > h4 > a";

    @Inject
    public ApressMapper(GsonBuilder builder) {
        this.builder = builder.create();
    }

    public Book mapToBook(String priceApiResponse, String fullPage) {
        pl.witomir.ceneov2.search.model.apress.Book[] bookData = builder.fromJson(priceApiResponse, pl.witomir.ceneov2.search.model.apress.Book[].class);
        Document document = Jsoup.parse(fullPage);
        String title = document.selectFirst(titleLinkSelector).text();
        String link = document.selectFirst(titleLinkSelector).attr("href");
        Currency currency = PriceExtractor.getCurrency(bookData[0].getPrice().getBestPriceFmt());
        String price = PriceExtractor.getAmount(bookData[0].getPrice().getBestPriceFmt());

        return new Book()
                .setTitle(title)
                .setLink(baseUri + link)
                .setPrice(price)
                .setCurrency(currency);
    }
}