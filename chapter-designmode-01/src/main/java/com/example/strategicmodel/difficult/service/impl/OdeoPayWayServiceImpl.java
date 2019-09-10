package com.example.strategicmodel.difficult.service.impl;

import com.example.annotation.HandlerType;
import com.example.strategicmodel.difficult.PaymentDto;
import com.example.strategicmodel.difficult.service.PaymentBusiness;
import org.springframework.stereotype.Service;


/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 14:57
 */
@Service
@HandlerType(value = "1",name = "ODEO")
public class OdeoPayWayServiceImpl implements PaymentBusiness {
    @Override
    public String payWay(PaymentDto paymentDto) {
        return "ODEO渠道";
    }
}
