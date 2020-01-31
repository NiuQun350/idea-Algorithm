package cn.niuqun.sortDemo3;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/10/5
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{32, 45, -43, 9989, -11323};
        insertSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序移动法
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int insertValueIndex = 1; insertValueIndex < arr.length; insertValueIndex++) {
            int insertValue = arr[insertValueIndex];
            int insertPointIndex;
            for (insertPointIndex = insertValueIndex - 1;
                 insertPointIndex >= 0 && insertValue < arr[insertPointIndex];
                 insertPointIndex--) {
                arr[insertPointIndex + 1] = arr[insertPointIndex];
            }
            arr[insertPointIndex + 1] = insertValue;
        }
    }

    public static void insertSort1(int[] arr) {
        for (int insertValueIndex = 1; insertValueIndex < arr.length; insertValueIndex++) {
            for (int insertPointValue = insertValueIndex - 1; insertPointValue >= 0; insertPointValue--) {
                if (arr[insertPointValue] > arr[insertPointValue+1]) {
                    int temp = arr[insertPointValue];
                    arr[insertPointValue] = arr[insertPointValue+1];
                    arr[insertPointValue+1] =temp;
                }
            }
        }
    }
}