package pl.witomir.ceneov2.isbn;

import com.google.inject.Inject;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import pl.witomir.ceneov2.search.client.AmazonHttpClient;
import pl.witomir.ceneov2.search.client.RestClient;
import pl.witomir.ceneov2.search.mapper.AmazonMapper;

public class IsbnFinder {
    private AmazonHttpClient amazonHttpClient;
    private AmazonMapper amazonMapper;
    private RestClient restClient;

    @Inject
    public IsbnFinder(AmazonHttpClient amazonHttpClient, AmazonMapper amazonMapper, RestClient restClient) {
        this.amazonHttpClient = amazonHttpClient;
        this.amazonMapper = amazonMapper;
        this.restClient = restClient;
    }

    public String findIsbnByTitle(String title) {
        try {
            String pageHtml = amazonHttpClient.getHtml(title);
            String bookLink = amazonMapper.mapToBook(pageHtml).getLink();
            String bookDetailsHtml = restClient.get(bookLink);
            Document bookDetailsDocument = Jsoup.parse(bookDetailsHtml);
            String isbn = extractIsbn(bookDetailsDocument);
            if (isbn != null) return isbn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("ISBN not found");
    }

    private String extractIsbn(Document bookDetailsDocument) {
        for (Element row : bookDetailsDocument.select("#detail_bullets_id li")) {
            if (row.text().matches(".*ISBN-13:.*")) {
                return row.text().substring(9);
            }
        }
        return null;
    }
}
