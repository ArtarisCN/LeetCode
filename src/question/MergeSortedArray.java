package question;

import java.util.Arrays;

/**
 * question
 * LeetCode
 * 2018.11.05.19:37
 * <p>
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * @author : artairs
 */
class MergeSortedArray {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[] nums1 = new int[]{1, 2, 4, 5, 6, 0};
        int[] nums2 = new int[]{3, 5, 6, 0, 0, 0};
        merge(nums1, 5, nums2, 1);

        for (int i : nums1) {
            System.out.print(i + " ");
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;

        while (j >= 0){
            nums1[index --] = i >= 0 && nums1[i] > nums2[j]?nums1[i --]:nums2[j--];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);

    }

}
