package com.smgk.springcloud.controller;

import com.smgk.springcloud.bean.CommonResult;
import com.smgk.springcloud.domain.Order;
import com.smgk.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author zzyy
 * @date 2020/3/8 14:21
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
