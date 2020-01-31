package cn.niuqun.recursionDemo;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/10/13
 */

public class Queue {
    private int MAX = 8;
    private int[] array = new int[MAX];
    private int count = 0;
    public static void main(String[] args) {
        Queue q = new Queue();
        q.storage(0);
        System.out.println(q.getCount());
    }

    public int getCount() {
        return count;
    }

    /**
     * 确定每个皇后的位置
     * @param queueIndex
     */
    public void storage(int queueIndex) {
        // 递归出口
        if (queueIndex == MAX) {
            System.out.println(Arrays.toString(array));
            count++;
            return;
        }

        for (int queueLocationIndex = 0; queueLocationIndex < MAX; queueLocationIndex++) {
            array[queueIndex] = queueLocationIndex;
            if (judge(queueIndex)) {
                storage(queueIndex+1);
            }
        }
    }

    /**
     * 确定每个皇后放在某个位置是否正确
     * @param queueIndex
     * @return
     */
    public boolean judge(int queueIndex) {
        // 用i遍历queueIndex皇后之前每一个皇后的位置
        for (int i = 0; i < queueIndex; i++) {
            if (array[queueIndex] == array[i] || Math.abs(queueIndex - i) == Math.abs(array[queueIndex] - array[i])) {
                return false;
            }
        }
        return true;
    }
}
