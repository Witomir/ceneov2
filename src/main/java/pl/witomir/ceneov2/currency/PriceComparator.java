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
            return null;
        }

        Float minPrice = (float) 9999999;
        Book cheapestBook = books.get(0);
        for (Book book : books) {
            Float priceInPln = getPriceInPln(book.getCurrency(), book.getPrice());

            if(priceInPln < minPrice){
                minPrice = priceInPln;
                cheapestBook = book;
            }
        }

        return cheapestBook;
    }

    public Float getPriceInPln(Currency currency, Float bookPrice) {
        Float rate = exchangeRateProvider.getRateForCurrency(currency);
        return rate * bookPrice;
    }
}
