package cn.niuqun.title;
/*
题目内容：
 使用合并排序算法，对输入的n个数据进行按升序排序。
输入描述
分两行，第一行是整数n,第二行是n个整数，每个整数之间用空格间隔。

输出描述
按升序排序的n个整数

输入样例
8
9 8 7 6 5 4 3 2

输出样例
2 3 4 5 6 7 8 9
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author NiuQun
 * @2019/10/7
 */

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取数组大小
        int arrSize = scanner.nextInt();

        int[] arr = new int[arrSize];
        // 读取数组元素
        for (int i = 0; i < arrSize; i++) {
            arr[i] =scanner.nextInt();
        }
        int[] tempArr = new int[arrSize];

        mergeSort(arr, 0, arr.length-1, tempArr);
        for (int i = 0; i < arrSize; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

    public static void mergeSort(int[] arr, int left, int right, int[] tempArr) {

        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归
            mergeSort(arr, left, mid, tempArr);
            // 向右递归
            mergeSort(arr, mid + 1, right, tempArr);
            // 治理以及合并
            merge(arr, left, mid, right, tempArr);
        }
    }


    /**
     * 治理以及合并
     * @param arr           需要排序的数组
     * @param arrLeftIndex  数组arr传入部分左索引
     * @param arrMidIndex   数组arr传入部分中索引
     * @param arrRightIndex 数组arr传入部分右索引
     * @param tempArr       用于排序的临时数组
     */
    public static void merge(int[] arr, int arrLeftIndex, int arrMidIndex, int arrRightIndex, int[] tempArr) {
        // i为数组arr传入部分左半部分索引
        int i = arrLeftIndex;
        // j为数组arr传入部分右半部分索引
        int j = arrMidIndex + 1;
        // t 为临时数组tempArr的索引，初始化为0
        int t = 0;

        while (i <= arrMidIndex && j <= arrRightIndex) {
            if (arr[i] <= arr[j]) {
                tempArr[t] = arr[i];
                i++;
                t++;
            } else {
                tempArr[t] = arr[j];
                j++;
                t++;
            }
        }
            // 数组arr左半部分有剩余
            while (i <= arrMidIndex) {
                tempArr[t] = arr[i];
                i++;
                t++;
            }
            // 数组arr右半部分有剩余
            while (j <= arrRightIndex) {
                tempArr[t] = arr[j];
                j++;
                t++;
            }

            // 将数组tempArr中的元素拷贝到原数组arr的对应位置
            t = 0;
            // tempLeft 为数组arr传入部分索引，它被初始化为数组arr传入部分左索引
            int tempLeft = arrLeftIndex;
            while (tempLeft <= arrRightIndex) {
                arr[tempLeft] = tempArr[t];
                tempLeft++;
                t++;
            }
    }
}
