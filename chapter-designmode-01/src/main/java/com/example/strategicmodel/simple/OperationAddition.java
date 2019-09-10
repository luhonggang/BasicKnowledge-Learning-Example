package com.example.strategicmodel.simple;

/**
 * 加法实现
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 10:59
 */
public class OperationAddition implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}
