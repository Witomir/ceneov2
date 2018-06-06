package pl.witomir.ceneov2.search.provider;

import pl.witomir.ceneov2.search.model.Book;

public interface ProviderInterface {
    public Book getData(String isbn);
}
