package cn.niuqun.sortDemo3;

/**
 * @author NiuQun
 * @2019/10/7
 */

public class MergeSort {
    public static void main(String[] args) {

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid+1, right, temp);
            merge(arr, left, mid, right, temp);

        }
    }


    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
            while (i <= mid) {
                temp[t] = arr[i];
                t++;
                i++;
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
                t++;
                tempLeft++;
            }




        }

    }
}

