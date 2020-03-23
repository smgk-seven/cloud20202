package com.smgk.springcloud.controller;

import com.smgk.springcloud.bean.CommonResult;
import com.smgk.springcloud.bean.Payment;
import com.smgk.springcloud.server.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/consumer/fallback/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

    @GetMapping("/testSaveConfInfo")
    public CommonResult testSaveConfInfo(){
        CommonResult<Payment> returnStr = paymentSQL(new Long(1));
        return returnStr;
    }
}
