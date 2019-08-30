package question;

import java.util.Arrays;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2019.08.09.11:03
 * <p>
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * @author : artairs
 */
class MinCostClimbingStairs {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

//        System.out.println(minCostClimbingStairs(new int[]{10, 15,20}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] costTotal = new int[cost.length + 1];
        Arrays.fill(costTotal, -1);
        int result = climbingStairs(cost, costTotal, cost.length);
        PrintUtils.printf(costTotal);
        return result;
    }

    public static int climbingStairs(int[] cost, int[] costTotal, int index) {
        if (costTotal[index] != -1) {
            return costTotal[index];
        }

        if(index == 1  || index == 0){
            return 0;
        }

        costTotal[index] = Math.min(climbingStairs(cost, costTotal, index - 1) + cost[index - 1], climbingStairs(cost, costTotal, index - 2) + cost[index - 2]);
        return costTotal[index];
    }
}
