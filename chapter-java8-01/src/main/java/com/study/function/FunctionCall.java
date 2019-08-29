package com.study.function;

import com.study.param.ParamTest;
import com.study.result.ParamResult;

import java.util.function.Function;

/**
 * JAVA8 Function函数
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/8/28 17:32
 */
public class FunctionCall {

    private static  <T extends ParamTest,R extends ParamResult> ParamResult  testFunction(Integer val, Function<T,R> function){
        ParamTest test = ParamTest.builder()
                .gender("男")
                .name("xiaoming" + val)
                .build();
        ParamResult result = function.apply((T) test);
        System.out.println("输出的结果是");
       return result;
    }


    /**
     * 测试函数调用
     * @param paramTest
     * @return
     */
    private static ParamResult holdMethod(ParamTest paramTest){
        System.out.println("输出的结果是 : " + paramTest.toString());
        ParamResult result = new ParamResult();
        result.setCode("200");
        result.setMessage("123456");
        return result;
    }
    static void  test(int score,Function<Integer,Integer> function){
        System.out.println("计算的结果 : " + function.apply(score));
    }
    public static void main(String[] args) {
        int score = 2;
        test(score,val ->val*100);
        int val = 100;
        testFunction(val, x->{
            x.setName("小明" + val * 100);
            x.setGender("男");
            return holdMethod(x);
        });


    }
}
