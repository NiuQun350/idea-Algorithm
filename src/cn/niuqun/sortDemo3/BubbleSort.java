package cn.niuqun.sortDemo3;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/10/5
 */

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{343, 0, -89, -243, 899};
        long d1 = System.currentTimeMillis();
        bubbleSort(arr);
        long d2 = System.currentTimeMillis();
        System.out.println("排序时间为：" + (d2- d1));
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (flag = false) {
                break;
            }
        }

    }
}
