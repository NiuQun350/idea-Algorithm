package cn.sxt.example;

/**
 * 100元人民币，规定只能买三种东西 (1):甲物品单价1元 (2):乙物品单价2原 (3): 丙物品单价3元；请问有多少种方法花完这100元
 * @author NiuQun
 * @2019/10/19
 */

public class BuyThingsRecursion {
    public static void main(String[] args) {
        long d1 = System.currentTimeMillis();
        System.out.println(thingsA(100));
        long d2 = System.currentTimeMillis();
        System.out.println("递归花费时间为" + (d2 - d1));
    }

    /**
     * 钱数为money, 判断第money元用于买甲物品和不买甲物品的情况
     * @param money
     * @return
     */
    public static int thingsA(int money) {
        if (money == 0) {
            return 1;
        } else if (money == 1) {
            return 1;
        } else {
            // 第money元不用于买甲物品， 第money元用于买甲物品
            return thingsB(money) + thingsA(money-1);
        }
    }

    /**
     * 钱数为money， 在第money不用于买甲物品的时候，判断第money用不用于买乙物品
     * @param money
     * @return
     */

    public static int thingsB(int money) {
        if (money == 0) {
            return 1;
        } else if (money == 1) {
            return 0;
        } else {
            //
            return thingsC(money)  + thingsB(money-2);
        }
    }

    public static int thingsC(int money) {
        if (money == 0) {
            return 1;
        } else if (money == 1) {
            return 0;
        }
        else {
            if (money % 3 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
