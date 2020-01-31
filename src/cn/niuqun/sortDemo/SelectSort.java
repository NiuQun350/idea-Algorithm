package cn.niuqun.sortDemo;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/9/29
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{34, 5454, 333, -434, 343};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] intArr) {
        for(int i = 0; i < intArr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < intArr.length; j++) {
                if(intArr[j] < intArr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = intArr[i];
                intArr[i] = intArr[minIndex];
                intArr[minIndex] = temp;
            }
        }
    }
}
