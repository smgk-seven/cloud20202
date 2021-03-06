package com.smgk.springcloud.controler;

import com.smgk.springcloud.bean.CommonResult;
import com.smgk.springcloud.bean.Payment;
import com.smgk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String post;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果********" + result);
        if (result > 0){
            return new CommonResult(200, "插入成功 -->post: " + post, result);
        }else {
            return new CommonResult(400, "插入失败 -->post: " + post, null);

        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("*****插入结果********" + result);
        if (result != null){
            return new CommonResult(200, "查找成功 -->post: " + post, result);
        }else {
            return new CommonResult(400, "查找失败 -->post: " + post, null);

        }
    }

    @GetMapping(value = "/payment/outTime")
    public CommonResult getOutTime(){
        String msg = "超时测试成功: " + post;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("出错了");
            msg = "超时失败 ： "+ post;
        }
        return new CommonResult(200, msg);
    }
}
