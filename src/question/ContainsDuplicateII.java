package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.10.19.15:30
 *
 * 219. Contains Duplicate II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 *
 * @author : artairs
 */
class ContainsDuplicateII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4},3));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> num = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(num.containsKey(x)){
                if(i - num.get(x) <= k){
                    System.out.println(i + " " + num.get(x));
                    return true;
                } else {
                    num.put(x,i);
                }
            } else {
                num.put(x,i);
            }
        }

        return false;
    }

}
