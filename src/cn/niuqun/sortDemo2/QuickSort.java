package cn.niuqun.sortDemo2;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/9/30
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{13, 4343, -32, 909, 0};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quickSort(int[] arr, int Left, int Right) {
        int left = Left;
        int right = Right;
        int pivot = arr[(Left + Right) / 2];
        while (left < right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if(left >= right) {
                break;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            if(arr[left] == pivot) {
                right--;
            }
            if(arr[right] == pivot) {
                left++;
            }
        }
        if(left == right) {
            left++;
            right--;
        }
        if(Left < right) {
            quickSort(arr, Left, right);
        }
        if(left < Right) {
            quickSort(arr, left, Right);
        }
    }
}
