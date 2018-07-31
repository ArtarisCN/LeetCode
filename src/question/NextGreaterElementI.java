package question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * question
 * LeetCode
 * 2018.07.30.22:26
 * <p>
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/description/
 *
 * @author : artaris
 */
class NextGreaterElementI {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        List<Integer> son = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> father = Arrays.stream(nums2).boxed().collect(Collectors.toList());

        int[] result = new int[nums1.length];
        int flag = 0;

        for (Integer integer : son) {
            int index = father.indexOf(integer);
            boolean find = false;
            for (int i = index + 1; i < father.size(); i++) {
                if (father.get(i) > integer) {

                    result[flag] = father.get(i);
                    find = true;
                    break;
                }
            }


            if (!find) {
                result[flag] = -1;
            }
            flag++;
        }


        return result;

    }

    public int[] nextGreaterElementMax(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

}
