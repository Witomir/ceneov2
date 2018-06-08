package pl.witomir.ceneov2.currency;

import com.google.inject.Inject;
import pl.witomir.ceneov2.currency.api.ExchangeRateProviderInterface;
import pl.witomir.ceneov2.search.model.Book;

import java.util.Comparator;
import java.util.List;

public class PriceComparator implements Comparator<Book> {

    private final ExchangeRateProviderInterface exchangeRateProvider;

    @Inject
    public PriceComparator(ExchangeRateProviderInterface exchangeRateProvider) {
        this.exchangeRateProvider = exchangeRateProvider;
    }

    @Override
    public int compare(Book val1, Book val2) {
        Double firstBookPriceInPLN = getPriceInPln(val1.getCurrency(), val1.getPrice());
        Double secondBookPriceInPLN = getPriceInPln(val2.getCurrency(), val2.getPrice());

        return firstBookPriceInPLN.compareTo(secondBookPriceInPLN);
    }

    public Book chooseCheapestBook(List<Book> books) {
        if(books.isEmpty()) {
            throw new IllegalArgumentException("Nothing to compare");
        }

        return  books.stream().min(this).get();
    }

    private Double getPriceInPln(Currency currency, Double bookPrice) {
        Double rate = exchangeRateProvider.getRateForCurrency(currency);
        return rate * bookPrice;
    }
}
