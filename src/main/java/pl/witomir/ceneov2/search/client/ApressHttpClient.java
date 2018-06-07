package pl.witomir.ceneov2.search.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApressHttpClient {
    private Gson builder;
    private String baseUri = "https://www.apress.com";
    private String searchEndpoint = "/us/search";
    private String priceEndpoint = "/us/product-search/ajax/prices";
    private String requestTemplate = "[{\"type\":\"book\",\"id\":\"%s\"}]";

    @Inject
    public ApressHttpClient(GsonBuilder builder) {
        this.builder = builder.create();
    }

    public String fetchPriceData(String isbn) {
        try {
            HttpResponse<String> response = Unirest.post(baseUri + priceEndpoint)
                    .header("Content-Type", "application/json")
                    .body(generateRequestBody(isbn))
                    .asString();

            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String fetchPageHtml(String isbn) {
        try {
            HttpResponse<String> response = Unirest.get(baseUri + searchEndpoint)
                    .queryString("query", isbn)
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return "";
        }

    }

    private String generateRequestBody(String isbn) {
        return String.format(requestTemplate, isbn.replaceAll("-", ""));
    }
}
