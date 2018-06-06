package pl.witomir.ceneov2.search.model.apress;

public class Price {
    private String bestPrice;
    private String bestPriceFmt;
    private String listPrice;

    public String getBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(String bestPrice) {
        this.bestPrice = bestPrice;
    }

    public String getBestPriceFmt() {
        return bestPriceFmt;
    }

    public void setBestPriceFmt(String bestPriceFmt) {
        this.bestPriceFmt = bestPriceFmt;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public String getListPriceFmt() {
        return listPriceFmt;
    }

    public void setListPriceFmt(String listPriceFmt) {
        this.listPriceFmt = listPriceFmt;
    }

    private String listPriceFmt;
}
