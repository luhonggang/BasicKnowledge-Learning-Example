package com.example.strategicmodel.difficult.service;

import com.example.annotation.HandlerType;
import com.example.strategicmodel.difficult.HandlerContext;
import com.example.strategicmodel.difficult.PaymentDto;
import com.example.utils.ClassScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 15:40
 */
@Component
public class PaymentProcessor /*extends DefaultListableBeanFactory */ implements BeanFactoryPostProcessor, BeanPostProcessor {

    private static final String CURRENT_PACKAGE_PATH = "com.example.strategicmodel.difficult.service.impl";

   /* @Override
    public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
        String[] beanNames = this.getBeanNamesForAnnotation(annotationType);
        Map<String, Object> results = new LinkedHashMap(beanNames.length);
        String[] var4 = beanNames;
        int var5 = beanNames.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String beanName = var4[var6];
            results.put(beanName, this.getBean(beanName));
        }

        return results;
    }*/

    public Map<String, PaymentBusiness> cacheMaps = new ConcurrentHashMap<>(3);

    private PaymentProcessor() {
    }

    public PaymentProcessor(Map<String, PaymentBusiness> cacheMaps) {
        this.cacheMaps = cacheMaps;
    }

    /**
     * 2个处理器是 spring 对bean 进行生命周期管理的扩展,整个bean 生命周期中均会执行该这2个处理器
     * spring bean 前置处理器
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.nonNull(bean) && bean instanceof PaymentBusiness) {
            String type = bean.getClass().getAnnotation(HandlerType.class).value();
            if (StringUtils.hasLength(type)) {
                cacheMaps.put(type, ((PaymentBusiness) bean));
            }
        }
        return bean;
    }

    /**
     * spring bean 后置处理器
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 只有当前实例是PaymentBusiness类型的实例的时候才做控制台输出
        if (Objects.nonNull(bean) && bean instanceof PaymentBusiness) {
            for (Map.Entry<String, PaymentBusiness> kvEntry : cacheMaps.entrySet()) {
                PaymentDto paymentDto = new PaymentDto();
                paymentDto.setPayType("1");
                System.out.println("key : " + kvEntry.getKey() + "value : " + kvEntry.getValue().payWay(paymentDto));
            }
        }
        return bean;
    }

    /**
     * 注册bean
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> handlerMaps = new ConcurrentHashMap<>(3);
        ClassScanner.scan(CURRENT_PACKAGE_PATH, HandlerType.class).forEach(clazz -> {
            String type = clazz.getAnnotation(HandlerType.class).value();
            handlerMaps.put(type, clazz);
        });
        HandlerContext context = new HandlerContext(handlerMaps);
        beanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }
}
