package cn.sxt.example;


import java.util.Scanner;

/**
 * 递推实现
 * @author NiuQun
 * @2019/10/19
 */

public class PlayChess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int end = scanner.nextInt();
        double[] way1 = new double[end+1];
        double[] way2 = new double[101];
        System.out.println(setWay1(way1));
        System.out.println(setWay2(way2));
    }

    /**
     * 正向递推
     * @param way1  way1[i]用于保存停在i点的概率
     * @return 最终停在终点的概率
     */
    public static double setWay1(double[] way1) {
        way1[0] = 1;
        way1[1] = 0.5;
        for (int i = 2; i < way1.length; i++) {
            way1[i] = way1[i-1] * 0.5 + way1[i-2] * 0.5;
        }
        return way1[way1.length-1];
    }

    public static double setWay2(double[] way2) {
        way2[4] = 1;
        way2[3] = 0;
        for (int i = 2; i >= 0; i--) {
            way2[i] = 0.5 * way2[i+1] + 0.5 * way2[i+2];
        }
        return way2[0];
    }
}
