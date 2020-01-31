package cn.niuqun.sort;

import java.util.Arrays;

/**
 * 归并排序采用了分治法的思想,   划分 ==> 治理 ==> 合并
 * @author NiuQun
 * @2019/9/29
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{43, 890, -133, 9, 3040, -32324};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 划分的过程
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid+1, right, temp);
            // 治理并合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并排序平均时间复杂度：O(nlogn)
     * 最好情况：O(nlogn)
     * 最坏情况：O(nlogn)
     * 空间复杂度:O(logn)
     * Out-place
     *
     * 稳定
     *
     * 治理及合并的过程
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid+1;
        int t = 0;

        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}


