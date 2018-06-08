package pl.witomir.ceneov2.currency;

import com.google.inject.Inject;
import pl.witomir.ceneov2.currency.api.ExchangeRateProviderInterface;
import pl.witomir.ceneov2.search.model.Book;

import java.util.List;

public class PriceComparator {

    private final ExchangeRateProviderInterface exchangeRateProvider;

    @Inject
    public PriceComparator(ExchangeRateProviderInterface exchangeRateProvider) {
        this.exchangeRateProvider = exchangeRateProvider;
    }

    public Book chooseCheapestBook(List<Book> books) {
        if(books.isEmpty()) {
            throw new IllegalArgumentException("Nothing to compare");
        }

        Double minPrice = 9999999.00;
        Book cheapestBook = books.get(0);
        for (Book book : books) {
            Double priceInPln = getPriceInPln(book.getCurrency(), book.getPrice());

            if(priceInPln < minPrice){
                minPrice = priceInPln;
                cheapestBook = book;
            }
        }

        return cheapestBook;
    }

    private Double getPriceInPln(Currency currency, Double bookPrice) {
        Double rate = exchangeRateProvider.getRateForCurrency(currency);
        return rate * bookPrice;
    }
}
