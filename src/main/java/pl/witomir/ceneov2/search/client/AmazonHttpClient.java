package pl.witomir.ceneov2.search.client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AmazonHttpClient {
    public AmazonHttpClient() {

    }

    public String getHtml(String searchTerm) {
        try {
            HttpResponse<String> jsonNodeHttpResponse = Unirest.get("https://www.amazon.co.uk/s/ref=nb_sb_noss?")
                    .queryString("field-keywords", searchTerm)
                    .asString();
            return jsonNodeHttpResponse.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return "";
        }
    }
}
