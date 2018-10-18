package question;

/**
 * question
 * LeetCode
 * 2018.10.18.10:56
 *
 * 53.Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 * @author : artairs
 */
class MaximumSubarray {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int maxSubArray(int[] nums) {

        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                continue;
            }

            int sum = nums[i];

            for (int j = i + 1; j < i; j++) {
                if(nums[j] < 0){
                    if(max < sum){
                        max = sum;
                        break;
                    }
                }

                sum += nums[j];
            }

            if(max < sum){
                max = sum;
            }
        }

        return max<0?0:max;

    }

}
