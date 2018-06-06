package pl.witomir.ceneov2.view;

import pl.witomir.ceneov2.search.model.Book;

import java.util.List;

public class Renderer {
    public void renderResults(List<Book> results) {
        for (Book result : results) {
            System.out.println(result.getPrice() + " " + result.getLink());
        }
    }
}
