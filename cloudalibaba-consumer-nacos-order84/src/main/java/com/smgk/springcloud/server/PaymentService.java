package com.smgk.springcloud.server;

import com.smgk.springcloud.bean.CommonResult;
import com.smgk.springcloud.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author smgk  注意如果要支客户端进入熔断和之前的一样，在注解FeignClien注意参数fallback
 * @version 1.0
 * @date 2020/03/07
 */

@FeignClient(value = "nacos-payment-provider")
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}