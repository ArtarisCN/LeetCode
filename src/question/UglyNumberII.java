package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2019.03.28.15:13
 * <p>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 * <p>
 * 264. Ugly Number II
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * @author : artairs
 */
class UglyNumberII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println((nthUglyNumber(1000)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int nthUglyNumber(int n) {

        int num2 = 0, num3 = 0, num5 = 0;
        List<Integer> uglyNum = new ArrayList<>();
        uglyNum.add(1);
        while (--n > 0) {
            int thisUgly = Math.min(Math.min(uglyNum.get(num2) * 2, uglyNum.get(num3) * 3), uglyNum.get(num5) * 5);
            if (thisUgly == uglyNum.get(num2) * 2) ++num2;
            if (thisUgly == uglyNum.get(num3) * 3) ++num3;
            if (thisUgly == uglyNum.get(num5) * 5) ++num5;
            uglyNum.add(thisUgly);
        }

        return uglyNum.get(uglyNum.size() - 1);
    }

}
