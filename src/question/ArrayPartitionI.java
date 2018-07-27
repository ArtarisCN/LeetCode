package question;

import java.util.Arrays;

/**
 * question
 * LeetCode
 * 2018.07.27.下午2:13
 *
 * 561. Array Partition I
 * https://leetcode.com/problems/array-partition-i/description/
 *
 * @author : rick
 */
class ArrayPartitionI {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(arrayPairSum(new int[]{1,4,3,2}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int arrayPairSum(int[] nums) {

        Arrays.parallelSort(nums);

        int result = 0;

        for (int i = 0; i < nums.length; i+=2) {
            result += nums[i];
        }

        return result;

    }
}
