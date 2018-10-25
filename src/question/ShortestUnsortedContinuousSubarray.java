package question;

import java.util.Arrays;

/**
 * question
 * LeetCode
 * 2018.10.25.10:01
 * <p>
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * @author : artairs
 */
class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        Arrays.sort(copy);

        int start = 0, end = nums.length - 1;

        while (start < nums.length && copy[start] == nums[start]) {
            start++;
        }

        while (end > -1 && copy[end] == nums[end]) {
            end--;
        }

        return Math.max(end - start + 1, 0);
    }


}
