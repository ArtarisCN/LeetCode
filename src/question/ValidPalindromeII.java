package question;

/**
 * question
 * LeetCode
 * 2018.04.18.下午3:52
 * <p>
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * @author : rick
 */
class ValidPalindromeII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(validPalindrome("ac"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean validPalindrome(String s) {

        if (s.length() < 2) {
            return true;
        }

        char[] chars = s.toCharArray();

        for (int i = 0, j = chars.length - 1; j - i > 0; i++, j--) {

            if (chars[i] != chars[j]) {
                char[] s1 = new char[j - i], s2 = new char[j - i];

                System.arraycopy(chars, i, s1, 0, j - i);
                System.arraycopy(chars, i + 1, s2, 0, j - i);
                return isPalindrome2(s1) || isPalindrome2(s2);
            }
        }

        return true;

    }

    public static boolean isPalindrome2(char[] s) {
        for (int i = 0, j = s.length - 1; j - i > 0; i++, j--) {
            if (s[i] != s[j]) {
                return false;
            }
        }

        return true;
    }

    public static boolean validPalindrome2(String s) {

        if (s.length() < 2) {
            return true;
        }

        char[] chars = s.toCharArray();


        return isPalindrome(chars, true, 0, chars.length - 1);

    }


    public static boolean isPalindrome(char[] s, boolean allowDelete, int startIndex, int endIndex) {

        if ((endIndex - startIndex) < 2) {
            return true;
        }

        if (s[startIndex] == s[endIndex]) {
            return isPalindrome(s, allowDelete, ++startIndex, --endIndex);
        } else if (allowDelete) {
            return isPalindrome(s, false, startIndex + 1, endIndex) || isPalindrome(s, false, startIndex, endIndex - 1);
        } else {
            return false;
        }
    }
}
