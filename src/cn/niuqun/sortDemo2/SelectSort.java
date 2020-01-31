package cn.niuqun.sortDemo2;

/**
 * @author NiuQun
 * @2019/9/30
 */

public class SelectSort {
    private static final int MAX = 100000;
    public static void main(String[] args) {
        int[] arr = new int[MAX];
        for(int i = 0; i < MAX; i++) {
            arr[i] = (int)(Math.random() * 10000);
        }
        long d1 = System.currentTimeMillis();
        selectSort(arr);
        long d2 = System.currentTimeMillis();
        System.out.println("选择排序100000个数据的时间为：" + (d2 - d1));
    }

    public static void selectSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
