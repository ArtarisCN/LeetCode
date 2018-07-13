package question;

/**
 * question
 * LeetCode
 * 2018.07.13.上午10:58
 *
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/description/
 *
 * @author : rick
 */
class NumberOf1Bits {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(hammingWeight(128)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int hammingWeight(int n) {

        int count = 0;
        while (n != 0){

            n &= n -1;

            count ++;
        }

        return count;
    }
}
