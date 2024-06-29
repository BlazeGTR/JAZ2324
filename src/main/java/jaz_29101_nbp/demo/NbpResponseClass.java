package jaz_29101_nbp.demo;

public class NbpResponseClass {
    private String table;
    private String currency;
    private String code;
    private RateClass[] rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RateClass[] getRates() {
        return rates;
    }

    public void setRates(RateClass[] rates) {
        this.rates = rates;
    }
}


//{"table":"A","currency":"euro","code":"EUR","rates":[{"no":"212/A/NBP/2023","effectiveDate":"2023-11-02","mid":4.4582}]}
