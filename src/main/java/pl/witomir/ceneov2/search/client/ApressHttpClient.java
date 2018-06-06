package pl.witomir.ceneov2.search.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import pl.witomir.ceneov2.search.model.apress.Book;

import java.util.List;

public class ApressHttpClient {
    private Gson builder;

    @Inject
    public ApressHttpClient(GsonBuilder builder) {
        this.builder = builder.create();
    }

    public String callPriceData(String isbn) {
        try {
            HttpResponse<String> response = Unirest.post("https://www.apress.com//us/product-search/ajax/prices")
                    .header("Content-Type", "application/json")
                    .body(String.format("[{\"type\":\"book\",\"id\":\"%s\"}]", isbn.replaceAll("-", "")))
                    .asString();

            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String fetchPageHtml(String isbn) {
        try {
            HttpResponse<String> response = Unirest.get("https://www.apress.com/us/search")
                    .queryString("query", isbn)
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return "";
        }

    }
}
