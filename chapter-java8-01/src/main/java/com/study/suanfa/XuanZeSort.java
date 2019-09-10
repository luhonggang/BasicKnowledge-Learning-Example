package com.study.suanfa;

/**
 * Java选择排序代码示例
 * <p>
 * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度
 * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 *
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/5/24 14:01
 */
@SuppressWarnings("all")
public class XuanZeSort {
    public static void main(String[] args) {
//        int[] a = new int[]{9, 3, 1, 5, 2, 6};
//        selectSort(a);
//        print(a);
        int bb = 200;
        Integer aa = new Integer(200);
        Integer cc = 200;
        System.out.println(aa.intValue() == bb);
        System.out.println(aa == bb);

    }

    /**
     * 选择排序算法实现
     * 循环一个数组,第一次循环,找出这个数组中的最小值,并记录它的值和它的下标,
     * 然后将这个值放在数组的第一个元素(也就是数组下标为0的)的位置上, 用替换来进行操作
     * <p>
     * 2.循环第二次的时候,从下标为 1的数组元素开始, 找出往后的最小值及其下标index
     * 然后将这个值放在数组第二个元素的位置上,同样也是替换操作来实现值 的替换
     * 3. 循环往复每一步, 最外层循环的次数控制由最外层的for循环来控制,即数组的长度来控制
     * 4. 内层循环比较暂时没法控制,未知
     * 5. 最终 组成由小到大的排序的有序数组
     *
     * 假定元素下标为0的位置上的元素值是数组中的最小值
     * 然后从第2个元素开始循环后面的所有元素,找到最小值和当前元素进行对比
     * 若 后继元素的值大于当前外层循环下的元素的值 我们就交换他们的位置,大的往后排,小的往前排
     * @param a 数组
     */
    private static void selectSort(int[] a) {
        int length = a.length;
//        Integer i = 10;10
        //循环次数
        for (int i = 0; i < length; i++) {
            // 记录每一次循环找到的数组元素最小值,默认我们认为循环的初始开始元素是最小值
            int key = a[i];
            // 记录每一次循环找到的元素的最小值的数组下标,默认同样认为循环的开始的数组的下标的是最小值的下标
            int position = i;
            // 选出最小的值和位置
            // 9, 3, 1, 5, 2, 6
            for (int j = i + 1; j < length; j++) {
                // 每次由当前循环的元素和它后面的元素进行循环比较大小
                // 只要数组中后续的元素的值比当前循环的数组中的元素的值要小就记录它的下标和数组元素值
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            // 交换当前位置上数组元素的值
            // 将当前循环的数组中的元素值赋值给它后面的元素上
            a[position] = a[i];
            // 默认我们认为当前循环的最小值赋值给当前循环的数组下标的元素上
            a[i] = key;
        }
    }

    /**
     * 理解后撸代码实现如下
     *
     * @param a 数组
     */
    private static void xunazeSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            // 默认认为当前元素是 最小的值
            int minVal = a[i];
            // 并记录它的下标值[同样默认认为当前循环的元素下标是最小值的下标]
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                // 每一次都由当前循环的数组元素值和当前元素值后面的元素进行比较
                // 然后记录下最小值及最小值对应的下标
                if (a[j] < minVal) {
                    minVal = a[j];
                    minIndex = j;
                }
            }
            System.out.println(i + " " + minVal);
            // 由上面筛选出每一次循环的最小值和最小值对应的下标
            // 下面开始进行交换数组值
            // 将最小值的下标位置上元素值替换为当前循环的元素值
            a[minIndex] = a[i];
            // 找到当次循环的中数组中最小值并将该值赋值给当次循环开始的数组下标位置上
            a[i] = minVal;
        }


    }

    private static void print(int[] a) {
        for (int val : a) {
            System.out.println("数组的元素 : " + val);
        }
    }
}
