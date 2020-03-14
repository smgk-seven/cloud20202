package com.smgk.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 异常处理类
 */
@Component
public class PaymentHystrixServiceImp implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixServiceImp -->  paymentInfo_OK";
    }


    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentHystrixServiceImp --> paymentInfo_TimeOut";
    }
}
