package com.dlwlrma.blueming.hystrix;

import com.dlwlrma.blueming.service.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hex1n
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {

    
    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "Hello World!";
    }

}