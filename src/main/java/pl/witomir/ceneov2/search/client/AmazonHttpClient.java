package pl.witomir.ceneov2.search.client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AmazonHttpClient {

    private String baseUri = "https://www.amazon.co.uk/s/ref=nb_sb_noss?";

    public AmazonHttpClient() {

    }

    public String getHtml(String searchTerm) {
        try {
            HttpResponse<String> responseBody = Unirest.get(baseUri)
                    .queryString("field-keywords", searchTerm)
                    .asString();
            return responseBody.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return "";
        }
    }
}
