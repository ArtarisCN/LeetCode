package question;

/**
 * question
 * LeetCode
 * 2019.05.23.09:32
 * <p>
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 *
 * @author : artairs
 */
class ClimbingStairs {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(climbStairs(44));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int climbStairs(int n) {
        int[] climbMap = new int[n];
        for (int i = 0; i < n; i++) {
            climbMap[i] = -1;
        }
        return calculateStair(n, climbMap);
    }

    public static int climbStairs2(int n) {
        int[] climbMap = new int[n + 1];
        climbMap[0] = 1;
        climbMap[1] = 1;

        for (int i = 2; i < climbMap.length; i++) {
            climbMap[i] = climbMap[i - 1] + climbMap[i - 2];
        }
        return climbMap[n];
    }

    public static int climbStairs3(int n) {
        int pre = 1;
        int next = 1;

        int result = next;
        for (int i = 2; i < n + 1; i++) {
            result = pre + next;

            pre = next;
            next = result;
        }
        return result;
    }

    public static int calculateStair(int stair, int[] memo) {
        if (stair == 0 || stair == 1) {
            return 1;
        }

        int result = 0;
        if (memo[stair - 1] != -1) {
            result += memo[stair - 1];
        } else {
            memo[stair - 1] = calculateStair(stair - 1, memo);
            result += memo[stair - 1];
        }

        if (memo[stair - 2] != -1) {
            result += memo[stair - 2];
        } else {
            memo[stair - 2] = calculateStair(stair - 2, memo);
            result += memo[stair - 2];
        }
        return result;
    }

}
