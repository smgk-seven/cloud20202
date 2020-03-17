package com.smgk.springcloud.controller;

import com.smgk.springcloud.bean.CommonResult;
import com.smgk.springcloud.bean.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    //private static String URL = "http://localhost:8001";
    private static String URL = "http://CLOUD-PAYMENT-SERVICE";//cloud-payment-service

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        return restTemplate.getForObject(URL + "/payment/get/"+ id, CommonResult.class);
    }
    //@GetMapping("/payment/zipkin")
    @GetMapping("/consumer/payment/zipkin")
    public String testZipkin(){
        return restTemplate.getForObject(URL + "/payment/zipkin", String.class);
    }














}
