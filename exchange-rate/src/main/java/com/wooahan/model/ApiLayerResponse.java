package com.wooahan.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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
    private List<Map<String, BigDecimal>> quotes;

    @Builder
    public ApiLayerResponse( boolean success,  String terms,  String privacy,  LocalDateTime timestamp,
                             String source,  List<Map<String, BigDecimal>> quotes) {
        this.success = success;
        this.terms = terms;
        this.privacy = privacy;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
    }
}
