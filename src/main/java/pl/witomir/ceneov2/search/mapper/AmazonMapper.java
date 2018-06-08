package pl.witomir.ceneov2.search.mapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import pl.witomir.ceneov2.currency.Currency;
import pl.witomir.ceneov2.currency.PriceExtractor;
import pl.witomir.ceneov2.search.exception.BookNotFoundException;
import pl.witomir.ceneov2.search.model.Book;

public class AmazonMapper {

    private static final String titleLinkSelector = "#result_0 a.s-color-twister-title-link";
    private static final String priceTextSelector = "#result_0 span.s-price";

    public Book mapToBook(String pageHtml) throws BookNotFoundException {
        Document document = Jsoup.parse(pageHtml);

        Element titleElement = document.selectFirst(titleLinkSelector);
        if(null == titleElement){
            throw new BookNotFoundException();
        }

        String title = titleElement.text();
        String link = document.selectFirst(titleLinkSelector).attr("href");
        String priceText = document.selectFirst(priceTextSelector).text();
        Currency currency = PriceExtractor.getCurrency(priceText);
        Double price = PriceExtractor.getAmount(priceText);

        return new Book()
                .setTitle(title)
                .setPrice(price)
                .setLink(link)
                .setCurrency(currency);
    }
}
