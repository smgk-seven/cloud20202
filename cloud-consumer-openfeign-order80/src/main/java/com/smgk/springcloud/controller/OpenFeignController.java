package com.smgk.springcloud.controller;

import com.smgk.springcloud.bean.CommonResult;
import com.smgk.springcloud.server.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OpenFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        return paymentFeignService.get(id);
    }

    @GetMapping(value = "/consumer/payment/outTime")
    public CommonResult getOutTime(){
        return paymentFeignService.getOutTime();
    }
}
