package pl.witomir.ceneov2.search.mapper;

import org.jsoup.nodes.Document;
import pl.witomir.ceneov2.search.model.Book;

public interface BookMapperInterface {
    public Book mapDocumentToBook(Document document);
}
