package cn.niuqun.sortDemo2;

/**
 * @author NiuQun
 * @2019/9/30
 */

public class ShellSort {
    private static final int MAX = 100000;
    public static void main(String[] args) {
        int[] arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = (int)(Math.random() * 10000);
        }
        long d1 = System.currentTimeMillis();
        shellSort(arr);
        long d2 = System.currentTimeMillis();
        System.out.println("移动法希尔排序100000个数据的时间为:" + (d2 - d1));
    }

    public static void shellSort(int[] arr) {
        for(int step = arr.length / 2; step > 0; step /= 2) {
            for(int insertValueIndex = step; insertValueIndex < arr.length; insertValueIndex += step) {
                int insertValue = arr[insertValueIndex];
                int insertPointIndex;
                for(insertPointIndex = insertValueIndex - step;
                    insertPointIndex >= 0 && insertValue < arr[insertPointIndex];
                    insertPointIndex -= step) {
                  arr[insertPointIndex + step] = arr[insertPointIndex];
                }
                arr[insertPointIndex + step] = insertValue;
            }
        }
    }
}
