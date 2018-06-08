package search.mapper;

import com.google.gson.GsonBuilder;
import junit.framework.TestCase;
import pl.witomir.ceneov2.currency.Currency;
import pl.witomir.ceneov2.search.exception.BookNotFoundException;
import pl.witomir.ceneov2.search.mapper.ApressMapper;
import pl.witomir.ceneov2.search.model.Book;

import java.io.IOException;

public class ApressMapperTest extends TestCase {
    public void testBookMapping() throws IOException, BookNotFoundException {
        ApressMapper mapper = new ApressMapper(new GsonBuilder());
        ResourceReader resourceReader = new ResourceReader();
        String htmlResponse = resourceReader.getResourceFileAsString("apress_search_response.html");
        String priceApiResponse = resourceReader.getResourceFileAsString("apress_price_response.json");
        Book book = mapper.mapToBook(priceApiResponse, htmlResponse);

        Book expectedBook = new Book()
                .setCurrency(Currency.USD)
                .setPrice(29.99)
                .setLink("https://www.apress.com/us/book/9781484227930")
                .setTitle("Clean C++");

        assertEquals(expectedBook, book);
    }

}
