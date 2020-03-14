package com.smgk.springcloud.controller;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.smgk.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalMethod")
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    //@HystrixCommand//记得，要想使用全局默认的异常处理方法必须要加此注解
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }


   @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   @HystrixCommand
   public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int age = 10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }


    /*public String paymentGlobalMethod(){
        return "操作超时请稍后再试";
    }*/


    
}
