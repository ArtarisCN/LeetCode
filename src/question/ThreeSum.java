package question;

import java.util.Arrays;
import java.util.List;

import util.SortUtils;

/**
 * question
 * LeetCode
 * 2018.11.12.15:59
 *
 * @author : artairs
 */
class ThreeSum {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[] result = new int[]{1,23,61,7,2,87,37,9,4,9};

        SortUtils.bucketSort(result);

        Arrays.sort(result);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public List<List<Integer>> threeSum(int[] nums) {

        return null;
    }

}
