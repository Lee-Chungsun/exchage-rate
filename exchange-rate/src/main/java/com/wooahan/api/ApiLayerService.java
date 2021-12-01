package com.wooahan.api;

import com.wooahan.model.ApiLayerProperties;
import com.wooahan.model.ApiLayerResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ApiLayerService {
    private final WebClient webClient;
    private final String accessKey;

    public ApiLayerService(ApiLayerProperties apiLayerProperties) {
        String baseUri = apiLayerProperties.getBaseUri();
        this.accessKey = apiLayerProperties.getAccessKey();
        this.webClient = WebClient.create(baseUri);
    }

    public Mono<ApiLayerResponse> getExchangeRate() {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("access_key", accessKey)
                        .queryParam("currencies", "EUR")
                        .queryParam("source", "USD")
                        .queryParam("format", "1")
                        .build())
                .retrieve()
                .bodyToMono(ApiLayerResponse.class);
    }
}
