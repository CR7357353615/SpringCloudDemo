package com.feng;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "service-a", fallback = ServiceAFeignClientFallback.class) //这里的value对应服务的spring.applicatoin.name
public interface ServiceAFeignClient {

    @RequestMapping(value = "/hello")
    String hello(@RequestParam("name") String name);

}
