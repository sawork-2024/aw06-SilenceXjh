package com.micropos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/products")
                        .filters(f -> f.circuitBreaker(config -> config.setName("products-error")))
                        .uri("http://localhost:2222"))
                .route(p -> p
                        .path("/products/{productId}")
                        .filters(f -> f.circuitBreaker(config -> config.setName("product-error")))
                        .uri("http://localhost:2222"))
                .route(p -> p
                        .path("/categories")
                        .filters(f -> f.circuitBreaker(config -> config.setName("product-error")))
                        .uri("http://localhost:2222"))
                .route(p -> p
                        .path("/settings")
                        .filters(f -> f.circuitBreaker(config -> config.setName("product-error")))
                        .uri("http://localhost:2222"))
                .route(p -> p
                        .path("/orders")
                        .filters(f -> f.circuitBreaker(config -> config.setName("orders-error")))
                        .uri("http://localhost:3333"))
                .route(p -> p
                        .path("/orders/{orderId}")
                        .filters(f -> f.circuitBreaker(config -> config.setName("order-error")))
                        .uri("http://localhost:3333"))
                .build();
    }
}
