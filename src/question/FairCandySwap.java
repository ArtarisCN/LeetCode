package question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.09.29.10:55
 * <p>
 * 888. Fair Candy Swap
 * https://leetcode.com/problems/fair-candy-swap/description/
 *
 * @author : artairs
 */
class FairCandySwap {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printf(fairCandySwap(new int[]{2}, new int[]{1, 3}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        List<Integer> aList = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<Integer> bList = Arrays.stream(B).boxed().collect(Collectors.toList());

        int sum = 0, sumA = 0, sumB = 0, min = 0;
        int[] result = new int[2];

        for (int i : A) {
            sumA += i;
        }

        for (int i : B) {
            sumB += i;
        }

        sum = (sumA + sumB) / 2;

        if (sumA > sum) {
            min = sumA - sum;

            for (int i : A) {
                if (bList.contains(i - min)) {
                    result[0] = i;
                    result[1] = i - min;
                    break;
                }
            }

        } else {
            min = sumB - sum;

            for (int i : B) {
                if (aList.contains(i - min)) {
                    result[1] = i;
                    result[0] = i - min;
                    break;
                }
            }
        }


        return result;
    }


}
