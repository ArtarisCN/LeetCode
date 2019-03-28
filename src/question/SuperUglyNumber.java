package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2019.03.28.17:11
 *
 * 313. Super Ugly Number
 * https://leetcode.com/problems/super-ugly-number/
 *
 * @author : artairs
 */
class SuperUglyNumber {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[] primes = new int[]{2,7,13,19};
        System.out.println(nthSuperUglyNumber(12,primes));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {

        int num[] = new int[primes.length];
        List<Integer> uglyNum = new ArrayList<>();
        uglyNum.add(1);
        while (-- n > 0){
            int thisUgly = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {
                thisUgly = Math.min(thisUgly,uglyNum.get(num[i]) * primes[i]);
            }

            for (int i = 0; i < primes.length; i++) {
                if (thisUgly == uglyNum.get(num[i]) * primes[i])
                    ++num[i];
            }

            uglyNum.add(thisUgly);
        }
        return uglyNum.get(uglyNum.size() - 1);
    }

}
