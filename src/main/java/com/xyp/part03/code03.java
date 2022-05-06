package com.xyp.part03;

import java.util.Comparator;
import java.util.PriorityQueue;

public class code03 {

    public static class AComp implements Comparator<Integer> {
        /**
         * 返回正数：第一个参数放在堆上面
         * 返回负数：第二个参数放在堆上面
         * 返回0：任一个参数放在堆上面
         * @param arg1
         * @param arg2
         * @return
         */
        @Override
        public int compare(Integer arg1,Integer arg2) {
            return arg1-arg2;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new AComp());

    }



}
