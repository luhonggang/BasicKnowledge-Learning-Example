package com.example.strategicmodel.difficult;

import com.example.strategicmodel.difficult.service.PaymentBusiness;
import com.example.utils.BeanTool;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * 策略模式
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 10:48
 */
public class HandlerContext {
    private Map<String, Class> handlerMaps;

    public HandlerContext(Map<String, Class> handlerMaps) {
        this.handlerMaps = handlerMaps;
    }

    /**
     * 获取bean
     * @param type
     * @return
     * @throws ClassNotFoundException
     */
    public PaymentBusiness getInstance(String type) throws ClassNotFoundException {
        Class clazz = handlerMaps.get(type);
        if(Objects.isNull(clazz)){
            throw new ClassNotFoundException("not found this class,and class name : " + clazz);
        }
        return (PaymentBusiness)BeanTool.getBean(clazz);
    }

}
