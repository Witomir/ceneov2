package pl.witomir.ceneov2.currency;

public class PriceExtractor {
    public static Float getAmount(String price) {
        return Float.valueOf(price.substring(1));
    }

    public static Currency getCurrency(String price) {
        switch (price.substring(0, 1)) {
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
