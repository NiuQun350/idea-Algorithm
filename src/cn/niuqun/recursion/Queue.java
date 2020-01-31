package cn.niuqun.recursion;

import java.util.Arrays;

/** 8皇后问题
 * @author NiuQun
 * @2019/10/13
 */

public class Queue {
    /**
     * MAX为皇后的个数
     * 数组array存放每个皇后在每一行的位置
     */
    private final int MAX = 8;
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
     * queueIndex为索引为queueIndex的皇后
     * i表示该皇后所放置的位置
     *
     * @param queueIndex
     */
    public void storage(int queueIndex) {
        // 递归出口
        if (queueIndex == MAX) {
            System.out.println(Arrays.toString(array));
            count++;
            return;
        } else {    // 递归体
            for (int queueLocationIndex = 0; queueLocationIndex < MAX; queueLocationIndex++) {
                array[queueIndex] = queueLocationIndex;
                if (judge(queueIndex)) {
                    storage(queueIndex + 1);
                }
            }
        }
    }

    public boolean judge(int queueIndex) {
        for (int i = 0; i < queueIndex; i++) {
            if (array[queueIndex] == array[i] || Math.abs(queueIndex - i) == Math.abs(array[queueIndex] - array[i])) {
                return false;
            }
        }
        return true;
    }


}
