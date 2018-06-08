package pl.witomir.ceneov2.currency.api.nbp.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.mashape.unirest.http.exceptions.UnirestException;
import pl.witomir.ceneov2.currency.api.nbp.model.NbpCurrencyData;
import pl.witomir.ceneov2.search.client.RestClient;

public class NbpApiClient {

    private static final String NBP_API_URI = "http://api.nbp.pl/api/exchangerates/tables/a?format=json";
    private final Gson gson;
    private RestClient restClient;

    @Inject
    public NbpApiClient(RestClient restClient, GsonBuilder gsonBuilder){
        this.restClient = restClient;
        this.gson = gsonBuilder.create();
    }
    public NbpCurrencyData fetchExchangeRates() {
        try {
            String exchangeRates = restClient.get(NBP_API_URI);
            return gson.fromJson(exchangeRates, NbpCurrencyData[].class)[0];
        } catch (UnirestException e) {
            throw new RuntimeException("cannot fetch currency exchange rates");
        }
    }
}
