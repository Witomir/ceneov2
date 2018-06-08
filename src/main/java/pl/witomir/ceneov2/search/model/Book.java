package pl.witomir.ceneov2.search.model;

import pl.witomir.ceneov2.currency.Currency;

public class Book {
    private String title;
    private Double price;
    private String link;
    private Currency currency;

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Book setPrice(Double price) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book that = (Book) obj;

        return (that.getCurrency() == this.getCurrency()
                && that.getPrice().equals(this.getPrice())
                && that.getLink().equals(this.getLink())
                && that.getTitle().equals(this.getTitle()));
    }
}
