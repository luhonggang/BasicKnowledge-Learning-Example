package com.example.strategicmodel.simple;

/**
 * 简单实现
 * 策略模式 参考来源菜鸟教程 https://www.runoob.com/design-pattern/strategy-pattern.html
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 11:04
 */
public class OperationTest {
    public static void main(String[] args) {

        OperationContext context = new OperationContext(new OperationAddition());
        output("加法",context.doOperation(10,10));

        OperationContext contextSub = new OperationContext(new OperationSubstract());
        output("减法",contextSub.doOperation(10,10));

        OperationContext contextMul = new OperationContext(new OperationMultiply());
        output("乘法",contextMul.doOperation(10,10));

    }

    private static void output(String calculateType,int val){
        System.out.println(" 计算类型 : " + calculateType + " 计算值 : "  + val);
    }
}
