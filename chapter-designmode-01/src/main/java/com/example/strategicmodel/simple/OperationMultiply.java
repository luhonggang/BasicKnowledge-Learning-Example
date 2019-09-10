package com.example.strategicmodel.simple;

/**
 * 乘法实现
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 10:58
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}
