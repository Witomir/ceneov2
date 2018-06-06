package pl.witomir.ceneov2.search.factory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.witomir.ceneov2.args.Parser;
import pl.witomir.ceneov2.search.Engine;
import pl.witomir.ceneov2.search.provider.Amazon;
import pl.witomir.ceneov2.search.provider.Apress;
import pl.witomir.ceneov2.search.provider.ProviderInterface;

import java.util.ArrayList;
import java.util.List;

public class EngineFactory implements Provider<Engine>{

    private final Amazon amazon;
    private final Apress apress;
    private Parser parser;

    @Inject
    public EngineFactory(Amazon amazon, Apress apress, Parser parser){
        this.amazon = amazon;
        this.apress = apress;
        this.parser = parser;
    }

    @Override
    public Engine get() {
        List<ProviderInterface> providers = new ArrayList<ProviderInterface>();
        providers.add(amazon);
        providers.add(apress);
        return new Engine(providers, parser);
    }
}
