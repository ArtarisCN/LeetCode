package question;

import util.SortUtils;

/**
 * question
 * LeetCode
 * 2019.02.21.15:57
 *
 * 164. Maximum Gap
 * https://leetcode.com/problems/maximum-gap/
 *
 * @author : artairs
 */
class MaximumGap {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(maximumGap(new int[]{36, 9, 0, 25, 1, 49, 64, 16, 81, 4}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int maximumGap(int[] nums) {


        SortUtils.bucketSort(nums);

        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(nums[i] - nums[i - 1],result);
        }

        return result;
    }


}
