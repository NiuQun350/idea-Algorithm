package cn.niuqun.divideConquer;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 二分法的化分界线一定要是Left <= Right,
 * 二分法一定要注意边界,如果需要查找的数位于边界(即数组最左边或者最右边),则在将边界定义为Left < Right时(无论待查询的数组中的元素是奇数个还是偶数个)，查找时都会漏掉边界
 * 同时可将(a+b)/2 改成 a+(b-a)/2防止大数越界
 * Arrays.sort()
 * System.arraycopy()
 *
 * @author NiuQun
 * @2019/10/17
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{-8989, -3434, -343, 0, 89, 378, 5894, 9999, 100000};
        System.out.println(binarySearchByRecursion(array, 0, array.length-1, 100000));
        System.out.println(binarySearchNotRecursion(array, 100000));
        int[] array1 = new int[]{-13234, -343, -43, -23, 1, 1, 1, 1, 1, 34, 89, 348939};
        System.out.println(binarySearchRecursionAll(array1, 0, array1.length-1, 1));


    }

    public static int binarySearchByRecursion(int[] arr, int leftIndex, int rightIndex, int findValue) {

        if (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;

            if (findValue == arr[midIndex]) {
                return midIndex;
            } else if (findValue < arr[midIndex]) {
                return binarySearchByRecursion(arr, leftIndex, midIndex - 1, findValue);
            } else {
                return binarySearchByRecursion(arr, midIndex + 1, rightIndex, findValue);
            }
        } else {
            return -1;
        }
    }

    public static int binarySearchNotRecursion(int[] arr, int findValue) {
        int leftIndex = 0;
        int rightIndex = arr.length-1;

        while (leftIndex <= rightIndex) {
           int midIndex = (leftIndex + rightIndex) / 2;
            if (findValue < arr[midIndex]) {
                rightIndex = midIndex - 1;

            } else if (findValue > arr[midIndex]) {
                leftIndex = midIndex + 1;

            } else {
                return midIndex;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> binarySearchRecursionAll(int[] arr, int leftIndex, int rightIndex, int findValue) {
        if (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex)/2;

            if (findValue < arr[midIndex]) {
                return binarySearchRecursionAll(arr, leftIndex, midIndex - 1, findValue);
            } else if (findValue > arr[midIndex]) {
                return binarySearchRecursionAll(arr, midIndex + 1, rightIndex, findValue);
            } else {
                ArrayList<Integer> arrList = new ArrayList<>();

                /*
                arrList.add(midIndex);
                int leftTemp = midIndex - 1;

                while (leftTemp >= 0 && arr[leftTemp] == findValue) {
                     arrList.add(leftTemp);
                     leftTemp--;
                 }

                 int rightTemp = midIndex + 1;
                 while (rightTemp <= arr.length-1 && arr[rightTemp] == findValue) {
                     arrList.add(rightTemp);
                     rightTemp++;
                 }
                 */

                int temp = midIndex;
                while (temp >= 0 && arr[temp] == findValue) {
                    temp--;
                }
                temp++;
                while (arr[temp] == findValue) {
                    arrList.add(temp);
                    temp++;
                }
                    return arrList;
            }
        } else {
            return new ArrayList<Integer>(null);
        }
    }


}

