package com.dlwlrma.blueming.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @Author:hex1n
 * @Date:2020/1/14 21:26
 */
public class PreGatewayFilterFactory extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.Config> {
    public PreGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
//            return chain.filter(exchange.mutate().request(req));
            return null;
        });
    }

    public static class Config {

    }
}
