package util;

/**
 * util
 * LeetCode
 * 2019.06.26.11:12
 *
 * @author : artairs
 */
class CombiArrange {

    public static int arragement(int n, int m) {
        if (n < m) {
            System.out.println("n>m，输入错误");
        }
        int mul = 1;
        for (int i = n - m + 1; i <= n; i++) {
            mul *= i;
        }
        return mul;
    }

    public static int combination(int n, int m) {
        if (n < m) {
            System.out.println("n>m，输入错误");
        }
        int factM = 1;
        for (int i = 1; i <= m; i++) {
            factM *= i;
        }
        int a = arragement(n, m);
        return a / factM;
    }
}
