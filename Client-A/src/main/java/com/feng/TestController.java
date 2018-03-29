package com.feng;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "hiFallback")
    public String hello(@RequestParam String name){
        return restTemplate.getForObject("http://service-a/hello?name="+ name, String.class);
    }

    public String hiFallback(String name) {
        return "hello, " + name + ", error!";
    }

    @Value("${ip}")
    private String ip;
    @Value("${port}")
    private String port;

    @RequestMapping("/getProperties")
    public String getProperties(){
        return ip + " : " + port;
    }
}
