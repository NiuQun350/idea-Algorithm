package cn.niuqun.sort;

import java.util.Arrays;

/**
 * 快速排序平均时间复杂度：O(nlogn)
 * 最好情况：O(nlogn)
 * 最坏情况：O(n*n)
 * 空间复杂度:O(logn)
 * In-place
 * 不稳定
 *
 * 快速排序是对冒泡排序的一种改进
 * 基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的数据
 * @author NiuQun
 * @2019/9/28
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] temp = new int[]{3, 545, 48, -134, -434};
        quickSort(temp, 0, temp.length-1);
        System.out.println(Arrays.toString(temp));

        System.out.println("*********************************************");
        int[] tempArr = new int[80000];
        for(int i = 0; i < tempArr.length; i++) {
            // 生成80000个[0-80000)的数
            tempArr[i] = (int)(Math.random() * 80000);
        }
        // System.out.println(Arrays.toString(tempArr));

        long d1 = System.currentTimeMillis();
        quickSort(tempArr, 0, tempArr.length-1);
        long d2 = System.currentTimeMillis();
        System.out.println("排序时间为：" + (d2 - d1));
    }
    //  3 545 48 48 -134 -434
    //  3 -434 48 48 -134 545
    //  left = 2 right = 4
    //   48=pivot  -134
    //  3 -434 -134 48 48 545
    //  left = 2 right 3

    public static void quickSort(int[] intArr, int Left, int Right) {
        int left = Left;
        int right = Right;
        // pivot是中轴的意思
        int pivot = intArr[(left + right) / 2];
        // while循环的目的是让比pivot值小的放到左边, 比pivot值大的放到右边
        while(left < right) {
            // 在pivot的左边一直找，找到大于等于pivot的值才退出
            while(intArr[left] < pivot) {
                left++;
            }
            while(intArr[right] > pivot) {
                right--;
            }
            // 如果left>=right说明pivot的左右两边的值已经按照左边全小于等于pivot, 右边全大于等于pivot的值
            if(left >= right) {
                break;
            }
            int temp = intArr[left];
            intArr[left] = intArr[right];
            intArr[right] = temp;

            if(intArr[left] == pivot) {
                right--;
            }
            if(intArr[right] == pivot) {
                left++;
            }
        }


        if(left == right) {
            left++;
            right--;
        }

        // 左递归
        if(Left < right) {
            quickSort(intArr, Left, right);
        }
        if(Right > left) {
            quickSort(intArr, left, Right);
        }



    }
}


