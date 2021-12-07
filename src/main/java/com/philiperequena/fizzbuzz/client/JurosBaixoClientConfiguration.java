package com.philiperequena.fizzbuzz.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

// TODO add RestControllerAdvice and ExceptionHandler
@Configuration
public class JurosBaixoClientConfiguration {

    @Value("${app.jurosbaixo.fizzbuzz.key}")
    private String clientHeaderKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-API-KEY", clientHeaderKey);
        };
    }
}
