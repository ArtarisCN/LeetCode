package question;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.10.22.10:07
 *
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * @author : artairs
 */
class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfArray(intersection(new int[]{1,2,2,1},
                new int[]{2,2}));
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if(set.contains(i)){
                result.add(i);
            }
        }

        int[] d = new int[result.size()];
        int i = 0;
        Iterator iter = result.iterator();
        while(iter.hasNext()){
            d[i] = (int)iter.next();
            i ++;
        }

        return d;
    }
}
