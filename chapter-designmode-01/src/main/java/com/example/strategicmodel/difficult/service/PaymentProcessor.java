package com.example.strategicmodel.difficult.service;

import com.example.annotation.HandlerType;
import com.example.strategicmodel.difficult.HandlerContext;
import com.example.utils.ClassScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 15:40
 */
@Component
public class PaymentProcessor /*extends DefaultListableBeanFactory */implements BeanFactoryPostProcessor {

    private static final String CURRENT_PACKAGE_PATH="com.example.strategicmodel.difficult.service.impl";

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

    /**
     * 注册bean
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String,Class> handlerMaps = new ConcurrentHashMap<>(3);
        ClassScanner.scan(CURRENT_PACKAGE_PATH, HandlerType.class).forEach(clazz->{
            String type = clazz.getAnnotation(HandlerType.class).value();
            handlerMaps.put(type,clazz);
        });
        HandlerContext context = new HandlerContext(handlerMaps);
        beanFactory.registerSingleton(HandlerContext.class.getName(),context);
    }
}
