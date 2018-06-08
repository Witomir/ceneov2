package pl.witomir.ceneov2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import pl.witomir.ceneov2.di.DiModule;
import pl.witomir.ceneov2.search.SearchEngine;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DiModule());
        SearchEngine searchEngine = injector.getInstance(SearchEngine.class);
        searchEngine.bookSearch(args);
    }
}
