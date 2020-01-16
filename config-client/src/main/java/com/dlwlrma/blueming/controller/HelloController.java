package com.dlwlrma.blueming.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author:hex1n
 * @Date:2020/1/16 11:07
 */
@RestController
/**
 *@RefreshScope 必须加，否则客户端会受到服务端的更新消息，但是更新不了，因为不知道更新哪里的。
 */
@RefreshScope
public class HelloController {

    @Value("${hexin.hello:}")
    private String profile;

    @GetMapping("/info")
    public Mono<String> hello() {
        return Mono.justOrEmpty(profile);
    }

}
