package cn.niuqun.title;
/*
1497.传球问题 (20分)
C时间限制：3000 毫秒 |  C内存限制：3000 Kb
题目内容：
现有四个人做传球游戏，要求接球后马上传给别人。由甲先传球，并作为第1次传球，求经过n次传球仍回到发球人甲手中的传球方式的种数。
输入描述
整数n,已知n<20
输出描述
传球方式数
输入样例
10
输出样例
14763
*/

/**
 * 递推
 * @author NiuQun
 * @2019/10/7
 */

public class ChuanQiu {
    static final int arrSize = 20;

    /**
     *  arr1[n]保存当有n个传球机会且球最开始在甲手中时，最终球回到手中的传球方式种数
     */
    static int[] arr1 = new int[arrSize];

    /**
     * // arr1[n]保存当有n个传球机会且球最开始不在甲手中时，最终球回到手中的传球方式种数
     */
    static int[] arr2 = new int[arrSize];

    public static void main(String[] args) {
        System.out.println(ball(10));
    }

    public static int ball(int n) {
        arr1[1] = 0;
        arr2[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr1[i] = 3 * arr2[i-1];
            arr2[i] = arr1[i-1] + 2 * arr2[i-1];
        }
        return arr1[n];
    }


}
