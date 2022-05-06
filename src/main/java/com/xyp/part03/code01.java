package com.xyp.part03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class code01 {


    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) { // O(N)
            heapInsert(arr, i); // O(logN)
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) { // O(N)
            heapify(arr, 0, heapSize);// O(logN)
            swap(arr, 0, --heapSize);// O(1)
        }
    }


    /**
     * 调换父结点和当前节点的位置
     *
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    /**
     * 堆化：调整树为大根堆结构
     *
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; //获取左孩子的下标

        //有孩子节点的时候
        while (left < heapSize) {
            //左右孩子值比较，获取值大的节点位置
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            //父节点和较大孩子值比较，获取值大的节点位置
            largest = arr[largest] > arr[index] ? largest : index;

            //如果还是本身，则终止
            if (largest == index) {
                break;
            }

            //不是本身，是孩子的值更大，交换位置
            swap(arr, largest, index);

            //孩子作为父结点再去比较
            index = largest;
            left = index * 2 + 1;

        }
    }

    /**
     * 交换两个数
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 4, 6, 7, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
