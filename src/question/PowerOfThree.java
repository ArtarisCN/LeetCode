package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午3:07
 *
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/description/
 *
 * @author : rick
 */
class PowerOfThree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(isPowerOfThree(27)));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static boolean isPowerOfThree(int n) {

        if (n == 0) {
            return false;
        }

        while (n != 1) {

            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }

        return true;
    }
}
