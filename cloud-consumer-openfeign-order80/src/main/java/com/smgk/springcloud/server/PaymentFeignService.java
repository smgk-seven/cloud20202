package com.smgk.springcloud.server;

import com.smgk.springcloud.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//这里是接口目标的微服务名
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/outTime")
    public CommonResult getOutTime();
}
