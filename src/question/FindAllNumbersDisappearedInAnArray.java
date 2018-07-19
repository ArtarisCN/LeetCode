package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.19.下午3:36
 *
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * @author : rick
 */
class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {


        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<Integer> result = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});


        for (Integer integer : result) {
            System.out.println(integer + " ");
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int a = i, b = nums[i] - 1;

                nums[a] ^= nums[b];
                nums[b] ^= nums[a];
                nums[a] ^= nums[b];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }

    /**
     * 第一种解法，这种解法的思路路是，对于每个数字nums[i]，如果其对应的nums[nums[i] - 1]是正数，
     * 我们就赋值为其相反数，如果已经是负数了，就不变了，那么最后我们只要把留下的整数对应的位置加入结果res中即可
     */
}

