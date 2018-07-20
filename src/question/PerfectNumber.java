package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.20.上午10:57
 *
 * 507. Perfect Number
 * https://leetcode.com/problems/perfect-number/description/
 *
 * @author : rick
 */
class PerfectNumber {
    public static void main(String[] args) {


        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(checkPerfectNumber(2));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean checkPerfectNumber(int num) {

        if (num == 1 || num == 0) {
            return false;
        }

        List<Integer> nums = new ArrayList<>();
        int sqrt = (int) Math.sqrt(num) + 1;

        for (int i = 1; i < sqrt; i++) {
            if (num % i == 0) {
                nums.add(i);
                if (num / i != i) {
                    nums.add(num / i);
                }
            }
        }

        int sum = 0;
        for (Integer integer : nums) {
            sum += integer;
        }

        return sum == num;

    }

}
