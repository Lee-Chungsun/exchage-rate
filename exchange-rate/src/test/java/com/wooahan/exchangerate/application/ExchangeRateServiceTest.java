package com.wooahan.exchangerate.application;

import com.wooahan.exchangerate.api.ApiLayerProperties;
import com.wooahan.exchangerate.api.ApiLayerService;
import com.wooahan.exchangerate.common.exception.NotInputMonetaryException;
import com.wooahan.exchangerate.common.exception.WrongInputMonetaryException;
import com.wooahan.exchangerate.dto.ExchangeRateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class ExchangeRateServiceTest {
    private ExchangeRateService exchangeRateService;
    private ApiLayerService apiLayerService;

    @BeforeEach
    void setUp() {
        apiLayerService = new ApiLayerService(new ApiLayerProperties("http://localhost", "testkey"));
        exchangeRateService = new ExchangeRateService(apiLayerService);
    }

    @Test
    @DisplayName("화폐단위 미입력 오류 테스트")
    void NullExceptionTest() {
        ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest(null, "");
        assertThatThrownBy(() -> exchangeRateService.exchangeRate(exchangeRateRequest))
                .isInstanceOf(NotInputMonetaryException.class);
    }

    @Test
    @DisplayName("화폐단위 오입력 오류 테스트")
    void WrongExceptionTest() {
        ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest("A", "AA");
        assertThatThrownBy(() -> exchangeRateService.exchangeRate(exchangeRateRequest))
                .isInstanceOf(WrongInputMonetaryException.class);
    }
}
