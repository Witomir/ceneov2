package currency;


import org.junit.Test;
import pl.witomir.ceneov2.currency.Currency;
import pl.witomir.ceneov2.currency.PriceExtractor;

import static org.junit.Assert.assertEquals;

public class PriceExtractorTest {
    @Test
    public void testExtractingCurrency() {
        assertEquals(Currency.GBP, PriceExtractor.getCurrency("£120"));
        assertEquals(Currency.USD, PriceExtractor.getCurrency("$320"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionForInvalidCurrency() {
        PriceExtractor.getCurrency("€210");
    }

    @Test
    public void testExtractingAmount() {
        assertEquals((Double) 120.20, PriceExtractor.getAmount("£120.20"));
        assertEquals((Double) 320.21, PriceExtractor.getAmount("$320.21"));
    }
}
