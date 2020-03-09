package com.smgk.springcloud.service;

import com.smgk.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
