package question;

/**
 * question
 * LeetCode
 * 2018.07.20.下午2:31
 *
 * 172. Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 *
 * @author : rick
 */
class FactorialTrailingZeroes {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(trailingZeroes2(1808548329));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    /**
     * 超时
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {

        int count5 = 0;

        long x = n;

        for (long i = 0; i < x + 1; i = i + 5) {
            if(i == 0){
                continue;
            }
            long num = i;

            while (num % 5 == 0) {
                num /= 5;
                count5++;
            }

        }

        return count5;
    }


    public static int trailingZeroes2(int n) {

        int count5 = 0;

        while (n > 0){
            int k = n /5;
            count5 += k;
            n = k;
        }

        return count5;
    }
}
