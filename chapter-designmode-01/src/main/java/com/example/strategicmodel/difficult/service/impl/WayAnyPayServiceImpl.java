package com.example.strategicmodel.difficult.service.impl;

import com.example.annotation.HandlerType;
import com.example.strategicmodel.difficult.PaymentDto;
import com.example.strategicmodel.difficult.service.PaymentBusiness;
import org.springframework.stereotype.Service;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 15:16
 */
@Service
@HandlerType(value = "2",name = "WAYANYPAY")
public class WayAnyPayServiceImpl implements PaymentBusiness {
    @Override
    public String payWay(PaymentDto paymentDto) {
        return "WAYANYPAY渠道";
    }
}
