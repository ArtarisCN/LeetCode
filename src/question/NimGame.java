package question;

/**
 * question
 * LeetCode
 * 2018.07.13.上午11:07
 *
 * 292. Nim Game
 * https://leetcode.com/problems/nim-game/description/
 *
 * @author : rick
 */
class NimGame {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();



        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}