package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2019.02.21.16:53
 * 、
 * 523. Continuous Subarray Sum
 * https://leetcode.com/problems/continuous-subarray-sum/
 *
 * @author : artairs
 */
class ContinuousSubarraySum {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        System.out.println(checkSubarraySum(new int[]{2, 4}, 6));
        System.out.println(checkSubarraySum(new int[]{1, 1}, 1));
        System.out.println(checkSubarraySum(new int[]{0, 0}, -1));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{0, 0}, 0));


        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 0));
        System.out.println(checkSubarraySum(new int[]{0,1, 0}, 0));
        System.out.println(checkSubarraySum(new int[]{7}, 6));
        System.out.println(checkSubarraySum(new int[]{6}, 6));
        System.out.println(checkSubarraySum(new int[]{}, 6));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int lastSum = 0;

        for (int i = 0; i < nums.length; i++) {
            lastSum += nums[i];

            if (k != 0 && lastSum != k) {
                lastSum = lastSum % k;
            }

            if (( (lastSum == 0 || lastSum == k) && i != 0) )
                return true;

            if (map.containsKey(lastSum)) {
                if (i - map.get(lastSum) > 0)
                    if(k == 0) {
                        if (lastSum == 0)
                            return true;
                    } else
                        return true;
            } else {
                map.put(lastSum, i);
            }
        }

        return false;
    }

}
