package com.study.suanfa;

import static com.study.suanfa.SortUtil.output;

/**
 * 插入排序算法
 *
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/5/27 9:43
 */
public class ChaRuSort {
    public static void main(String[] args) {

        Comparable[] a = new Comparable[]{9, 4, 5, 8, 6, 1};


        mySelfComplete(a);

//        int[] b = new int[]{9,4,5,8,6,1};

//        chaRuSort(a);
//        output(a);
//        insertionSort(b);
//        output(b);

    }

    /**
     * 插入排序实现
     * @param array
     */
    private static void mySelfComplete(Comparable[] array) {
        int arrayLength = array.length;
        for (int i = 1; i < arrayLength; i++) {
            // 每次都是当前元素和 它前面的元素进行比较,大的元素往后面排[也就是当前循环下左侧大的元素值往后排,与当前元素交换下标位置]
            Comparable currentVal = array[i];
            for (int j = i; j > 0 && SortUtil.compareTo(currentVal,array[j-1]); j--) {
                  // 若前循环下左侧大的元素值比当前元素值大,就交换他们的位置
//                currentVal =
                array[j] = array[j-1];
                array[j-1] = currentVal;
            }
        }
        output(array);
    }

    /**
     * 如下代码 参考《数据结构与算法》 一书 编写
     * 正式的插入算法逻辑实现
     * 就是在左边有序元素组中找到当前元素插入的位置
     * 若左侧有序元素中存在比插入的元素值大的元素,就先将该位置上的元素值[有序元素中大于当前要插入的元素的元素值]
     * 往右侧元素移动一位,即将该大元素值放到当前循环下标的小元素位置上,直到当前循环的元素值的元素和左侧有序元素
     * 都比较了,最后将当前循环下标位置上的元素赋值给到它正确的有序下标位置上
     *
     * @param a 数组
     */
    private static void chaRuSort(Comparable[] a) {
        int length = a.length;
        int j;
        for (int i = 1; i < length; i++) {
            // 必须记录当前下标对应的数组中元素的值,因数组在程序执行的过程中下标上元素的值是在动态变化的,
            // 比如：原始数组中下标为2的位置上的值是 10 及a[2] = 10 ,经过程序执行后，进行一次循环后 a[2] = 11
            // 这里要声明局部变量tmp 来存储的原因 就是因为数组在遍历过程中因exechange() 方法改变了数组中下标位置上
            // 元素值, 所以每一次循环就需强制记录下 当前循环下标位置上的元素值
            Comparable tmp = a[i];
            for (j = i; j > 0 && SortUtil.compareTo(tmp, a[j - 1]); j--) {
                /* 交换他们的位置*/
                System.out.println("a[i] " + a[i]);
                System.out.println("输出的j的值是 ：" + j);
                SortUtil.exechange(a, j, j - 1);
                System.out.println("交换位置后输出的j的值是 ：" + j);
            }
        }


    }

    /**
     * 网络上的实现方式之一
     *
     * @param arr 数组
     * @param <T> 泛型类型
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        int p;
        for (int i = 1; i < arr.length; i++) {
            // 储存当前访问的节点值
            T tmp = arr[i];
            for (p = i; p > 0 && SortUtil.compareTo(tmp, arr[p - 1]); p--) {
                // 如果tmp小于arr[p - 1]的值，则后移一位
                arr[p] = arr[p - 1];
            }
            // 将tmp替换p位置的值（上面的for已经将原来的p后移了）
            arr[p] = tmp;
        }
    }

    /**
     * 网络实现方式 之二
     * 说明 ： array_i 标识的是当前循环下标位置上的元素值
     * array[index] = array[index - 1]; 就是将当前循环下标位置上的值 用它的前一个元素值来覆盖
     * index -= 1; 目的是循环往复的递减下标值,直到找出当前循环下标位置上的元素值的正确插入的下标值即停止递减
     * array[index] = array_i; 找到当前循环下标上的元素值 该插入数组中的正确下标位置
     *
     * @param array 数组
     */
    public static void insertionSort(int[] array) {
        int len = array.length;
        // 9,4,5,8,6,1
        for (int i = 0; i < len; i++) {
            int index = i, array_i = array[i];

            while (index > 0 && array[index - 1] > array_i) {
                array[index] = array[index - 1];
                index -= 1;
            }
            array[index] = array_i;

            /* print sort process */
            System.out.println("第 " + (i + 1) + " 次排序 ：");
            for (int item : array) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

}
