package question;

/**
 * question
 * LeetCode
 * 2017/7/26.12:42
 * <p>
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 *
 * @author : artairs
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(longestPalindrome("abccccdd"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] letters = new int[52];
        int result = 0;
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {

                if (letters[aChar - 'a'] == 1) {
                    letters[aChar - 'a'] = 0;
                    result += 2;
                } else if (letters[aChar - 'a'] == 0) {
                    letters[aChar - 'a'] = 1;
                }

            } else if (aChar >= 'A' && aChar <= 'Z') {
                if (letters[aChar - 'A' + 26] == 1) {
                    letters[aChar - 'A' + 26] = 0;
                    result += 2;
                } else if (letters[aChar - 'A' + 26] == 0) {
                    letters[aChar - 'A' + 26] = 1;
                }
            }
        }

        if (result < s.length()) {
            return ++result;
        }

        return result;
    }

}