package com.smgk.springcloud.dao;

import com.smgk.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author smgk
 * @date 2020/3/8 12:45
 **/
@Mapper
public interface OrderDao {
    /**
     * 1 新建订单
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 2 修改订单状态,从0改为1
     * @param userId
     * @param id
     * @return
     */
    int update(@Param("userId") Long userId,@Param("id") Long id);
}