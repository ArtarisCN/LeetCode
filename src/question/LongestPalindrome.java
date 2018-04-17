package question;

/**
 * Created by rick on 2017/7/26.
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int length = s.length();

        if (length < 2)
            return s;

        if (length == 2) {
            if (isPalindrome(s))
                return s;
            else
                return s.substring(0, 1);
        }

        int maxLength = 1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            if (length - i - 1 < maxLength)
                break;


            for (int j = length - 1; j > i; j--) {
                if (j - i < maxLength)
                    break;

                if (isPalindrome(s.substring(i, j + 1))) {
                    maxLength = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }


    private static boolean isPalindrome(String s) {
        int length = s.length();
        if (length < 2)
            return true;

        if (length == 2)
            return s.charAt(0) == s.charAt(length - 1);

        return s.charAt(0) == s.charAt(length - 1) && isPalindrome(s.substring(1, length - 1));
    }

    public static String longestPalindromeManacher(String s) {

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {

        }


        return null;

    }

}