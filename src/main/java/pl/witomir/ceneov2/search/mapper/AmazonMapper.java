package pl.witomir.ceneov2.search.mapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.witomir.ceneov2.search.model.Book;
import pl.witomir.ceneov2.search.price.Currency;
import pl.witomir.ceneov2.search.price.PriceExtractor;

public class AmazonMapper {

    private String tittleLinkSelector = "#result_0 a.s-color-twister-title-link";
    private String priceTextSelector = "#result_0 span.s-price";

    public Book mapToBook(String pageHtml) {
        Document document = Jsoup.parse(pageHtml);

        String title = document.selectFirst(tittleLinkSelector).text();
        String link = document.selectFirst(tittleLinkSelector).attr("href");
        String priceText = document.selectFirst(priceTextSelector).text();
        Currency currency = PriceExtractor.getCurrency(priceText);
        String price = PriceExtractor.getAmount(priceText);

        return new Book()
                .setTitle(title)
                .setPrice(price)
                .setLink(link)
                .setCurrency(currency);
    }
}
