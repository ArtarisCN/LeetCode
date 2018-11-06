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

//        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
//        int[] nums1 = new int[]{1};
//        merge(nums1, 1, new int[]{}, 0);

        int[] nums1 = new int[]{4,5,6,0,0,0};
        merge2(nums1, 3, new int[]{1,2,3}, 3);


        for (int i : nums1) {
            System.out.print(i + " ");
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int i = 0, j = 0;
        while (i < m) {
            if (nums2[j] < nums1[i]) {
                nums2[j] += nums1[i];
                nums1[i] = nums2[j] - nums1[i];
                nums2[j] = nums2[j] - nums1[i];
            }
            i++;
        }

        for (int k = 0; k < n; k++) {
            nums1[i + k] = nums2[k];
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
