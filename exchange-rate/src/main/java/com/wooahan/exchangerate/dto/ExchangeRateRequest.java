package com.wooahan.exchangerate.dto;

import com.wooahan.exchangerate.common.ExchangeValidator;
import com.wooahan.exchangerate.domain.ExchangeRate;

public class ExchangeRateRequest {
    private String source;
    private String currencies;

    public ExchangeRateRequest(String source, String currencies) {
        this.source = source;
        this.currencies = currencies;
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

    public String createQuoteKey() {
        return this.source.concat(this.currencies);
    }

    public ExchangeRate toExchangeRate() {
        ExchangeValidator.validator(this.source);
        ExchangeValidator.validator(this.currencies);
        return new ExchangeRate(this.source, this.currencies);
    }
}
