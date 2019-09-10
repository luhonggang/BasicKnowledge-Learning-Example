package com.example.web;

import com.example.strategicmodel.difficult.HandlerContext;
import com.example.strategicmodel.difficult.PaymentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuHongGang
 * @date 2018-05-23 11:12
 * @since 1.0
 **/
@RestController
@Slf4j
public class HelloWorldController {

    @Autowired
    HandlerContext handlerContext;

    @GetMapping("/test")
    public String getInstance(PaymentDto paymentDto) throws ClassNotFoundException {
        log.info("支付渠道选择入参 : {} ",paymentDto);
        return handlerContext.getInstance(paymentDto.getPayType()).payWay(paymentDto);
    }
}
