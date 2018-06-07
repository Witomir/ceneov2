package pl.witomir.ceneov2.view;

import pl.witomir.ceneov2.search.model.Book;

import java.util.List;

public class Renderer {
    public void renderResult(Book result) {
        System.out.println(result.getPrice() + result.getCurrency() + " " + result.getLink());
    }
}
