package com.feng;

import org.springframework.stereotype.Component;


@Component
public class ServiceAFeignClientFallback implements ServiceAFeignClient {

    @Override
    public String hello(String name) {
        return "hello, " + name + ", error!";
    }

}
