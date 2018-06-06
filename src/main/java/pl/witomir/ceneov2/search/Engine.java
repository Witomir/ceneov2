package pl.witomir.ceneov2.search;

import com.google.inject.Inject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Engine {

    @Inject
    public Engine(){
    }

    public void bookSearch(String isbn){
        try {
            HttpResponse<String> jsonNodeHttpResponse = Unirest.get("https://www.amazon.co.uk/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords=978-1-4842-2792-3&rh=n%3A266239%2Ck%3A978-1-4842-2792-3")
//                    .queryString("query", "978-1-4842-2792-3")
                    .asString();
//            HttpResponse<String> jsonNodeHttpResponse = Unirest.get("https://www.apress.com/us/search")
//                    .queryString("query", "978-1-4842-2792-3")
//                    .asString();
            System.out.println(jsonNodeHttpResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
