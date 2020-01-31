package cn.niuqun.sort;

import java.util.Arrays;

/**
 * 插入排序平均时间复杂度：O(n*n)
 * 最好情况：O(n*n)
 * 最坏情况：O(n*n)
 * 空间复杂度:O(1)
 * In-place
 * 不稳定
 * @author NiuQun
 * @2019/9/23
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] tempArr = new int[80000];
        for(int i = 0; i < tempArr.length; i++) {
            // 生成80000个[0-80000)的数
            tempArr[i] = (int)(Math.random() * 80000);
        }
        long d1 = System.currentTimeMillis();
        selectSort(tempArr);
        // System.out.println(Arrays.toString(tempArr));
        long d2 = System.currentTimeMillis();
        System.out.printf("the time of sort is %s", d2 - d1);

    }

    public static void selectSort(int[] intArr) {
        for(int i = 0; i < intArr.length - 1; i++) {
            int minIndex= i;
            for(int j = i+1; j < intArr.length; j++) {
                if (intArr[minIndex] > intArr[j]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = intArr[minIndex];
                intArr[minIndex] = intArr[i];
                intArr[i] = temp;
            }

        }


    }
}
