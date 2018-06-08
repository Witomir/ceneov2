package currency;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import pl.witomir.ceneov2.currency.Currency;
import pl.witomir.ceneov2.currency.PriceComparator;
import pl.witomir.ceneov2.currency.api.ExchangeRateProviderInterface;
import pl.witomir.ceneov2.search.model.Book;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PriceComparatorTest {

    private static ExchangeRateProviderInterface exchangeRateProviderInterface;

    @BeforeClass
    public static void setUp() {
        exchangeRateProviderInterface = Mockito.mock(ExchangeRateProviderInterface.class);
        when(exchangeRateProviderInterface.getRateForCurrency(Currency.GBP)).thenReturn(5.00);
        when(exchangeRateProviderInterface.getRateForCurrency(Currency.USD)).thenReturn(3.00);
    }

    @Test
    public void testPriceComparison(){
        PriceComparator comparator = new PriceComparator(exchangeRateProviderInterface);
        List<Book> books = new ArrayList<>();
        Book expensiveBook = new Book().setPrice(2.20).setCurrency(Currency.GBP);
        Book cheapBook = new Book().setPrice(3.10).setCurrency(Currency.USD);
        books.add(expensiveBook);
        books.add(cheapBook);
        assertEquals(cheapBook, comparator.chooseCheapestBook(books));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionWhenNoBooksToCompare(){
        PriceComparator comparator = new PriceComparator(exchangeRateProviderInterface);
        List<Book> books = new ArrayList<>();
        comparator.chooseCheapestBook(books);
    }
}
