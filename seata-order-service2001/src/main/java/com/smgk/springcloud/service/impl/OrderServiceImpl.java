package com.smgk.springcloud.service.impl;
import com.smgk.springcloud.dao.OrderDao;
import com.smgk.springcloud.domain.Order;
import com.smgk.springcloud.service.AccountService;
import com.smgk.springcloud.service.OrderService;
import com.smgk.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 账户
 *
 * @author zzyy
 * @date 2020/3/8 13:57
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说:
     * 下订单->减库存->减余额->改状态
     * GlobalTransactional seata开启分布式事务,异常时回滚,name保证唯一即可
     *
     * @param order 订单对象
     */
    @Override
    @GlobalTransactional//加入全局事务，如果有了异常全部三个应用的库都回滚
    public void create(Order order) {
        // 1 新建订单   创建一个Order 记录
        log.info("----->开始新建订单");
        orderDao.create(order);

        // 2 扣减库存 更新操作
        log.info("----->订单微服务开始调用库存,做扣减Count");
        storageService.decrease(order.getProductId(), order.getCountNum());
        log.info("----->订单微服务开始调用库存,做扣减End");

        // 3 扣减账户  更新操作
        log.info("----->订单微服务开始调用账户,做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户,做扣减End");

        // 4 修改订单状态,从0到1,1代表已完成  更新操作
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(), order.getId());

        log.info("----->下订单结束了,O(∩_∩)O哈哈~");
    }
}


