package com.atguigu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //因为负载均衡要加这个注解，否则根据地址找到了，不知道调用哪个服务会报错
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
