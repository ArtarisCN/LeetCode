package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午5:13
 * <p>
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/description/
 *
 * @author : rick
 */
class PowerOfFour {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(isPowerOfFour(16)));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isPowerOfFour(int num) {

        return num != 0 && (num & (num - 1)) == 0 && ((num - 1) % 3 == 0);

    }

}
