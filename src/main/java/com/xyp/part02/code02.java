package com.xyp.part02;

/**
 * 归并排序
 */
public class code02 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        process(arr,0,arr.length-1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        //正常排序
        while (p1 <= M && p2 <= R) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //剩下未插入的数
        while (p1 <= M) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }
}