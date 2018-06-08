package pl.witomir.ceneov2.currency.api.nbp;

import com.google.inject.Inject;
import pl.witomir.ceneov2.currency.Currency;
import pl.witomir.ceneov2.currency.api.ExchangeRateProviderInterface;
import pl.witomir.ceneov2.currency.api.nbp.client.NbpApiClient;
import pl.witomir.ceneov2.currency.api.nbp.model.NbpCurrencyData;
import pl.witomir.ceneov2.currency.api.nbp.model.NbpRate;

import java.util.Arrays;
import java.util.Optional;

public class NbpExchangeRateProvider implements ExchangeRateProviderInterface {

    private NbpCurrencyData currencyData;

    @Inject
    public NbpExchangeRateProvider(NbpApiClient nbpApiClient) {
        currencyData = nbpApiClient.fetchExchangeRates();
    }


    public NbpRate[] getCurrentRates() {
        return currencyData.getRates();
    }

    public Double getRateForCurrency(Currency currency) {
        Optional<NbpRate> rate = Arrays.stream(getCurrentRates()).filter(ex -> ex.getCode().equals(currency.toString())).findFirst();
        if (rate.isPresent()) {
            return rate.get().getMid();
        } else {
            throw new IllegalArgumentException("unknown currency");
        }
    }
}