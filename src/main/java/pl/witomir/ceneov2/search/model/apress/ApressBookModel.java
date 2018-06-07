package pl.witomir.ceneov2.search.model.apress;

public class ApressBookModel {
    private String id;
    private String type;
    private ApressBookPrice price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ApressBookPrice getPrice() {
        return price;
    }

    public void setPrice(ApressBookPrice price) {
        this.price = price;
    }
}
