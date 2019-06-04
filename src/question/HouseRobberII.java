package question;

/**
 * question
 * LeetCode
 * 2019.05.31.15:49
 *
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 *
 * @author : artairs
 */
class HouseRobberII {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return Math.max(robWithCache(nums, nums.length - 1, memo),robWithCache(nums, nums.length - 1, memo));
    }


    public static int robWithCache(int[] nums, int index, int[] memo) {
        if (index < 0) {
            return 0;
        }

        if (memo[index] < 0) {
            memo[index] = Math.max(robWithCache(nums, index - 1, memo),

                    robWithCache(nums, index - 2, memo) + nums[index]);

            memo[index] = Math.max(robWithCache(nums, index - 1, memo), robWithCache(nums, index - 2, memo) + nums[index]);
        }
        return memo[index];
    }

}
