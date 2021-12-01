package com.wooahan.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ApiLayerProperties {
    //"http://www.apilayer.net/api/live?access_key=%s"
    //"fbb5ddd31ba210abf2ab5862d6c7a939"
    private final String baseUri;
    private final String accessKey;
}
