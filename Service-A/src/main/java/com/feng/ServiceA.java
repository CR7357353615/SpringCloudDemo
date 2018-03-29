package com.feng;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceA {

    public static void main(String[] args) {
        SpringApplication.run(ServiceA.class, args);
    }

    @Value("${spring.application.name}")
    private String name;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello(@RequestParam String client){
        return "hello, " + client + ", My name:" + name + ", My port:" + port;
    }

}
