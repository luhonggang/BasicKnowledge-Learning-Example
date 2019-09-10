package com.example.strategicmodel.simple;

/**
 * 辅助类 具体类的具体调用实现路由
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 11:01
 */
public class OperationContext {
    private Strategy strategy;

    public OperationContext(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 提供对外调用的公共方法
     * @param a 参数1
     * @param b 参数2
     * @return int 计算后的值
     */
    public int doOperation(int a,int b){
        return strategy.doOperation(a,b);
    }
}
