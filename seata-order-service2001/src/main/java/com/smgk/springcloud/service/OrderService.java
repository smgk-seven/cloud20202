package com.smgk.springcloud.service;

import com.smgk.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

    //int update(Long userId, Long id);
}