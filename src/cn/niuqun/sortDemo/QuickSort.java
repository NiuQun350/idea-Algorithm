package cn.niuqun.sortDemo;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/9/29
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{32, 654, -13, 59, 998, -233};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] intArr, int Left, int Right) {
        int left = Left;
        int right = Right;
        int pivot = intArr[(left + right) / 2];
        while (left < right) {
            while(intArr[left] < pivot) {
                left++;
            }
            while(intArr[right] > pivot) {
                right--;
            }
            if(left >= right) {
                break;
            }
            int temp = intArr[left];
            intArr[left] = intArr[right];
            intArr[right] = temp;

            if(intArr[left] == pivot) {
                right--;
            }
            if(intArr[right] == pivot) {
                left++;
            }

            if(left == right) {
                left++;
                right--;
            }
            if(Left < right) {
                quickSort(intArr, Left, right);
            }
            if(left < Right) {
                quickSort(intArr, left, Right);
            }

        }
    }
}
