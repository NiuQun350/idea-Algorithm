package cn.sxt.example;

/**
 * 某人写好了100封信和100个信封，准备发给100个不同的人，问：将所有的信都装错的情况有多少种
 * @author NiuQun
 * @2019/10/19
 */

public class WrongEnvelop {
    public static void main(String[] args) {
        System.out.println(fun1(10));
    }

    public static int fun1(int counts) {
        if (counts == 1) {
            return 0;
        }
        return (counts-1) * fun2(counts-1);

    }

    public static int fun2(int counts) {
        if (counts == 1) {
            return 1;
        }
        return fun1(counts-1) + (counts-1) * fun2(counts-1);
    }

}