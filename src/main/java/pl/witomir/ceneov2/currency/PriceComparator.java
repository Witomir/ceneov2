package pl.witomir.ceneov2.currency;

import com.google.inject.Inject;
import pl.witomir.ceneov2.currency.api.ExchangeRateModelInterface;
import pl.witomir.ceneov2.currency.api.ExchangeRateProviderInterface;
import pl.witomir.ceneov2.search.model.Book;

import java.util.List;

public class PriceComparator {

    private final ExchangeRateProviderInterface exchangeRateProvider;

    @Inject
    public PriceComparator(ExchangeRateProviderInterface exchangeRateProvider) {
        this.exchangeRateProvider = exchangeRateProvider;
    }

    public Book chooseCheaperBook(List<Book> books) {
        ExchangeRateModelInterface[] rates = exchangeRateProvider.getCurrentRates();


        return books.get(0);
    }
}
