package pl.witomir.ceneov2.search.model;

import pl.witomir.ceneov2.currency.Currency;

public class Book {
    private String title;
    private String price;
    private String link;
    private Currency currency;

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Book setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Book setLink(String link) {
        this.link = link;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Book setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }
}
