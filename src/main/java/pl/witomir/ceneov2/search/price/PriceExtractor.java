package pl.witomir.ceneov2.search.price;

public class PriceExtractor {
    public static String getPriceFromString(String price){
        return price.substring(1);
    }

    public static Currency getCurrency(String price){
        switch (price.substring(0, 1)){
            case "$": {
                return Currency.USD;
            }
            case "£": {
                return Currency.GBP;
            }
            default: {
                throw new IllegalArgumentException("Unknown currency");
            }
        }
    }
}