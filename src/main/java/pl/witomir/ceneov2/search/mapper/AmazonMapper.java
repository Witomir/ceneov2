package pl.witomir.ceneov2.search.mapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.witomir.ceneov2.search.model.Book;

public class AmazonMapper {

    private String tittleLinkSelector = "#result_0 a.s-color-twister-title-link";
    private String priceTextSelector = "#result_0 span.s-price";

    public Book mapToBook(String pageHtml) {
        Document document = Jsoup.parse(pageHtml);

        String title = document.selectFirst(tittleLinkSelector).text();
        String link = document.selectFirst(tittleLinkSelector).attr("href");
        String price = document.selectFirst(priceTextSelector).text();

        return new Book()
                .setTitle(title)
                .setPrice(price)
                .setLink(link);
    }
}
