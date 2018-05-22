package com.didispace.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK的动态代理实现:
 * 1. 需要实现InvocationHandler接口
 * 2. 使用Proxy.newProxyInstance产生代理对象
 * 3. 被代理的对象必须实现接口
 * @author LuHongGang
 * @date 2018-05-22 14:34
 * @since 1.0
 **/
public class JDKProxy implements InvocationHandler {

    // 需要被代理的目标对象
    private Object targetObject;


    /**
     * 构造代理对象
     * @param targetObject
     * @return
     */
    public Object newProxy(Object targetObject) {
        //将目标对象传入进行代理
        this.targetObject = targetObject;
        //返回代理对象
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);

    }

    /**
     * 具体代理的实现流程
     * @param proxy   代理对象
     * @param method  代理的方法
     * @param args    参数
     * @return        返回值
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //一般我们进行逻辑处理的函数比如这个地方是模拟检查权限
        checkPopedom();
        // 设置方法的返回值
        Object ret = null;
        //调用invoke方法，ret存储该方法的返回值
        ret  = method.invoke(targetObject, args);
        return ret;
    }

    /**
     * 模拟检查权限的例子
     */
    private void checkPopedom() {
        System.out.println(".:检查权限  checkPopedom()!");
    }
}
