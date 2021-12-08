package com.wooahan.exchangerate.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class ApiLayerProperties {
    @Value("${apilayer.access.url}")
    private String baseUri;
    @Value("${apilayer.access.key}")
    private String accessKey;

    public ApiLayerProperties(String baseUri, String accessKey){
        this.baseUri = baseUri;
        this.accessKey = accessKey;
    }
}
