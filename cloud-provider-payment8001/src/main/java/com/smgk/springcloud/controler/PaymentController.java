package com.smgk.springcloud.controler;

import com.smgk.springcloud.bean.CommonResult;
import com.smgk.springcloud.bean.Payment;
import com.smgk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果********" + result);
        if (result > 0){
            return new CommonResult(200, "插入成功", result);
        }else {
            return new CommonResult(400, "插入失败", null);

        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("*****插入结果********" + result);
        if (result != null){
            return new CommonResult(200, "查找成功", result);
        }else {
            return new CommonResult(400, "查找失败", null);

        }
    }
}
