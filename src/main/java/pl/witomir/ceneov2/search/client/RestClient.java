package pl.witomir.ceneov2.search.client;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RestClient {

    private static final int CONNECTION_TIMEOUT = 2000;

    public RestClient() {
        Unirest.setTimeouts(CONNECTION_TIMEOUT, CONNECTION_TIMEOUT);
    }

    public String get(String url) throws UnirestException {
        return Unirest.get(url).asString().getBody();
    }

    public String search(String url, String searchField, String searchTerm) throws UnirestException {
        return Unirest
                .get(url)
                .queryString(searchField, searchTerm)
                .asString()
                .getBody();
    }

    public String postJson(String url, String body) throws UnirestException {
        return Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(body)
                .asString()
                .getBody();
    }
}
