package cn.niuqun.sort;

import java.util.Arrays;

/**
 * k表示桶的个数
 * 基数排序平均时间复杂度：O(n*K)
 * 最好情况：O(n*K)
 * 最坏情况：O(n*K)
 * 空间复杂度:O(n+K)
 * Out-place
 * 稳定
 * 基数排序的数组中不能有负数
 * 基数排序是对传统桶排序的扩展，速度很快
 * 基数排序是典型的空间换时间的方式，占用内存很大，当对海量的数据排序时，容易造成OutOfMemoryError
 * 基数排序是稳定的
 * @author NiuQun
 * @2019/10/2
 */

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{324, 46, 545, 890, 342};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("********************");

        int[] tempArr = new int[80000];
        for(int i = 0; i < tempArr.length; i++) {
            // 生成80000个[0-80000)的数
            tempArr[i] = (int)(Math.random() * 80000);
        }
        // System.out.println(Arrays.toString(tempArr));

        long d1 = System.currentTimeMillis();
        radixSort(tempArr);
        long d2 = System.currentTimeMillis();
        System.out.println("排序时间为：" + (d2 - d1));

    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            for (int k = 0; k < 10; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int t = 0; t < bucketElementCounts[k]; t++) {
                        arr[index] = bucket[k][t];
                        index++;
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }

    }
}