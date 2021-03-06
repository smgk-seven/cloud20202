package com.smgk.springcloud.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * 订单实体类
 * @author smgk
 * @date 2020/3/8 12:28
 **/
@Data //get,set
@AllArgsConstructor //全参数
@NoArgsConstructor //无参构造器
public class Order {
    private Long id;

    private Long userId;

    private Long productId;

    private Integer countNum;

    private BigDecimal money;

    /**
     * 订单状态 0:创建中,1:已完结
     */
    private Integer status;
}
