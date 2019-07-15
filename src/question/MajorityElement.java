package question;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * question
 * LeetCode
 * 2018.07.13.上午10:45
 *
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description/
 *
 * @author : rick
 */
class MajorityElement {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(majorityElement(new int[]{3,2,3})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new TreeMap<>();

        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int maxTimes = 0,value = 0;
        for (Integer integer : map.keySet()) {
            if(map.get(integer) > maxTimes){
                value = integer;
                maxTimes = map.get(integer);
            }
        }

        return value;
    }
}
