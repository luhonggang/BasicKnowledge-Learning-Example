package com.example.strategicmodel.simple;

/**
 * 定义功能的接口
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 10:56
 */
public interface Strategy {
    /**
     * 公共方法 实现计算
     * @param a 参数1
     * @param b 参数2
     * @return int
     */
    public int doOperation(int a,int b);
}
