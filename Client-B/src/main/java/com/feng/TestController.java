package com.feng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    ServiceAFeignClient serviceAFeignClient;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return serviceAFeignClient.hello(name);
    }
}
