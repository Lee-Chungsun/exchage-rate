package com.wooahan.exchangerate.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@NoArgsConstructor
@ToString
public class ApiLayerResponse {
    private boolean success;
    private String terms;
    private String privacy;
    private LocalDateTime timestamp;
    private String source;
    private Map<String, BigDecimal> quotes;

    @Builder
    public ApiLayerResponse(boolean success, String terms, String privacy, LocalDateTime timestamp,
                            String source, Map<String, BigDecimal> quotes) {
        this.success = success;
        this.terms = terms;
        this.privacy = privacy;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
    }

    public ExchangeRateResponse toExchangeRateResponse(String quoteKey) {
        return ExchangeRateResponse.toExchangeRateResponse(quotes.getOrDefault(quoteKey, BigDecimal.ZERO));
    }
}
