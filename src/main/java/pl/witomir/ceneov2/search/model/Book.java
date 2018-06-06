package pl.witomir.ceneov2.search.model;

public class Book {
    private String title;
    private String price;
    private String link;

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
}
