package com.dlwlrma.blueming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author:hex1n
 * @Date:2020/1/15 14:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProducerApplication.class, args);
    }
}
