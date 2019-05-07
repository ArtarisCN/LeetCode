package question;

import java.util.HashSet;
import java.util.Set;

/**
 * question
 * LeetCode
 * 2018.07.13.下午5:35
 *
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * @author : rick
 */
class ContainsDuplicate {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(String.valueOf(containsDuplicate2(new int[]{1,2,3,1})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> value = new HashSet<>();

        for (int num : nums) {
            if(value.contains(num)){
                return true;
            } else {
                value.add(num);
            }
        }

        return false;

    }


    public static boolean containsDuplicate2(int[] nums) {

        if(nums.length == 1){
            return false;
        }

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result == 0;

    }

}
