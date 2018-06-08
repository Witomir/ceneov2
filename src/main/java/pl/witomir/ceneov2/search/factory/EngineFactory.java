package pl.witomir.ceneov2.search.factory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.witomir.ceneov2.args.ArgsParser;
import pl.witomir.ceneov2.isbn.IsbnFinder;
import pl.witomir.ceneov2.search.SearchEngine;
import pl.witomir.ceneov2.currency.PriceComparator;
import pl.witomir.ceneov2.search.provider.AmazonDataProvider;
import pl.witomir.ceneov2.search.provider.ApressDataProvider;
import pl.witomir.ceneov2.search.provider.ProviderInterface;
import pl.witomir.ceneov2.view.Renderer;

import java.util.ArrayList;
import java.util.List;

public class EngineFactory implements Provider<SearchEngine> {

    private final AmazonDataProvider amazonDataProvider;
    private final ApressDataProvider apressDataProvider;
    private ArgsParser argsParser;
    private Renderer renderer;
    private IsbnFinder isbnFinder;
    private PriceComparator priceComparator;

    @Inject
    public EngineFactory(AmazonDataProvider amazonDataProvider,
                         ApressDataProvider apressDataProvider,
                         ArgsParser argsParser,
                         Renderer renderer,
                         IsbnFinder isbnFinder,
                         PriceComparator priceComparator) {
        this.amazonDataProvider = amazonDataProvider;
        this.apressDataProvider = apressDataProvider;
        this.argsParser = argsParser;
        this.renderer = renderer;
        this.isbnFinder = isbnFinder;
        this.priceComparator = priceComparator;
    }

    @Override
    public SearchEngine get() {
        List<ProviderInterface> providers = new ArrayList<ProviderInterface>();
        providers.add(amazonDataProvider);
        providers.add(apressDataProvider);

        return new SearchEngine(providers, isbnFinder, argsParser, priceComparator, renderer);
    }
}
