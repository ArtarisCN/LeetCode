package question;

import java.util.HashSet;
import java.util.Set;

/**
 * question
 * LeetCode
 * 2018.10.30.16:57
 *
 * 633. Sum of Square Numbers
 * https://leetcode.com/problems/sum-of-square-numbers/
 *
 * @author : artairs
 */
class SumOfSquareNumbers {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(judgeSquareSum(2147482647));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean judgeSquareSum(int c) {
        Set<Integer> square = new HashSet<>();
        square.add(0);
        for (int i = 1; i <= (int) Math.sqrt(c); i++) {
            square.add(i * i);
        }

        for (Integer integer : square) {
            if(square.contains(c - integer)){
                return true;
            }
        }

        return false;
    }

}
