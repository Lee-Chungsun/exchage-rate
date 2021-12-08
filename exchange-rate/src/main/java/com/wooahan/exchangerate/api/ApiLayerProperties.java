package com.wooahan.exchangerate.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@RequiredArgsConstructor
public class ApiLayerProperties {
    @Value("${apilayer.access.url}")
    private String baseUri;
    @Value("${apilayer.access.key}")
    private String accessKey;
}
