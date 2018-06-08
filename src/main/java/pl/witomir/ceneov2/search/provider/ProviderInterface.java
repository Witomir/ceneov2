package pl.witomir.ceneov2.search.provider;

import pl.witomir.ceneov2.search.model.Book;

public interface ProviderInterface {
    Book getBookData(String isbn);
}
