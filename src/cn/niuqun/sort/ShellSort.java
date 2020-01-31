package cn.niuqun.sort;

import java.util.Arrays;

/**
 * 希尔排序平均时间复杂度：O(nlogn)
 * 最好情况：O(n*logn*logn)
 * 最坏情况：O(n*logn*logn)
 * 空间复杂度:O(1)
 * In-place
 * 稳定
 * 希尔排序是对插入排序的一种改进，避免了从小到大排序时，当小值在后方时，需要移动大量数据的情况
 * 希尔排序也是一种插入排序，但是它是经过改进后的一个更高效的版本，也称为缩小增量排序
 *
 * 步长 == 组数
 *
 * @author NiuQun
 * @2019/9/28
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] test = new int[]{34543, 34, -34, 545, 59, -1, -343, 43};
        shellSort(test);
        System.out.println(Arrays.toString(test));

        int[] test1 = new int[]{34543, 34, -34, 545, 59, -1, -343, 43};
        shellSort2(test1);
        System.out.println(Arrays.toString(test1));


        int[] temp5 = new int[80000];
        for(int i = 0; i < temp5.length; i++) {
            // 生成80000个[0-80000)的数
            temp5[i] = (int)(Math.random() * 80000);
        }

        long d1 = System.currentTimeMillis();
        shellSort2(temp5);

        long d2 = System.currentTimeMillis();
        System.out.println("希尔排序移动法时间为：" + (d2 - d1));


        int[] temp6 = new int[80000];
        for(int i = 0; i < temp6.length; i++) {
            // 生成80000个[0-80000)的数
            temp6[i] = (int)(Math.random() * 80000);
        }
        long d3 = System.currentTimeMillis();
        shellSort(temp6);
        long d4 = System.currentTimeMillis();
        System.out.println("希尔排序交换法时间为：" + (d4 - d3));

    }

    public static void shellSort(int[] intArr) {
        for(int step = intArr.length / 2; step > 0; step /= 2) {
            for(int insertValueIndex = step; insertValueIndex < intArr.length; insertValueIndex++) {
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

    public static void shellSort2(int[] intArr) {
        for(int step = intArr.length / 2; step > 0; step /= 2) {
            for(int insertValueIndex = step; insertValueIndex < intArr.length; insertValueIndex += step) {
                int insertValue = intArr[insertValueIndex];
                int insertPointIndex;
                for(insertPointIndex = insertValueIndex - step;
                    insertPointIndex >= 0 && insertValue < intArr[insertPointIndex];
                    insertPointIndex -= step) {
                        intArr[insertPointIndex + step] = intArr[insertPointIndex];
                }
                intArr[insertPointIndex + step] = insertValue;
            }
        }

    }



}
