package question;

/**
 * question
 * LeetCode
 * 2019.05.31.10:50
 * <p>
 * 91. Decode Ways
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * @author : artairs
 */
class DecodeWays {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(numDecodings2("110"));
        System.out.println(numDecodings2("00"));
        System.out.println(numDecodings2("271"));
        System.out.println(numDecodings2(""));
        System.out.println(numDecodings2("0"));
        System.out.println(numDecodings2("1"));
        System.out.println(numDecodings2("12"));
        System.out.println(numDecodings2("109"));
        System.out.println(numDecodings2("227"));
        System.out.println(numDecodings2("226"));
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] result = new int[s.length() + 1];

        result[0] = 1;
        result[1] = s.charAt(0) > '0'?1:0;

        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));

            result[i] = 0;
            if (first >= 1 && first <= 9)
                result[i] += result[i -1];
            if (second >= 10 && second <= 26)
                result[i] += result[i -2];
        }

        return result[s.length()];
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] result = new int[s.length() + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        result[0] = 1;
        result[1] = s.charAt(0) > '0'?1:0;

        return getNumDecodings(s, s.length(), result);
    }


    private static int getNumDecodings(String s, int index, int[] memo) {

        if (memo[index] >= 0) {
            return memo[index];
        }
        int first = Integer.valueOf(s.substring(index - 1, index));
        int second = Integer.valueOf(s.substring(index - 2, index));
        memo[index] = 0;
        if (first >= 1 && first <= 9)
            memo[index] += getNumDecodings(s, index - 1, memo);
        if (second >= 10 && second <= 26)
            memo[index] += getNumDecodings(s, index - 2, memo);

        return memo[index];
    }
}
