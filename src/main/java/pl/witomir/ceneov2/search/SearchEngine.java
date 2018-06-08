package pl.witomir.ceneov2.search;

import com.google.inject.Inject;
import pl.witomir.ceneov2.args.ArgsParser;
import pl.witomir.ceneov2.isbn.IsbnFinder;
import pl.witomir.ceneov2.search.model.Book;
import pl.witomir.ceneov2.currency.PriceComparator;
import pl.witomir.ceneov2.search.provider.ProviderInterface;
import pl.witomir.ceneov2.view.Renderer;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<ProviderInterface> providers;
    private IsbnFinder isbnFinder;
    private ArgsParser argsArgsParser;
    private PriceComparator priceComparator;
    private Renderer renderer;

    @Inject
    public SearchEngine(
            List<ProviderInterface> bookProviders,
            IsbnFinder isbnFinder,
            ArgsParser consoleArgumentsParser,
            PriceComparator priceComparator,
            Renderer renderer
    ) {
        this.providers = bookProviders;
        this.isbnFinder = isbnFinder;
        this.argsArgsParser = consoleArgumentsParser;
        this.priceComparator = priceComparator;
        this.renderer = renderer;
    }

    public void bookSearch(String[] args) {
        String title = argsArgsParser.parseArgs(args);
        String isbn = isbnFinder.findIsbnByTitle(title);
        List<Book> results = search(isbn);
        renderer.renderResult(priceComparator.chooseCheapestBook(results));
    }

    private List<Book> search(String isbn) {
        List<Book> results = new ArrayList<Book>();
        for (ProviderInterface provider : providers) {
            results.add(provider.getBookData(isbn));
        }

        return results;
    }
}
