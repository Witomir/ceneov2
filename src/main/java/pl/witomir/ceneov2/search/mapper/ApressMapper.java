package pl.witomir.ceneov2.search.mapper;

import pl.witomir.ceneov2.search.model.Book;

public class ApressMapper {

    public Book mapToBook(pl.witomir.ceneov2.search.model.apress.Book[] book) {
        return new Book()
                .setTitle(book[0].getType())
                .setPrice(book[0].getPrice().getBestPriceFmt());
    }
}
