package com.wooahan.exchangerate.model;

import com.wooahan.exchangerate.domain.ExchangeRate;

public class ExchangeRateRequest {
    private String source;
    private String currencies;

    protected ExchangeRateRequest() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String currencies) {
        this.currencies = currencies;
    }

    public ExchangeRate toExchangeRate() {
        return new ExchangeRate(this.source, this.currencies);
    }

    public String createQuoteKey() {
        return this.source.concat(this.currencies);
    }
}
