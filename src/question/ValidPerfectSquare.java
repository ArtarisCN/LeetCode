package question;

/**
 * question
 * LeetCode
 * 2018.10.22.13:53
 *
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 *
 * @author : artairs
 */
class ValidPerfectSquare {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(Math.sqrt(808201));
        System.out.println(isPerfectSquare(808201));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isPerfectSquare(int num) {
        if(num < 1) return false;
        if(num == 1) return true;
        int left = 1,right =  num / 2;
        while (left <= right){
            long mid = (right + left) / 2;
            long val = mid * mid;
            if(val == num){
                return true;
            } else if(mid * mid > num){
                right = (int) (mid - 1);
            } else {
                left = (int) (mid + 1);
            }
        }

        return false;
    }

}
