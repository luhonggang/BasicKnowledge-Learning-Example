package com.study.suanfa;

import java.util.Arrays;

/**
 * ###### 排序术语 ######
 * ------------------------------------------------------------------
 * 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面
 * 不稳定：如果a原本在b的前面，而a=b，排序之后a可能会出现在b的后面
 * 内排序：所有排序操作都在内存中完成
 * 外排序：由于数据太大，因此把数据放在磁盘中，而排序通过磁盘和内存的数据传输才能进行
 * 时间复杂度： 一个算法执行所耗费的时间
 * 空间复杂度：运行完一个程序所需内存的大小
 * ------------------------------------------------------------------
 * 冒泡排序 是一种简单的排序 是一种 内排序[占用常数内存，不占用额外内存]
 * 在冒泡排序之类的排序中，问题规模为n，又因为需要比较n次，所以平均时间复杂度为O(n²)
 * 时间复杂度 最坏的情况 T(n) = O(n2)
 * n 指数据规模
 * <p>
 * >>>优势: 适用于各种规模的数据，也不在乎数据的分布，都能进行排序。可以说，比较排序适用于一切需要排序的情况
 *
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/6 11:06
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] iArray = new int[]{8, 44, 112, 20, 50, 12};
        int[] sortArray = swapSort(iArray);
        systemOut(sortArray);
    }

    /**
     * 冒泡排序
     *
     * @param array 要排序的数组
     * @return 被升序排列后的数组
     */
    private static int[] swapSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        // 外层遍历每一个数组中的元素
        for (int i = 0; i < array.length; i++) {
            // 内层遍历 当前外层当前元素的后面的一系列元素
            for (int j = i + 1; j <= array.length - 1; j++) {
                // 若 每一个后续的元素都比它前面的值大 ,就交换位置 小的往后冒出来(小的元素位置往后移动一位)
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 输出数组元素值
     *
     * @param array 数组
     */
    private static void systemOut(int[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }
}
