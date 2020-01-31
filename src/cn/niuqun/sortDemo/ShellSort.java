package cn.niuqun.sortDemo;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/9/29
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{34, 4343, -34, -4343565, 34, 0};
        shellSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] intArr) {
        for (int step = intArr.length / 2; step > 0; step /= 2) {
            for (int insertValueIndex = step; insertValueIndex < intArr.length; insertValueIndex += step) {
                int insertValue = intArr[insertValueIndex];
                int insertPointIndex;
                for (insertPointIndex = insertValueIndex - step;
                     insertPointIndex >= 0 && insertValue < intArr[insertPointIndex];
                     insertPointIndex -= step) {
                    intArr[insertPointIndex + step] = intArr[insertPointIndex];
                }
                intArr[insertPointIndex + step] = insertValue;
            }
        }
    }

    public static void shellSort1(int[] intArr) {
        for (int step = intArr.length / 2; step > 0; step /= 2) {
            for (int insertValueIndex = step; insertValueIndex < intArr.length; insertValueIndex += step) {
                for(int insertPointIndex = insertValueIndex - step; insertPointIndex >= 0; insertPointIndex -= step) {
                    if(intArr[insertPointIndex] > intArr[insertPointIndex + step]) {

                        int temp = intArr[insertPointIndex];
                        intArr[insertPointIndex] = intArr[insertPointIndex + step];
                        intArr[insertPointIndex + step] = temp;
                    }
                }
            }
        }
    }
}