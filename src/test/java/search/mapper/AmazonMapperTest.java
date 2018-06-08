package search.mapper;

import junit.framework.TestCase;
import pl.witomir.ceneov2.currency.Currency;
import pl.witomir.ceneov2.search.exception.BookNotFoundException;
import pl.witomir.ceneov2.search.mapper.AmazonMapper;
import pl.witomir.ceneov2.search.model.Book;

import java.io.IOException;

public class AmazonMapperTest extends TestCase {
    public void testBookMapping() throws IOException, BookNotFoundException {
        AmazonMapper mapper = new AmazonMapper();
        String response = new ResourceReader().getResourceFileAsString("amazon_search_response.html");
        Book book = mapper.mapToBook(response);

        Book expectedBook = new Book()
                .setCurrency(Currency.GBP)
                .setPrice(21.18)
                .setLink("https://www.amazon.co.uk/Clean-Sustainable-Software-Development-Practices/dp/1484227921/ref=sr_1_1?ie=UTF8&qid=1528370596&sr=8-1&keywords=9781484227923")
                .setTitle("Clean C++: Sustainable Software Development Patterns and Best Practices with C++ 17");

        assertEquals(expectedBook, book);
    }

}
