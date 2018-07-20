package question;

/**
 * question
 * LeetCode
 * 2018.07.20.上午11:23
 *
 * 441. Arranging Coins
 * https://leetcode.com/problems/arranging-coins/description/
 *
 * @author : rick
 */
class ArrangingCoins {

    public static void main(String[] args) {


        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(arrangeCoins(1804289383));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int arrangeCoins(int n) {

        return ((int)Math.sqrt(8 * (long)n + 1) - 1)/2;
    }
}
