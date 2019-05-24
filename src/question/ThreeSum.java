package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.11.12.15:59
 *
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * @author : artairs
 */
class ThreeSum {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        List<List<Integer>> result = threeSum(new int[]{-1,0,1,2,-1,-4});
        List<List<Integer>> result = threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int lastA = Integer.MAX_VALUE, lastFirst = Integer.MAX_VALUE, lastLast = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            if (lastA == a) {
                continue;
            }
            int first = i + 1, last = nums.length - 1;
            while (first < last) {
                if (a + nums[first] + nums[last] == 0) {
                    if (lastA != a || lastFirst != nums[first] || nums[last] != lastLast) {
                        result.add(Arrays.asList(a, nums[first], nums[last]));
                        lastA = a;
                        lastFirst = nums[first];
                        lastLast = nums[last];
                    }
                    first++;
                    last--;
                } else if (a + nums[first] + nums[last] < 0) {
                    first++;
                } else {
                    last--;
                }
            }
        }
        return result;
    }


}
