package pl.witomir.ceneov2.search.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApressHttpClient {
    private Gson gson;
    private RestClient restClient;
    public static final String baseUri = "https://www.apress.com";
    private static final String searchEndpoint = "/us/search";
    private static final String priceEndpoint = "/us/product-search/ajax/prices";
    private static final String requestTemplate = "[{\"type\":\"book\",\"id\":\"%s\"}]";
    private static final String searchField = "query";

    @Inject
    public ApressHttpClient(GsonBuilder gsonBuilder, RestClient restClient) {
        this.gson = gsonBuilder.create();
        this.restClient = restClient;
    }

    public String fetchPriceData(String isbn) {
        try {
            return restClient.postJson(baseUri + priceEndpoint, generateRequestBody(isbn));
        } catch (UnirestException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String fetchPageHtml(String isbn) {
        try {
            return restClient.search(baseUri + searchEndpoint, searchField, isbn);
        } catch (UnirestException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String generateRequestBody(String isbn) {
        return String.format(requestTemplate, isbn.replaceAll("-", ""));
    }
}
