package question;

/**
 * question
 * LeetCode
 * 2018.09.28.18:26
 *
 * 504. Base 7
 * https://leetcode.com/problems/base-7/description/
 *
 * @author : artairs
 */
class Base7 {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(convertToBase7(-14));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String convertToBase7(int num) {
        final int v = 7;
        boolean minus = num < 0;
        if(num == 0){
            return "0";
        }
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();

        while (num > 0){

            int x = num % v;
            sb.append(x);
            num /= v;
        }

        if(minus) {
            sb.append('-');
        }

        return sb.reverse().toString();

    }

}
