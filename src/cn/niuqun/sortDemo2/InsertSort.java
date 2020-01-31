package cn.niuqun.sortDemo2;

/**
 * @author NiuQun
 * @2019/9/30
 */

public class InsertSort {
    private static final int MAX = 100000;
    public static void main(String[] args) {
        int[] arr1 = new int[MAX];
        int[] arr2 = new int[MAX];
        for(int i = 0; i < MAX; i++) {
            arr1[i] = (int)(Math.random() * 10000);
        }
        for(int i = 0; i < MAX; i++) {
            arr2[i] = (int)(Math.random() * 10000);
        }
        long d1 = System.currentTimeMillis();
        insertSort1(arr1);
        long d2 = System.currentTimeMillis();
        System.out.println("插入排序移动法100000个数据时间为：" + (d2 - d1));

        long d3 = System.currentTimeMillis();
        insertSort2(arr2);
        long d4 = System.currentTimeMillis();
        System.out.println("插入排序交换法100000个数据时间为：" + (d4 - d3));

    }
    public static void insertSort1(int[] arr) {
        for(int insertValueIndex = 1; insertValueIndex < arr.length; insertValueIndex++) {
            int insertValue = arr[insertValueIndex];
            int insertPoint;
            for(insertPoint = insertValueIndex - 1; insertPoint >= 0 && insertValue < arr[insertPoint]; insertPoint--) {
                arr[insertPoint+1] = arr[insertPoint];
            }
            arr[insertPoint+1] = insertValue;
        }
    }

    public static void insertSort2(int[] arr) {
        for(int insertValueIndex = 1; insertValueIndex < arr.length; insertValueIndex++) {
            for(int insertPointIndex = insertValueIndex-1; insertPointIndex >= 0; insertPointIndex--) {
                if(arr[insertPointIndex] > arr[insertPointIndex+1]) {
                    int temp = arr[insertPointIndex];
                    arr[insertPointIndex] = arr[insertPointIndex+1];
                    arr[insertPointIndex+1] = temp;
                }

            }
        }
    }

}
