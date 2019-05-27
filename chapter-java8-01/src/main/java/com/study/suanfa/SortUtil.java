package com.study.suanfa;

/**
 * 排序相关工具类
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/5/27 9:44
 */
public class SortUtil {

    /**
     * 比较值的大小
     * @param a 当前数组元素
     * @param b 被比较的数组中的元素
     * @return  当前值 小于 被比较值 返回TRUE
     */
    public static boolean compareTo(Comparable a,Comparable b){
        return a.compareTo(b) < 0;
    }

    /**
     * 交换数组中的元素值
     * @param a 当前数组
     * @param i 当前循环的数组下标
     * @param j 当前需要被交换的数组中的下标
     */
    public static void exechange(Comparable[] a,int i,int j){
        // 保存当前值
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印数组最终的排序的结果
     * @param a
     */
    public static void output(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println("排序的结果 ：" + a[i]);
        }
    }


    /**
     * 打印数组最终的排序的结果
     * @param a
     */
    public static void outputAll(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println("排序的结果 ：" + a[i]);
        }
    }

}
