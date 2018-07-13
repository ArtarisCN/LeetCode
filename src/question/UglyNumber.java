package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午2:31
 *
 * 263. Ugly Number
 * https://leetcode.com/problems/ugly-number/description/
 *
 * @author : rick
 */
class UglyNumber {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(String.valueOf(isUgly(14)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isUgly(int num) {

        if (num < 1) {
            return false;
        }


        while (num != 1) {

            if (num % 2 == 0) {
                num = num / 2;
                continue;
            }

            if (num % 3 == 0) {
                num = num / 3;
                continue;
            }

            if (num % 5 == 0) {
                num = num / 5;
                continue;
            }

            return false;
        }

        return true;


    }

}
