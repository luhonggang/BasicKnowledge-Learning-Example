package com.example.strategicmodel.difficult.service;

import com.example.strategicmodel.difficult.PaymentDto;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 14:51
 */
public interface PaymentBusiness {
    /**
     * 支付渠道实例获取
     * @param paymentDto 支付入参
     * @return String
     */
    String payWay(PaymentDto paymentDto);
}
