package question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.11.01.16:05
 * <p>
 * 506. Relative Ranks
 * https://leetcode.com/problems/relative-ranks/
 *
 * @author : artairs
 */
class RelativeRanks {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfArray(findRelativeRanks(new int[]{5, 4, 3, 2, 1}));
        System.out.println();
        PrintUtils.printfArray(findRelativeRanks(new int[]{4, 1}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static String[] findRelativeRanks(int[] nums) {
        if (nums.length == 0) {
            return new String[]{};
        }

        String[] result = new String[nums.length];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                result[map.get(nums[i])] = "Gold Medal";
            } else if (i == nums.length - 2) {
                result[map.get(nums[i])] = "Silver Medal";
            } else if (i == nums.length - 3) {
                result[map.get(nums[i])] = "Bronze Medal";
            } else {
                result[map.get(nums[i])] = (nums.length - i) + "";
            }
        }

        return result;
    }
}
