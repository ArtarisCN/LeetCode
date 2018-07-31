package question;

/**
 * question
 * LeetCode
 * 2018.07.30.23:57
 * <p>
 * 693. Binary Number with Alternating Bits
 * https://leetcode.com/problems/binary-number-with-alternating-bits/description/
 *
 * @author : artaris
 */
class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        System.out.println(hasAlternatingBits(10));

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean hasAlternatingBits(int n) {

        if (n % 2 == 0) {
            n >>= 1;
        }
        while (n >= 1) {
            n--;
            if (n % 4 != 0) {
                return false;
            }

            n /= 4;
        }
        return true;
    }

    public static boolean hasAlternatingBitsMax(int n) {
        /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
        */

        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }
}
