package question;

/**
 * question
 * LeetCode
 * 2018.11.02.18:47
 *
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 *
 * @author : artairs
 */
class MaxConsecutiveOnes {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{0,0,0,0,0}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,0,0,0}));
        System.out.println(findMaxConsecutiveOnes(new int[]{0,0,0,0,1}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        int result = Integer.MIN_VALUE,temp = -1;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 && nums[i] == 1){
                temp = i;
            }

            if(nums[i] == 0){
                if(temp != -1) {
                    result = Math.max(result, i - temp);
                    temp = -1;
                }
            } else if(temp == -1 && nums[i] == 1){
                temp = i;
            }
        }

        if(nums[nums.length - 1] == 1){
            result = Math.max(result,nums.length  - temp);
        }

        return Math.max(0,result);
    }
}
