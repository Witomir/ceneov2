package pl.witomir.ceneov2.search.client;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class RestClient {
    public GetRequest get(String url){
        return Unirest.get(url);
    }

    public HttpRequestWithBody post(String url){
        return Unirest.post(url);
    }
}
