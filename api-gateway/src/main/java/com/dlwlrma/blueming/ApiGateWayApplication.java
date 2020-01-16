package com.dlwlrma.blueming;

import com.dlwlrma.blueming.filter.ElapsedFilter;
import com.dlwlrma.blueming.filter.ElapsedGatewayFilterFactory;
import com.dlwlrma.blueming.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @Author:hex1n
 * @Date:2020/1/14 13:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class, args);
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/fluent/customer/**").filters(f -> f.stripPrefix(2)
                .filter(new ElapsedFilter()).addRequestHeader("X-Response-Default-Foo", "Default-Bar"))
                .uri("lb://CONSUMER").order(0).id("fluent_custom_service")).build();
    }

    @Bean
    public ElapsedFilter elapsedFilter() {
        return new ElapsedFilter();
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public ElapsedGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new ElapsedGatewayFilterFactory();
    }
}
