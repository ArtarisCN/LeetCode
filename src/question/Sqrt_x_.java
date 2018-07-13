package question;

/**
 * question
 * LeetCode
 * 2018.07.13.上午10:15
 *
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/description/
 *
 * @author : rick
 */
class Sqrt_x_ {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(mySqrt(0)));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int mySqrt(int x) {

        return (int)Math.sqrt(x);

    }
}
