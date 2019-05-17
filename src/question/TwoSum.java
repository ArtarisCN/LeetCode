package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2017.07.20.下午4:25
 * <p>
 * 1. Two Sum
 *
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * @author : rick
 */
public class TwoSum {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        for (int j = 0; j < 10000; j++) {
            for (int i : twoSum2(new int[]{15,50,74,88,91,66,36,88,23,13,22,17,56,57,52,59,80,78,73,19,53,28,65,72,67,31,48,92,0,28,74,95,16,73,44,94,87,68,6,29,55,0,39,71,31,2,85,15,62,0,58,36,19,8,59,45,25,52,45,48,46,57,22,54,88,34,53,77,11,71,30,56,0,51,24,63,92,32,87,83,46,26,98,93,34,71,94,12,33,38,26,28,90,53,79,39,59,26,55,52,10}, 6)) {
                System.out.println(i);
            }
        }


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = {-1, -1};
        boolean flag = false;
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                if (nums[x] + nums[y] == target) {
                    result[0] = x;
                    result[1] = y;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        return result;
    }

    private static int[] twoSum2(int[] nums, int target) {
        //value,index
        Map<Integer,Integer> source = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(source.containsKey(target - nums[i])){
                return new int[]{source.get(target - nums[i]),i};
            }
            source.put(nums[i],i);
        }

        return new int[]{-1, -1};
    }
}
