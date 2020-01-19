package com.dlwlrma.blueming;

import com.dlwlrma.blueming.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @Author:hex1n
 * @Date:2020/1/14 13:45
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ApiGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayZuulApplication.class, args);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

}
