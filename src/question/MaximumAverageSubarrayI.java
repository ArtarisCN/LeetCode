package question;

/**
 * question
 * LeetCode
 * 2018.11.05.19:00
 *
 * 643. Maximum Average Subarray I
 * https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * @author : artairs
 */
class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAverage(new int[]{4},1));
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            max = Math.max(sum,max);
        }

        return (double)max/(double)k;
    }

}
