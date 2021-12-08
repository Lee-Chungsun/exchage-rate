package com.wooahan.exchangerate.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wooahan.exchangerate.domain.ExchangeRate;
import com.wooahan.exchangerate.dto.ApiLayerResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

import static com.wooahan.exchangerate.api.ApiLayerResponseFixture.createApiLayerResponse;

@ExtendWith(MockitoExtension.class)
public class ApiLayerServiceTest {
    private static final String BASE_URI = "http://localhost:%s";
    private static final String ACCESS_KEY = "fbb5ddd31ba210abf2ab5862d6c7a939";
    private static ObjectMapper objectMapper;
    private static MockWebServer mockWebServer;
    private static ApiLayerService apiLayerService;

    @BeforeAll
    static void setUp() throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void shutdown() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format(BASE_URI, mockWebServer.getPort());
        ApiLayerProperties apiLayerProperties = new ApiLayerProperties(baseUrl, ACCESS_KEY);
        apiLayerService = new ApiLayerService(apiLayerProperties);
    }

    @DisplayName("API LAYER 서버에서 환율정보 수신 테스트")
    @Test
    public void getExchangeRate() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(createApiLayerResponse()))
                .addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE));

        Mono<ApiLayerResponse> expectedResponse = apiLayerService.getExchangeRate(new ExchangeRate("KRW", "USD"));

        StepVerifier.create(expectedResponse)
                .expectNextMatches(ApiLayerResponse::isSuccess)
                .verifyComplete();
    }
}
