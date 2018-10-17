package question;

import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.17.10:47
 * <p>
 * 167.Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author : artairs
 */
class TwoSumIIInputArrayIsSorted {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        QuestionUtils.printfArray(twoSum(new int[]{2, 7, 11, 15}, 9));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i != j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            }

            if (numbers[i] + numbers[j] < target) {
                i++;
                continue;
            }

            if (numbers[i] + numbers[j] > target) {
                j--;
                continue;
            }
        }

        return new int[]{i + 1, j + 1};
    }

}
