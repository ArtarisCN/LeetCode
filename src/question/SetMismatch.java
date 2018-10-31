package question;

import java.util.HashSet;
import java.util.Set;

/**
 * question
 * LeetCode
 * 2018.10.31.12:03
 *
 * 645. Set Mismatch
 * https://leetcode.com/problems/set-mismatch/
 *
 * @author : artairs
 */
class SetMismatch {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(i + 1);
        }

        for (int num : nums) {
            if (!set.contains(num)) {
                result[0] = num;
            } else {
                set.remove(num);
            }
        }
        result[1] = set.iterator().next();

        return result;
    }
}
