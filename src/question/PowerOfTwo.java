package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午2:20
 * <p>
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/description/
 *
 * @author : rick
 */
class PowerOfTwo {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(isPowerOfTwo(-16)));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }

        while (n != 1) {

            if (n % 2 == 1) {
                return false;
            }
            n = n >> 1;
        }

        return true;
    }

    public static boolean isPowerOfTwo2(int n) {

        return n > 0  && ((n & (n - 1) )== 0);
    }


}
