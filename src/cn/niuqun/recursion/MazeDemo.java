package cn.niuqun.recursion;

import java.util.Arrays;

/**
 * @author NiuQun
 * @2019/10/7
 */

public class MazeDemo {
    static final int ONE_DIMENSIONAL = 8;
    static final int TOW_DIMENSIONAL = 7;
    private static int count = 0;

    public static void main(String[] args) {
        // 创建一个二维数组，模拟迷宫
        int[][] map = new int[ONE_DIMENSIONAL][TOW_DIMENSIONAL];
        // 使用1表示墙
        // 上下全部为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[ONE_DIMENSIONAL - 1][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][TOW_DIMENSIONAL - 1] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("地图的情况：");
        for (int[] temp : map) {
            System.out.println(Arrays.toString(temp));
        }
        System.out.println("***************************");

        // 使用递归回溯给小球找路
        setWay(map, 1, 1);

        // 输出新的地图,小球走过,并标识过的递归
        System.out.println("小球走过,并标识的地图的情况:");
        for (int[] temp: map) {
            System.out.println(Arrays.toString(temp));
        }
        System.out.println("count=" + count);

    }

    // 使用递归回溯来给小球找路
    // description:
    // 1.  map表示地图
    // 2.  i,j表示从地图的哪个位置开始出发
    // 3.  如果小球能到map[6][5]位置，则说明通路找到，
    // 4.  约定：当map[i][j]为0表示该点没有走过，为1表示墙，2表示已经走过，并且可以走的通，3表示已经走过，但是走不通
    // 5.  在走迷宫时，需要先确定一个策略： 下->右->上->左, 如果该点走不通，再回溯

    /**
     * @param map 表示地图
     * @param i   i, j表示重哪个位置开始找
     * @param j
     * @return 如果找到通路返回true, 否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        // 递归出口
        if (map[6][5] == 2) {
            return true;


        } else {
            // 递归体

            // 如果当前这个点还没有走过
            // 按照策略:下->右->上->左

            if (map[i][j] == 0) {
                // 先假设该点走得通
                map[i][j] = 2;

                if (setWay(map, i + 1, j)) {

                    // 向下走
                    count++;
                    return true;

                } else if (setWay(map, i, j + 1)) {
                    // 向右走
                    count++;
                    return true;

                } else if (setWay(map, i - 1, j)) {
                    // 向上走
                    count++;
                    return true;

                } else if (setWay(map, i, j - 1)) {
                    // 向左走
                    count++;
                    return true;

                } else {
                    // 若该点邻近的四个方向都走不通，说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 如果map[i][j] != 0, 可能是1， 2， 3
                return false;
            }
        }
    }
}

