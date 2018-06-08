package pl.witomir.ceneov2.currency.api.nbp.model;

import pl.witomir.ceneov2.currency.api.ExchangeRateModelInterface;

public class NbpRate implements ExchangeRateModelInterface {
    private String code;
    private String currency;
    private Double mid;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }
}
