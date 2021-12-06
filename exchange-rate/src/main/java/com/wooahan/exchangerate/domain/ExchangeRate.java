package com.wooahan.exchangerate.domain;

public class ExchangeRate {
    private String source;
    private String currencies;

    public ExchangeRate(String source, String currencies) {
        this.source = source;
        this.currencies = currencies;
    }

    public String getSource() {
        return source;
    }

    public String getCurrencies() {
        return currencies;
    }
}
