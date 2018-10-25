package question;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.10.25.18:16
 * <p>
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 *
 * @author : artairs
 */
class SortArrayByParity {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfArray(sortArrayByParity(new int[]{1,3}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] sortArrayByParity(int[] A) {
        if (A.length < 1) {
            return A;
        }

        int start = 0, end = A.length - 1;
        while (end > start) {
            while (end > 0 && A[end] % 2 == 1) {
                end--;
            }

            while (start < A.length && A[start] % 2 == 0) {
                start++;
            }


            if (end <= start) {
                return A;
            }

            A[start] = A[start] + A[end];
            A[end] = A[start] - A[end];
            A[start] = A[start] - A[end];
        }

        return A;
    }


}
