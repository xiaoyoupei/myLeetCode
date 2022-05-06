package com.xyp.part02;

/**
 * 返回数组最大值 - 递归
 */
public class code01 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1); //求中点，考虑R+L会溢出，所以采用R-L并且除2(这里采用右移一位比除2要快)
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);

    }
}
