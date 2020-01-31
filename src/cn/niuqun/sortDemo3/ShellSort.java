package cn.niuqun.sortDemo3;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/10/5
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{324, -343, 4545, -228, 0, -32};
        shellSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int insertValueIndex = step; insertValueIndex < arr.length; insertValueIndex += step) {
                int insertValue = arr[insertValueIndex];
                int insertPointValue;
                for (insertPointValue = insertValueIndex - step;
                     insertPointValue >= 0 && insertValue < arr[insertPointValue];
                     insertPointValue -= step) {
                    arr[insertPointValue + step] = arr[insertPointValue];
                }
                arr[insertPointValue + step] = insertValue;
            }
        }
    }

    public static void shellSort1(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int insertValueIndex = step; insertValueIndex < arr.length; insertValueIndex += step) {
                for (int insertPointIndex = insertValueIndex - step;
                     insertPointIndex >= 0;
                     insertPointIndex -= step) {
                    if (arr[insertPointIndex] > arr[insertPointIndex + step]) {
                        int temp = arr[insertPointIndex];
                        arr[insertPointIndex] = arr[insertPointIndex + step];
                        arr[insertPointIndex + step] = temp;
                    }
                }
            }
        }
    }
}
