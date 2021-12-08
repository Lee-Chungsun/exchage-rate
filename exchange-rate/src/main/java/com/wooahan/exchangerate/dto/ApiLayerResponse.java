package com.wooahan.exchangerate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.wooahan.exchangerate.common.exception.WrongInputMonetaryException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonIgnore
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
        if(!this.success){
            throw new WrongInputMonetaryException("화폐 단위가 오입력되었습니다.");
        }
        return ExchangeRateResponse.toExchangeRateResponse(quotes.getOrDefault(quoteKey, BigDecimal.ZERO));
    }
}
