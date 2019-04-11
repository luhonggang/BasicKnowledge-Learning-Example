package com.study.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8 Stream 使用
 * 参考网址 : https://github.com/hollischuang/toBeTopJavaer/blob/master/basics/java-basic/stream.md
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/4/11 11:23
 */
public class StreamCode {

    public static void main(String[] args) {

        /* 1. filter 使用*/
        List<String> stringList = Arrays.asList("hello","","world","go","out","it`good");
        // 过滤掉空字符串后结果
        stringList.stream().filter(s -> !s.isEmpty()).forEach(System.out::println);

        System.out.println("---------------------------------------------------------------");
        /* 2. map 映射每一个元素到对应的结果 sorted方法 对元素进行排序 */
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8);
        // 将大于5的数字 乘以它们自己(获取大于5以上的数字的 平方数)并有序返回
        integerList.stream().filter(n -> n > 5).mapToInt(m -> m *m).sorted().forEach(System.out::println);

        System.out.println("---------------------------------------------------------------");
        /* 3. limit/skip limit 返回Stream中前n个元素; skip 则扔掉前n个元素*/
        List<Integer> integerList02 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // 返回 1 2 3 4 并扔掉元素 1
        integerList02.stream().limit(4).skip(1).forEach(System.out::println);

        System.out.println("---------------------------------------------------------------");
        /* 4. distinct 主要用于对元素进行去重 主要是去掉重复元素的多余元素*/
        Stream<Integer> distinctList = Stream.of(1,1,22,22,2,3,4,5,5);
        // 去掉多余的元素1,22,5 然后返回 1 2 3 4 5 22
        distinctList.distinct().sorted().forEach(System.out::println);

        System.out.println("---------------------------------------------------------------");

        /* 5. collect 将流中的元素累积成一个汇总结果*/
        // 将以hello 开始的字符串 统计为一个集合并返回
        Stream<String> regexList = Stream.of("hello","1","3","4","5","world");
        regexList.filter( s -> s.startsWith("hello")).collect(Collectors.toList())
        .forEach(System.out::println);


    }

    public boolean regexExpression(String str){

        return str.matches("[\\d]");
    }
}
