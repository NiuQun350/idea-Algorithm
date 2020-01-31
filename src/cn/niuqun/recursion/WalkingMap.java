package cn.niuqun.recursion;

import java.util.Scanner;

/**
 *500.走地图 (10分)
 * C时间限制：3000 毫秒 |  C内存限制：3000 Kb
 * 题目内容：
 *  在一个nxn的棋盘上，某人站在方格(0, 0)，他只能向下或者向右，而且只能在棋盘的上三角中行走，问他走到(n-1, n-1)有多少种走法。
 * 输入描述
 * 棋盘大小n
 *
 * 输出描述
 * 从（0,0）走到（n-1,n-1）的走法数
 *
 * 输入样例
 * 6
 *
 * 输出样例
 * 42
 * @author NiuQun
 * @2019/10/13
 */

public class WalkingMap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mapSize = scanner.nextInt();
        int[][] map = new int[mapSize][mapSize];

        System.out.println(setMap(map));
    }

    public static int setMap(int[][] map) {
        map[0][0] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                if (i <= j ) {
                    if (i == 0) {
                        map[i][j] = map[i][j - 1];
                    } else if (i == j) {
                        map[i][j] = map[i - 1][j];
                    } else {
                        map[i][j] = map[i - 1][j] + map[i][j - 1];
                    }
                }
            }
        }
        return map[map.length-1][map.length-1];
    }

}
