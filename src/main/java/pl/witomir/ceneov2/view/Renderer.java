package pl.witomir.ceneov2.view;

import pl.witomir.ceneov2.search.model.Book;

public class Renderer {
    public void renderResult(Book result) {
        if(null == result){
            System.out.println("No results found");
        } else {
            System.out.println(result.getPrice().toString() + result.getCurrency() + " " + result.getLink());
        }
    }

    public void renderError() {
        System.out.println("Book was not found");
    }
}
