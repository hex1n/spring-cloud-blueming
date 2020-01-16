package com.dlwlrma.blueming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.cloud.netflix.turbine.stream.TurbineApplication;
import org.springframework.cloud.stream.converter.CompositeMessageConverterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.converter.ConfigurableCompositeMessageConverter;

/**
 * @Author:hex1n
 * @Date:2020/1/14 13:45
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
public class TurbineStreamRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineStreamRabbitmqApplication.class, args);
    }

    @Bean
    public ConfigurableCompositeMessageConverter integrationArgumentResolverMessageConverter(CompositeMessageConverterFactory factory) {
        return new ConfigurableCompositeMessageConverter(factory.getMessageConverterForAllRegistered().getConverters());
    }
}
