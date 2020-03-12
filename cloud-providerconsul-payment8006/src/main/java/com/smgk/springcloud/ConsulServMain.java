package com.smgk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulServMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsulServMain.class, args);
    }
}
