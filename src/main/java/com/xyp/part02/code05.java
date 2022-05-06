package com.xyp.part02;

/**
 * 快速排序
 */
public class code05 {

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R); // 概率选择一个位置和最右侧数交换
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1); // p[0] - 1 小于区域的右边界
            quickSort(arr, p[1] + 1, R); // p[1] + 1 大于区域的左边界
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1; // 小于区右边界
        int more = R; // 大于区左边界
        while (L < R) { // 表示当前数的位置 arr[R] -> 划分值
            if (arr[L] < arr[R]) { // 当前值 < 划分值
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) { // 当前值 > 划分值
                swap(arr, --more, L);
            } else { // 当前值 = 划分值
                L++;
            }
        }
        swap(arr, more, R); // 划分值交换进入相等区
        return new int[]{less + 1, more}; // 返回相等区的左右边界
    }


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
