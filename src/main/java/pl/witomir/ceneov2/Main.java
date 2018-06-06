package pl.witomir.ceneov2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import pl.witomir.ceneov2.args.Parser;
import pl.witomir.ceneov2.search.Engine;

public class Main {
    public static void main(String[] args){
        Injector injector = Guice.createInjector(new DiModule());
        Engine engine = injector.getInstance(Engine.class);
        Parser parser = injector.getInstance(Parser.class);
        engine.bookSearch(parser.parseArgs(args));
    }
}
