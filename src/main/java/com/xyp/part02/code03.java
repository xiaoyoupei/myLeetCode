package com.xyp.part02;

public class code03 {

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, 1, mid)
                + process(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int L, int m, int r) {
        int[] temp = new int[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        int res = 0;
        //归并的时候排序插入，计算小和
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        ////剩下未插入的数
        while (p1 <= m) {
            temp[i++] = arr[p1++];
        }

        while (p2 <= r) {
            temp[i++] = arr[p2++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }

        return res;

    }
}
