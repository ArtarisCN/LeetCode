package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.07.20.下午2:31
 * <p>
 * 172. Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 *
 * @author : rick
 */
class FactorialTrailingZeroes {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        System.out.println(trailingZeroes2(1808548329));
//        System.out.println(new FactorialTrailingZeroes().trailingZeroes(120));

//        System.out.println(new FactorialTrailingZeroes().trailingZeroes2(120));
//        System.out.println(new FactorialTrailingZeroes().trailingZeroes3(120));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(1808548325));
//        System.out.println(new FactorialTrailingZeroes().trailingZeroes(1808548329));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public int trailingZeroes3(int n) {
        long sum = 1;
        int count = 0;
        String s = String.valueOf(n);
        for (int i = n; i > 0; i--) {
            if (i % 2 != 0 && i % 5 != 0) {
                continue;
            }
            sum *= i;
            while (sum % 10 == 0) {
                count++;
                sum /= 10;
            }
            sum %= Math.pow(10, s.length());
//            System.out.println("i = " + i + " sum = " + sum);
        }
        return count;
    }

    /**
     * 超时
     *
     * @param n
     * @return
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int trailingZeroes(int n) {
        int count5 = 0;
        int x = n;
        for (int i = n; i > 0; i-=5) {
            count5 += map.getOrDefault(i, count(i));

        }
        System.out.println(map.size());
        return count5;
    }

    private int count(int x) {
        if (map.containsKey(x)) {
            return map.get(x);
        } else {
            if ((x % 5) != 0) {
                return 0;
            }
            int next = x / 5;
            int nextResult = map.getOrDefault(next, count(next));
            map.put(x, nextResult + 1);
            return nextResult + 1;
        }
    }


    public static int trailingZeroes2(int n) {
        int count5 = 0;
        while (n > 0) {
            int k = n / 5;
            count5 += k;
            n = k;
        }
        return count5;
    }
}
