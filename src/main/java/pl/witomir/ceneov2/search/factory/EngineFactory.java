package pl.witomir.ceneov2.search.factory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.witomir.ceneov2.args.Parser;
import pl.witomir.ceneov2.isbn.IsbnFinder;
import pl.witomir.ceneov2.search.Engine;
import pl.witomir.ceneov2.currency.PriceComparator;
import pl.witomir.ceneov2.search.provider.Amazon;
import pl.witomir.ceneov2.search.provider.Apress;
import pl.witomir.ceneov2.search.provider.ProviderInterface;
import pl.witomir.ceneov2.view.Renderer;

import java.util.ArrayList;
import java.util.List;

public class EngineFactory implements Provider<Engine> {

    private final Amazon amazon;
    private final Apress apress;
    private Parser parser;
    private Renderer renderer;
    private IsbnFinder isbnFinder;
    private PriceComparator priceComparator;

    @Inject
    public EngineFactory(Amazon amazon,
                         Apress apress,
                         Parser parser,
                         Renderer renderer,
                         IsbnFinder isbnFinder,
                         PriceComparator priceComparator) {
        this.amazon = amazon;
        this.apress = apress;
        this.parser = parser;
        this.renderer = renderer;
        this.isbnFinder = isbnFinder;
        this.priceComparator = priceComparator;
    }

    @Override
    public Engine get() {
        List<ProviderInterface> providers = new ArrayList<ProviderInterface>();
        providers.add(amazon);
        providers.add(apress);

        return new Engine(providers, isbnFinder, parser, priceComparator, renderer);
    }
}
