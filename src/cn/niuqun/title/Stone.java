package cn.niuqun.title;

/**
 * @author NiuQun
 * @2019/10/14
 */

import java.util.Scanner;



/*
有甲乙两个人玩取石子游戏,共有n个石子(1<=n<=30000)两个人轮流取,甲先取.每次最多取m个(1<=m<=30000)最少取一个,
当轮到谁取的时候没有石子了,谁就赢.比如4个石子,每次最多取3个,那末先取的人(甲)一定赢
(例如，甲拿走3个,乙只能拿走1个,下面轮到甲没有石子了,甲赢了．）
现在要求你写一个程序，输入n(总的石子个数），最多可以取的石子个数m，输出甲（先取的人）是否会赢，会赢的话输出YES,
否则输出LOSE.
我们这里假设甲乙两个人都采取最好的策略，也就是甲乙都非常想赢而且足够聪明．
比如输入11 4　输出"LOSE"
 输入描述
整数n m, 空格隔开
 输出描述
YES或者LOSE
输入样例
11 4
输出样例
LOSE
 * @author Administrator
 *
 */
public class Stone {
    public static void main(String[] args) {
        System.out.println("************");
        Scanner scanner = new Scanner(System.in);
        // 输入石头的数目
        int stoneNum = scanner.nextInt();
        // 输入每次最多可以取走的石头数目, 即每次取走的石头数目为1~takeMax中任意整数值
        int takeMax = scanner.nextInt();
        int[][] array = new int[stoneNum+1][stoneNum];
        for (int i = 0; i < stoneNum+1; i++) {
            for (int j = 0; j < stoneNum; j++) {
                 array[i][j] = -1;
            }
        }


        setWay(array, stoneNum, takeMax);
        System.out.println(array[0].length);



    }
    /**
     *
     * @param array 数组array中保存甲先取时的最终结果，
     *              如果array[i][j] = 0, 表示当有i个石头时，每次最多取j个石头时，甲先取时甲输
     *              如果array[i][j] = 1, 表示当有i个石头时，每次最多取j个石头时，甲先取时甲赢
     * @param stoneNum  石头的数目
     * @param takeMax   每次可以取的最多石头数目
     *
     */
    public static void setWay(int[][] array, int stoneNum, int takeMax) {
        //        石头数目               最大可取数目
        // array[stoneNum][takeMax]


        // 0个石头, 甲赢
        array[0][0] = 1;


        // 1个石头, 甲输
        array[1][1] = 0;

        // 2个石头, 每次必须取1个, 甲赢
        array[2][1] = 1;

        // 2个石头，每次可以取1个或者2个, 甲赢
        array[2][2] = 1;


        // 3个石头,每次必须取一个, 甲输
        array[3][1] = 0;

        // 3个石头,每次取1个或者2个, 甲赢
        array[3][2] = 1;

        // 3个石头,每次取1个或者2个或者3个
        array[3][3] = 1;

        //array[i][]

    }


}
