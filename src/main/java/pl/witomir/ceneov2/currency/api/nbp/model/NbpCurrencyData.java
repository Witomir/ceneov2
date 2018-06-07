package pl.witomir.ceneov2.currency.api.nbp.model;

public class NbpCurrencyData {
    private String table;
    private String effectiveDate;
    private NbpRate[] rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public NbpRate[] getRates() {
        return rates;
    }

    public void setRates(NbpRate[] rates) {
        this.rates = rates;
    }
}
