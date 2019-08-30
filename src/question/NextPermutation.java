package question;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2019.02.21.18:19
 * <p>
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 *
 * @author : artairs
 */
class NextPermutation {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[] nums = new int[]{1, 3, 2};

        nextPermutation(nums);

        PrintUtils.printf(nums);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int thisValue = nums[i],minIndex = i;
            for (int j = i; j > 0; j--) {
                minIndex = nums[j] < nums[minIndex]?j:minIndex;
            }

        }
    }


}
