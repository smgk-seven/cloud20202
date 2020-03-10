package com.smgk.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicatonConfig {

    @Bean
    @LoadBalanced //实现通过服务名访问Eureka
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
