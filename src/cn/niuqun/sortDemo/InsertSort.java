package cn.niuqun.sortDemo;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/9/29
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{67, 56, 366, -1, 34};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 插入排序移动法
    public static void insertSort(int[] intArr) {
        for(int insertValueIndex = 1; insertValueIndex < intArr.length; insertValueIndex++) {

            int insertValue = intArr[insertValueIndex];
            int insertPointIndex;

            for(insertPointIndex = insertValueIndex-1;
                insertPointIndex >= 0 && insertValue < intArr[insertPointIndex];
                insertPointIndex--) {
                intArr[insertPointIndex+1] = intArr[insertPointIndex];
            }
            intArr[insertPointIndex+1] = insertValue;
        }
    }
}
