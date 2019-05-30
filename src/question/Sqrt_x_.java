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

        System.out.println(String.valueOf(mySqrt2(2147395599)));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int mySqrt(int x) {
        int res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return res;
    }


    public static int mySqrt2(int x) {
        if(x == 0){
            return 0;
        }
        long start = 1,end = x / 2 + 1;

        while (end - start > 1){
            long mid = (start + end) /2;
            if( mid * mid  == x ){
                return (int) mid;
            } else if( mid * mid < x  ){
                start = (int) mid;
            } else {
                end = mid;
            }
        }

        return (int) start;
    }



}
