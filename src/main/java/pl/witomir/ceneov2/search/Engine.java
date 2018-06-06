package pl.witomir.ceneov2.search;

import com.google.inject.Inject;
import pl.witomir.ceneov2.args.Parser;
import pl.witomir.ceneov2.search.model.Book;
import pl.witomir.ceneov2.search.provider.ProviderInterface;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    private List<ProviderInterface> providers;
    private Parser argsParser;

    @Inject
    public Engine(List<ProviderInterface> providers, Parser argsParser){
        this.providers = providers;
        this.argsParser = argsParser;
    }

    public void bookSearch(String[] args){
        String isbn = argsParser.parseArgs(args);
        List<Book> results = search(isbn);
        renderResults(results);
    }

    private List<Book> search(String isbn) {
        List<Book> results = new ArrayList<Book>();
        for(ProviderInterface provider : providers){
            results.add(provider.getData(isbn));
        }

        return results;
    }

    private void renderResults(List<Book> results) {
        for(Book result: results){
            System.out.println(result.getPrice());
        }
    }

}
