package com.wooahan.exchangerate.api;

import com.wooahan.exchangerate.dto.ApiLayerResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ApiLayerResponseFixture {
    private static final boolean SUCCESS = true;
    private static final String TERMS = "https:\\/\\/currencylayer.com\\/terms";
    private static final String PRIVACY = "\"https:\\/\\/currencylayer.com\\/privacy\"";
    private static final LocalDateTime TIME_STAMP = LocalDateTime.now();
    private static final String SOURCE = "USD";
    private static final Map<String, BigDecimal> QUOTES = new HashMap<String, BigDecimal>() {
        {
            put("USDEUR", BigDecimal.valueOf(0.887824));
        }
    };

    public static ApiLayerResponse createApiLayerResponse() {
        return ApiLayerResponse.builder()
                .success(SUCCESS)
                .terms(TERMS)
                .privacy(PRIVACY)
                .timestamp(TIME_STAMP)
                .source(SOURCE)
                .quotes(QUOTES)
                .build();
    }
}
