package cn.niuqun.title;

/*
题目内容：
欧几里得原理：
用GCD(A,B)表示两个正整数A和B的最大公约数(GCD是最大公约数的英文Greatest Common Divisor的简写)。
不妨认为A>B ,那么GCD(A,B) =GCD（A-B,B）。 也就是把其中较大的一个数变为两数之差后，最大公约数不会变。
例如 GCD（36，14）= GCD (36-14， 14）=GCD（22，14）
现要求利用欧几里得原理，设计一个程序，求两个整数的最大公约数。
输入描述
输入两个整数A,B,  中间用空格间隔。

输出描述
输出A和B的最大公约数

输入样例
14 8

输出样例
2
*/

import java.util.Scanner;

/**
 * @author NiuQun
 * @2019/10/7
 */

public class CommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        System.out.println(commonDivisor(n1, n2));
    }

    public static int commonDivisor(int n1, int n2) {
        int difference = Math.abs(n1 - n2);

        if (difference > n2) {
            return commonDivisor(difference, n2);
        } else if (difference < n2)  {
            return commonDivisor(n2, difference);
        } else {
            return difference;
        }
    }
}

