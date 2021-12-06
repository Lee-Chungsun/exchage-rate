package com.wooahan.exchangerate.model;

import java.math.BigDecimal;

public class ExchangeRateResponse {
    private BigDecimal quote;

    public ExchangeRateResponse(BigDecimal quote) {
        this.quote = quote;
    }

    public BigDecimal getQuote() {
        return quote;
    }

    public void setQuote(BigDecimal quote) {
        this.quote = quote;
    }

    public static ExchangeRateResponse toExchangeRateResponse(BigDecimal quote) {
        return new ExchangeRateResponse(quote);
    }
}
