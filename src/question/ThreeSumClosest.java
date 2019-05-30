package question;

import java.util.Arrays;

/**
 * question
 * LeetCode
 * 2019.05.30.14:09
 *
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 *
 * @author : artairs
 */
class ThreeSumClosest {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4},1));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int dValue = getDValue(target,result);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end){
                if(nums[i] + nums[start] + nums[end] == target){
                    return target;
                } else if(nums[i] + nums[start] + nums[end] < target){
                    if(getDValue(target,nums[i] + nums[start] + nums[end]) < dValue){
                        dValue = getDValue(target,nums[i] + nums[start] + nums[end]);
                        result = nums[i] + nums[start] + nums[end];
                    }
                    start ++;
                } else {
                    if(getDValue(target,nums[i] + nums[start] + nums[end]) < dValue){
                        dValue = getDValue(target,nums[i] + nums[start] + nums[end]);
                        result = nums[i] + nums[start] + nums[end];
                    }
                    end --;
                }
            }
        }

        return result;
    }

    private static int getDValue(int target,int sum){
        return Math.abs(target - sum);
    }
}
