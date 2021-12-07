package com.wooahan.exchangerate.application;

import com.wooahan.exchangerate.api.ApiLayerService;
import com.wooahan.exchangerate.domain.ExchangeRate;
import com.wooahan.exchangerate.dto.ApiLayerResponse;
import com.wooahan.exchangerate.dto.ExchangeRateRequest;
import com.wooahan.exchangerate.dto.ExchangeRateResponse;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {
    private ApiLayerService apiLayerService;

    public ExchangeRateService(final ApiLayerService apiLayerService) {
        this.apiLayerService = apiLayerService;
    }

    public ExchangeRateResponse exchangeRate(ExchangeRateRequest request) {
        ExchangeRate exchangeRate = request.toExchangeRate();
        ApiLayerResponse response = apiLayerService.getExchangeRate(exchangeRate).block();

        return response.toExchangeRateResponse(request.createQuoteKey());
    }
}
