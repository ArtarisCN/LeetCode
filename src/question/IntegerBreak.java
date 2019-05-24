package question;

/**
 * question
 * LeetCode
 * 2019.05.24.11:24
 * <p>
 * 343. Integer Break
 * https://leetcode.com/problems/integer-break/
 *
 * @author : artairs
 */
class IntegerBreak {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(integerBreak2(10));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        return integerBreakWithCache(n, new int[n]);
    }

    public static int integerBreakWithCache(int n, int[] cache) {
        if (n == 2) {
            return 1;
        } else if (n < 2) {
            return 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int a = i, b = n - i;
            if (cache[a] == 0) {
                cache[a] = integerBreakWithCache(a, cache);
            }

            if (cache[b] == 0) {
                cache[b] = integerBreakWithCache(b, cache);
            }
            max = Math.max(Math.max(max, Math.max(Math.max(cache[a] * cache[b], cache[a] * b), Math.max(cache[a] * cache[b], cache[b] * a))), a * b);
        }
        return max;
    }

    public static int integerBreak2(int n) {
        if (n == 2)
            return 1;
        else if (n == 3)
            return 2;
        else if (n % 3 == 0)
            return (int) Math.pow(3, n / 3);
        else if (n % 3 == 1)
            return 2 * 2 * (int) Math.pow(3, (n - 4) / 3);
        else
            return 2 * (int) Math.pow(3, n / 3);
    }

}
