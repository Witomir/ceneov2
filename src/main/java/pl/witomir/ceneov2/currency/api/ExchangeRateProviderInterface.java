package pl.witomir.ceneov2.currency.api;

import pl.witomir.ceneov2.currency.Currency;

public interface ExchangeRateProviderInterface {
    public ExchangeRateModelInterface[] getCurrentRates();
    public Float getRateForCurrency(Currency currency);
}
