package com.xyp.part03;

/**
 * 基数排序
 */
public class code04 {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    /**
     * 求最大值的位数
     *
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            max = Math.max(max, value);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     * @param arr
     * @param L
     * @param R
     * @param digit 最大值的位数
     */
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10; //0-9 数字
        int i = 0, j = 0;

        // 创建原始数组等长新数组
        int[] bucket = new int[R - L + 1];


        // 最大值有多少位就循环多少次
        for (int d = 1; d <= digit; d++) {

            // 创建长度为10的计数数组
            int[] count = new int[radix];

            // 计数法:count数组的每个元素表示该下标值的原始数的个数
            // eg:原始数组值 13 21 11 52 62，d=1
            // count数组值  0 2 2 1 0 0 0 0 0 0
            // count下标值  0 1 2 3 4 5 6 7 8 9
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }

            // 前缀和数组
            // eg:原始数组值 13 21 11 52 62，d=1
            // count数组值  0 2 4 5 5 5 5 5 5 5
            // count下标值  0 1 2 3 4 5 6 7 8 9
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            // 从右往左
            // eg:原始数组值 13 21 11 52 62，d=1
            // bucket数组值 21 11 52 62 13
            // bucket下标值 0  1  2  3  4
            // count数组值  0 0 2 4 5 5 5 5 5 5
            // count下标值  0 1 2 3 4 5 6 7 8 9
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            // 赋给原数组,改变其排序
            // eg:原始数组值 13 21 11 52 62，d=1
            // 新原数组值 21 11 52 62 13
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    /**
     * 取每个数的每位数字
     * @param x
     * @param d
     * @return
     */
    private static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

}
