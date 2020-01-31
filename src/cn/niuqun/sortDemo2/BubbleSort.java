package cn.niuqun.sortDemo2;


/**
 * @author NiuQun
 * @2019/9/30
 */

public class BubbleSort {
    private static final int MAX = 100000;
    public static void main(String[] args) {

        // 测试
        int[] arr = new int[MAX];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000);
        }
        long d1 = System.currentTimeMillis();
        bubbleSort(arr);
        long d2 = System.currentTimeMillis();
        System.out.println("冒泡排序100000个数据花费时间为:" + (d2-d1));
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            boolean flag = false;
            for(int j = 0; j < arr.length-i; j++) {
                if(arr[j] > arr[j+1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(flag = false) {
                break;
            }
        }


    }
}
