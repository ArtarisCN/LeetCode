package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.10.22.10:53
 * <p>
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/
 *
 * @author : artairs
 */
class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        PrintUtils.printfArray(intersect(new int[]{4,9,5},
                new int[]{9,4,9,8,4}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                ans.add(i);
                map.put(i, map.get(i) - 1);
            }
        }

        int[] x = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            x[i] = ans.get(i);
        }

        return x;
    }
}
