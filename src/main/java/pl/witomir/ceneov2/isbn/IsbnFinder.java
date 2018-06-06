package pl.witomir.ceneov2.isbn;

import com.google.inject.Inject;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import pl.witomir.ceneov2.search.client.AmazonHttpClient;
import pl.witomir.ceneov2.search.mapper.AmazonMapper;

public class IsbnFinder {
    private AmazonHttpClient amazonHttpClient;
    private AmazonMapper amazonMapper;

    @Inject
    public IsbnFinder(AmazonHttpClient amazonHttpClient, AmazonMapper amazonMapper){
        this.amazonHttpClient = amazonHttpClient;
        this.amazonMapper = amazonMapper;
    }

    public String findIsbnByTitle(String title) {
        String pageHtml = amazonHttpClient.getHtml(title);
        String bookLink = amazonMapper.mapToBook(pageHtml).getLink();
        try {
            String bookDetailsHtml = Unirest.get(bookLink).asString().getBody();

            Document document = Jsoup.parse(bookDetailsHtml);
            for(Element ele: document.select("#detail_bullets_id li")){
                if(ele.text().matches(".*ISBN-13:.*")){
                    return ele.text().substring(9);
                }
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return "91231231232";
    }
}
