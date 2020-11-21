package com.smgk.springcloud.controller;

import com.smgk.springcloud.bean.CommonResult;
import com.smgk.springcloud.domain.Order;
import com.smgk.springcloud.service.IdGeneratorSnowflake;
import com.smgk.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;

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

    /**
     * 生成id,通过雪花算法
     *
     * @return
     */
    @GetMapping("/snowflake")
    public String getIDBySnowflake() {
        //利用线程词去生成id
        try {
            long seartTime = System.nanoTime();
            ExecutorService threadPool = Executors.newFixedThreadPool(5);
            log.info("-------利用线程词去生成UUID--------");
            for (int i = 0; i < 500; i++) {
                threadPool.submit(() -> {
                    System.out.println(idGeneratorSnowflake.snowflakeId());
                });
            }
            threadPool.shutdown();
            long endTime = System.nanoTime();
            log.info("-------生成UUID  end--------" + (endTime - seartTime));
        }catch (Exception e){
            log.error("生成失败" + e.getMessage());
        }
        return "hello snowflake";
    }
}
