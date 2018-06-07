package pl.witomir.ceneov2.currency.api.nbp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.mashape.unirest.http.exceptions.UnirestException;
import pl.witomir.ceneov2.currency.Currency;
import pl.witomir.ceneov2.currency.api.ExchangeRateProviderInterface;
import pl.witomir.ceneov2.currency.api.nbp.model.NbpCurrencyData;
import pl.witomir.ceneov2.currency.api.nbp.model.NbpRate;
import pl.witomir.ceneov2.search.client.RestClient;

import java.util.Arrays;
import java.util.Optional;

public class NbpExchangeRateProvider implements ExchangeRateProviderInterface {

    private static final String NBP_API_URI = "http://api.nbp.pl/api/exchangerates/tables/a?format=json";
    private final RestClient restClient;
    private Gson gson;
    private NbpCurrencyData currencyData;

    @Inject
    public NbpExchangeRateProvider(RestClient restClient, GsonBuilder gsonBuilder) {
        this.restClient = restClient;
        this.gson = gsonBuilder.create();
        fetchExchangeRates();
    }

    public void fetchExchangeRates() {
        try {
            String exchangeRates = restClient.get(NBP_API_URI);
            currencyData = gson.fromJson(exchangeRates, NbpCurrencyData[].class)[0];

        } catch (UnirestException e) {
            throw new RuntimeException("cannot fetch currency data");
        }
    }

    public NbpRate[] getCurrentRates() {
        return currencyData.getRates();
    }

    public Float getRateForCurrency(Currency currency) {
        Optional<NbpRate> rate = Arrays.stream(getCurrentRates()).filter(ex -> ex.getCode().equals(currency.toString())).findFirst();
        if (rate.isPresent()) {
            return rate.get().getMid();
        } else {
            throw new IllegalArgumentException("unknown currency");
        }
    }
}