package question;

/**
 * question
 * LeetCode
 * 2018.10.23.10:29
 * <p>
 * 374. Guess Number Higher or Lower
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 *
 * @author : artairs
 */
class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(guessNumber(2126753390));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int guessNumber(int n) {
        long start = 1, end = n;
        long mid = (start + end) / 2;
        while (guess((int) mid) != 0) {
            int guess = guess((int) mid);
            switch (guess) {
                case 1:
                    start = mid + 1;
                    break;
                case -1:
                    end = mid - 1;
                    break;
            }
            mid = (start + end) / 2;
        }

        return (int) mid;
    }

    private static int guess(int num) {
        return Integer.compare(1702766719, num);
    }


}
