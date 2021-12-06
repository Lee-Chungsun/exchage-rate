package com.wooahan.exchangerate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ApiLayerProperties {
    //"http://www.apilayer.net/api/live"
    //"fbb5ddd31ba210abf2ab5862d6c7a939"
    private String baseUri;
    private String accessKey;

    public ApiLayerProperties(){
        baseUri = "http://www.apilayer.net/api/live";
        accessKey = "fbb5ddd31ba210abf2ab5862d6c7a939";
    }

    public ApiLayerProperties(String baseUri, String accessKey){
        baseUri = "http://www.apilayer.net/api/live";
        accessKey = "fbb5ddd31ba210abf2ab5862d6c7a939";
    }
}
