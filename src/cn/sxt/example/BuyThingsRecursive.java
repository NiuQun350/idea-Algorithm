package cn.sxt.example;

import java.util.Scanner;

/**
 * 递推解决
 * 100元人民币，规定只能买三种东西 (1):甲物品单价1元 (2):乙物品单价2原 (3): 丙物品单价3元；请问有多少种方法花完这100元
 * @author NiuQun
 * @2019/10/19
 */

public class BuyThingsRecursive {

    public static void main(String[] args) {
        System.out.println("请输入钱数：");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int[] byThingsA = new int[money+1];
        int[] byThingsB = new int[money+1];
        int[] byThingsC = new int[money+1];
        long d1 = System.currentTimeMillis();
        System.out.println("购买方法一共有" + storage(byThingsA, byThingsB, byThingsC) + "种");
        long d2 = System.currentTimeMillis();
        System.out.println("递推花费时间为" + (d2-d1));

    }

    public static int storage(int[] byThingsA, int[] byThingsB, int[] byThingsC) {
        byThingsA[0] = 1;
        byThingsB[0] = 1;
        byThingsC[0] = 1;

        byThingsA[1] = 1;
        byThingsB[1] = 0;
        byThingsC[1] = 0;
        // 在该题的递推中，求buyThingsA[i] 需要先知道buyThingsB[i], 求buyThingsB[i]需要先知道buyThingsC[i]
        // 故在循环中，所求顺序应该为buyThingsC[i] ==> buyThingsB[i] ==> buyThingsA[i]
        for (int i = 2; i < byThingsA.length; i++) {
            if (i % 3 == 0) {
                byThingsC[i] = 1;
            } else {
                byThingsC[i] = 0;
            }
            byThingsB[i] = byThingsB[i-2] + byThingsC[i];
            byThingsA[i] = byThingsA[i-1] + byThingsB[i];
        }
        return byThingsA[byThingsA.length-1];
    }
}
