package question;

/**
 * question
 * LeetCode
 * 2018.11.02.18:21
 * <p>
 * 674. Longest Continuous Increasing Subsequence
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 *
 * @author : artairs
 */
class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 7}));
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
//        System.out.println(findLengthOfLCIS(new int[]{4,3,2,1,3,5,7}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE, temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                temp = i;
            } else if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
                result = Math.max(result, i - temp + 1);
            } else {
                if (nums[i] <= nums[i - 1]) {
                    if (i - temp > result) {
                        result = i - temp;
                    }

                    temp = i;
                }
            }
        }

        return result == Integer.MIN_VALUE ? 1 : result;
    }


}
