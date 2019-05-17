package otherQuestion;

/**
 * otherQuestion
 * LeetCode
 * 2019.05.17.11:22
 *
 * @author : artairs
 */
class TheMaxDifferenceValue {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        int[] nums = new int[]{4,2,7,5,11,13,9,1};
        int[] nums = new int[]{2,9,1,5};
        int[] result = maxDiffValue(nums);
        for (int i : result) {
            System.out.println(i);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static int[] maxDiffValue(int[] nums){
        int size = nums.length;
        if(size < 2){
            return new int[]{0,0};
        }
        int[] dp = new int[size];
        int[] result = new int[2];
        dp[0] = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1]<0?nums[i] - nums[i - 1]: nums[i] - nums[i - 1] + dp[i - 1];
            if(dp[i] > maxValue){
                maxValue = dp[i];
                result[1] = i;
            }
        }
        return new int[]{0,0};
    }
}
