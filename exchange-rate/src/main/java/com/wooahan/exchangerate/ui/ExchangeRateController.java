package com.wooahan.exchangerate.ui;

import com.wooahan.exchangerate.application.ExchangeRateService;
import com.wooahan.exchangerate.model.ExchangeRateRequest;
import com.wooahan.exchangerate.model.ExchangeRateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {
    private ExchangeRateService exchangeRateService;

    public ExchangeRateController(final ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @PostMapping("/ExchangeRate")
    public ResponseEntity<ExchangeRateResponse> createStation(@RequestBody ExchangeRateRequest exchangeRateRequest) {
        ExchangeRateResponse exchangeRate = exchangeRateService.exchangeRate(exchangeRateRequest);
        return new ResponseEntity<ExchangeRateResponse>(exchangeRate, HttpStatus.OK);
    }
}
