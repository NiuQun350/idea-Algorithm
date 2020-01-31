package cn.niuqun.sortDemo;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/9/29
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{232, 434, 4, -34, 44, 343};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] intArr) {
        for(int i = 1; i < intArr.length; i++) {
            boolean flag = false;
            for(int j = 0; j < intArr.length - i; j++) {
                if(intArr[j] > intArr[j+1]) {
                    flag = true;
                    int temp = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = temp;
                }
            }
            if(flag = false) {
                break;
            }
        }
    }
}
