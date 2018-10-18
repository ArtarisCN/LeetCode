package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.10.18.10:10
 * <p>
 * 202.Happy Number
 * https://leetcode.com/problems/happy-number/
 *
 * @author : artairs
 */
class HappyNumber {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(isHappy(1123));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isHappy(int n) {
        return isHappyNum(new ArrayList<>(), n);
    }

    public static boolean isHappyNum(List<Integer> nums, int n) {

        int sum = -1;
        while (n != 0) {
            if (sum == -1) {
                sum = 0;
            }
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        System.out.println(sum);
        if (sum == 1 || sum == 7) {
            return true;
        } else {
            if (nums.contains(sum)) {
                return false;
            } else {
                nums.add(sum);
                return isHappyNum(nums, sum);
            }
        }
    }

}
