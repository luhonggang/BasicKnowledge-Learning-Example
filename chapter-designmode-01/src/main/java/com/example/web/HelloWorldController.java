package com.example.web;

import com.example.strategicmodel.difficult.HandlerContext;
import com.example.strategicmodel.difficult.PaymentDto;
import com.example.strategicmodel.difficult.service.PaymentProcessor;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
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

    @Reference
    HandlerContext handlerContext;

    @Reference
    PaymentProcessor processor;

    /**
     * 使用策略模式 2 种注入bean的方式
     *
     * @param paymentDto 入参
     * @return String
     * @throws ClassNotFoundException
     */
    @GetMapping("/test")
    public String getInstance(PaymentDto paymentDto) throws ClassNotFoundException {
        log.info("支付渠道选择入参 : {} ",paymentDto);
        return handlerContext.getInstance(paymentDto.getPayType()).payWay(paymentDto);
//        return processor.cacheMaps.get(paymentDto.getPayType()).payWay(paymentDto);
    }
}
