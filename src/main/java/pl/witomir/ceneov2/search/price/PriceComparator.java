package pl.witomir.ceneov2.search.price;

import pl.witomir.ceneov2.search.model.Book;

import java.util.List;

public class PriceComparator {
    public Book chooseCheaperBook(List<Book> books){
        return books.get(1);
    }
}
