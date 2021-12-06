package com.wooahan.exchangerate.api;

import com.wooahan.exchangerate.domain.ExchangeRate;
import com.wooahan.exchangerate.model.ApiLayerProperties;
import com.wooahan.exchangerate.model.ApiLayerResponse;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@ComponentScan(basePackages={"com.wooahan.exchangerate.model"})
public class ApiLayerService {
    private final WebClient webClient;
    private final String accessKey;

    public ApiLayerService(ApiLayerProperties apiLayerProperties) {
        String baseUri = apiLayerProperties.getBaseUri();
        this.accessKey = apiLayerProperties.getAccessKey();
        this.webClient = WebClient.create(baseUri);
    }

    public Mono<ApiLayerResponse> getExchangeRate(ExchangeRate exchangeRate) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("access_key", accessKey)
                        .queryParam("currencies", exchangeRate.getCurrencies())
                        .queryParam("source", exchangeRate.getSource())
                        .queryParam("format", "1")
                        .build())
                .retrieve()
                .bodyToMono(ApiLayerResponse.class);
    }
}
