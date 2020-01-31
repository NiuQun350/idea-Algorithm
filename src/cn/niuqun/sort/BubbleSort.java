package cn.niuqun.sort;

import java.util.Arrays;

/**
 * 冒泡排序平均时间复杂度：O(n*n)
 * 最好情况：O(n)
 * 最坏情况：O(n*n)
 * 空间复杂度:O(1)
 * In-place
 * 稳定
 * @author NiuQun
 * @2019/9/23
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] intArr = new int[]{3, 9, -1, 10, 20};
        bubbleSort(intArr);
        System.out.println("利用冒泡排序后的结果：");
        System.out.println(Arrays.toString(intArr));
        System.out.println("**********");

        // 测试一下冒泡排序的速度O(n*n),80000个数据
        int[] tempArr = new int[80000];
        for(int i = 0; i < tempArr.length; i++) {
            // 生成80000个[0-80000)的数
            tempArr[i] = (int)(Math.random() * 80000);
        }
        // System.out.println(Arrays.toString(tempArr));

        long d1 = System.currentTimeMillis();
        bubbleSort(tempArr);
        long d2 = System.currentTimeMillis();
        System.out.println("排序时间为：" + (d2 - d1));
    }

    /**
     * 冒泡排序的时间复杂度为O(n*n)
     * 优化方法：如果我们发现在某趟排序中，没有发生一次交换，可以提前结束冒泡排序
     *
     * @param intArr: 需要排序的数组
     */
    public static void bubbleSort(int[] intArr) {
        // 排序的趟数为n-1
        for(int i = 1; i < intArr.length; i++) {
            // flag为标识变量，表示是否进行过交换
            boolean flag = false;

            for(int j = 0; j < intArr.length-i; j++) {
                // 如果前面的数比后面的数大，则交换
                if(intArr[j] > intArr[j+1]) {
                    flag = true;
                    int temp = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = temp;
                }
            }
            //   System.out.println("第" + i +"趟排序后的数组：");
            //   System.out.println(Arrays.toString(intArr));


            // 在一趟排序中，一次交换都没有发生过
            if(!flag) {
                break;
            }

        }

    }



}
