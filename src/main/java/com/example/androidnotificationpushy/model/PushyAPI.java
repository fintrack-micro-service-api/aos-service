package com.example.androidnotificationpushy.model;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@AllArgsConstructor
public class PushyAPI {

    private static final String SECRET_API_KEY = "de6e6c06f044305fa9c7fb7c645031f21d72bc980ebf50a7f1060b0837ec1d84";

    private static final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.pushy.me")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", "https://api.pushy.me"))
            .build();

    public static void sendPush(PushyPush req) {
        webClient.post()
                .uri("/push?api_key=" + SECRET_API_KEY)
                .bodyValue(req)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}