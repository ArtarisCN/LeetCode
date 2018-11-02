package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.11.02.15:39
 * <p>
 * 594. Longest Harmonious Subsequence
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 *
 * @author : artairs
 */
class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : nums) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int maxV = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int thisV = Integer.MIN_VALUE;
            if (map.containsKey(entry.getKey() + 1)) {
                thisV = entry.getValue() + map.get(entry.getKey() + 1);
            }

            if(map.containsKey(entry.getKey() - 1)) {
                thisV = Math.max(entry.getValue() + map.get(entry.getKey() - 1), thisV);
            }

            if (thisV > maxV) {
                maxV = thisV;
            }
        }

        return maxV == Integer.MIN_VALUE ? 0 : maxV;
    }

}
