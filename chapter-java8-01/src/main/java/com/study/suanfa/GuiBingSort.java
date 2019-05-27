package com.study.suanfa;

/**
 * 归并排序算法
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/5/27 14:33
 */
public class GuiBingSort {
    public static void main(String[] args) {
        int[] a = {1,2,0,8,6,9};
        int[] b = new int[a.length];
        mergeSort(a,0,a.length-1,b);
        SortUtil.outputAll(b);

    }

    /**
     * 相邻两个有序子序列的合并算法
     * @param srcArray
     * @param low
     * @param high
     * @param desArray
     */
    public static void mergeSort(int[] srcArray, int low, int high, int[] desArray) {
        int mid;
        int i, j, k;
        mid = (low + high) / 2;
        i = low;
        k = 0;
        j = mid + 1;
        // compare two list
        while (i <= mid && j <= high) {
            if (srcArray[i] <= srcArray[j]) {
                desArray[k] = srcArray[i];
                i = i + 1;
            } else {
                desArray[k] = srcArray[j];
                j = j + 1;
            }
            k = k + 1;
        }
        // if 1 have,cat
        while (i <= mid) {
            desArray[k] = srcArray[i];
            k = k + 1;
            i = i + 1;
        }
        while (j <= high) {
            desArray[k] = srcArray[j];
            k = k + 1;
            j = j + 1;
        }
        for (i = 0; i < k; i++) {
            srcArray[low + i] = desArray[i];
        }
    }

}
