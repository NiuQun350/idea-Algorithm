package cn.niuqun.divideConquer;

/**
 * @author NiuQun
 * @2019/10/21
 */

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(1, 'A', 'B', 'C');
        System.out.println("*********************************");
        hanoiTower(2, 'A', 'B', 'C');
        System.out.println("*********************************");
        hanoiTower(3, 'A', 'B', 'C');
    }

    /**
     *
     * @param num  一共有num个盘需要从A盘移动到C盘
     * @param x
     * @param y
     * @param z
     */
    public static void hanoiTower(int num, char x, char y, char z) {
        if (num == 1) {
            System.out.println("将第1个盘从" +  x + "盘移动到" + z + "盘");
        } else {
            hanoiTower(num-1, x, z, y);
            System.out.println("将第" + num + "个盘从" + x + "盘移动到" +  z + "盘");
            hanoiTower(num-1, y, x, z);
        }
    }
}
