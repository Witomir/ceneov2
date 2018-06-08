package pl.witomir.ceneov2.search.client;

import com.google.inject.Inject;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AmazonHttpClient {

    private static final String searchField = "field-keywords";
    private static final String baseUri = "https://www.amazon.co.uk/s/ref=nb_sb_noss?";
    private RestClient restClient;

    @Inject
    public AmazonHttpClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public String getHtml(String searchTerm) {
        try {
            return restClient.search(baseUri, searchField, searchTerm);
        } catch (UnirestException e) {
            e.printStackTrace();
            return "";
        }
    }
}
