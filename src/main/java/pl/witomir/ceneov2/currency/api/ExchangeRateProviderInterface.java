package pl.witomir.ceneov2.currency.api;

import pl.witomir.ceneov2.currency.Currency;

public interface ExchangeRateProviderInterface {
    ExchangeRateModelInterface[] getCurrentRates();
    Double getRateForCurrency(Currency currency);
}
