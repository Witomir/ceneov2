package pl.witomir.ceneov2;

import com.google.inject.AbstractModule;
import pl.witomir.ceneov2.currency.api.ExchangeRateProviderInterface;
import pl.witomir.ceneov2.currency.api.nbp.NbpExchangeRateProvider;
import pl.witomir.ceneov2.search.Engine;
import pl.witomir.ceneov2.search.factory.EngineFactory;

public class DiModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Engine.class).toProvider(EngineFactory.class);
        bind(ExchangeRateProviderInterface.class).to(NbpExchangeRateProvider.class);
    }
}
