package pl.witomir.ceneov2.search.mapper;

import org.jsoup.nodes.Document;
import pl.witomir.ceneov2.search.model.Book;

public class AmazonMapper implements BookMapperInterface {

    public Book mapDocumentToBook(Document document) {
        String title = document.selectFirst("#result_0 a.s-color-twister-title-link").text();
        String link = document.selectFirst("#result_0 a.s-color-twister-title-link").attr("href");
        String price = document.selectFirst("#result_0 span.s-price").text();

        return new Book()
                .setTitle(title)
                .setPrice(price)
                .setLink(link);
    }
}
