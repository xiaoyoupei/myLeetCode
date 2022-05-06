package com.xyp.part01;

/**
 * 异或找出数组中两个奇数次的数
 */
public class code03 {

    public static void printOddTimeNum2(int[] arr) {
        int eor = 0;
        for (int value : arr) {
            eor ^= value;
        }

        int rightOne = eor & (~eor + 1); //取出最右边的1

        int onlyOne = 0; //eor'
        for (int value : arr) {
            if ((value & rightOne) == 0) {
                onlyOne ^= value;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne)); //找出两个数
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 3, 4};
        printOddTimeNum2(arr);
    }
}

