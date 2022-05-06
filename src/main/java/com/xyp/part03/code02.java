package com.xyp.part03;

import java.util.PriorityQueue;

public class code02 {

    public void sortedArrDistanceLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index <= Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }


    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

    }
}
