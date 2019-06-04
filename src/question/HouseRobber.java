package question;

/**
 * question
 * LeetCode
 * 2019.05.31.15:31
 * <p>
 * 198. House Robber
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author : artairs
 */
class HouseRobber {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    //状态转移方程：rob(n) = max(rob(n - 1) ,rob(n - 2) + num[n])
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return robWithCache(nums, nums.length - 1, memo);
    }

    public static int robWithCache(int[] nums, int index, int[] memo) {

        if (index < 0) {
            return 0;
        }

        if (memo[index] < 0) {Unique Paths
            memo[index] = Math.max(robWithCache(nums, index - 1, memo), robWithCache(nums, index - 2, memo) + nums[index]);
        }
        return memo[index];
    }


}
