package question;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.10.25.15:56
 * <p>
 * 922. Sort Array By Parity II
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/description/
 *
 * @author : artairs
 */
class SortArrayByParityII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfArray(sortArrayByParityII(new int[]{4, 2, 5, 7}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] sortArrayByParityII(int[] A) {
        if (A.length < 1) {
            return A;
        }

        int odd = 1, even = 0;
        while (true) {
            while (A[odd] % 2 == 1) {
                if (odd != A.length - 1) {
                    odd += 2;
                } else {
                    break;
                }
            }

            while (A[even] % 2 == 0) {
                if (even != A.length - 2) {
                    even += 2;
                } else {
                    break;
                }
            }


            if (odd == A.length - 1 && even == A.length - 2 && A[even] % 2 == 0 && A[odd] % 2 == 1) {
                return A;
            }

            A[even] = A[even] + A[odd];
            A[odd] = A[even] - A[odd];
            A[even] = A[even] - A[odd];
        }
    }

}
