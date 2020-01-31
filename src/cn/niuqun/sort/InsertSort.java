package cn.niuqun.sort;

import java.util.Arrays;

/**
 * 插入排序平均时间复杂度：O(n*n)
 * 最好情况：O(n)
 * 最坏情况：O(n*n)
 * 空间复杂度:O(1)
 * In-place
 * 稳定
 * @author NiuQun
 * @2019/9/28
 */

public class InsertSort {
    public static void main(String[] args) {
        // 测试一下插入排序的速度O(n*n),80000个数据
        int[] temp1 = new int[80000];
        for(int i = 0; i < temp1.length; i++) {
            // 生成80000个[0-80000)的数
            temp1[i] = (int)(Math.random() * 80000);
        }

        long d1 = System.currentTimeMillis();
        insertSort(temp1);
        long d2 = System.currentTimeMillis();
        System.out.println("插入排序移动法时间为：" + (d2 - d1));


        // 测试一下插入排序的速度O(n*n),80000个数据
        int[] temp2 = new int[80000];
        for(int i = 0; i < temp2.length; i++) {
            // 生成80000个[0-80000)的数
            temp2[i] = (int)(Math.random() * 80000);
        }

        long d3 = System.currentTimeMillis();
        insertSort1(temp2);
        long d4 = System.currentTimeMillis();
        System.out.println("插入排序交换法时间为：" + (d4 - d3));


        int[] temp3 = new int[]{534, 343, 4, 34, -1};
        insertSort(temp3);
        System.out.println(Arrays.toString(temp3));

        int[] temp4 = new int[]{534, 343, 4, 34, -1};
        insertSort1(temp4);
        System.out.println(Arrays.toString(temp4));


    }


    /**
     * 这里用的是移动法
     * @param intArr
     */
    public static void insertSort(int[] intArr) {
        for(int i = 1; i < intArr.length; i++) {
            // 一开始就记住待插入数的数值，此后就可以直接覆盖，而不用交换
            int insertValue = intArr[i];
            int insertIndex;

            for (insertIndex = i - 1; insertIndex >= 0 && insertValue < intArr[insertIndex]; insertIndex--) {
                intArr[insertIndex + 1] = intArr[insertIndex];
            }
            intArr[insertIndex + 1] = insertValue;

        }
    }

    /**
     * 这里用的是交换法
     * @param intArr
     */
    public static void insertSort1(int[] intArr) {
        for(int i = 1; i < intArr.length; i++) {
            // j为待插入点的索引
            for(int j = i - 1; j >= 0; j--) {
                if(intArr[j] > intArr[j+1]) {
                    int temp = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = temp;
                }
            }

        }
    }

}
