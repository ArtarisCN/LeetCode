package question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * question
 * LeetCode
 * 2018.07.13.下午2:53
 *
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/description/
 *
 * @author : rick
 */
class MissingNumber {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};

        System.out.println(String.valueOf(missingNumber(nums)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int missingNumber(int[] nums) {
        List<Integer> array = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (int i = 0; i <= nums.length; i++) {
            if(!array.contains(i)){
                return i;
            }
        }
        return 0;
    }
}
