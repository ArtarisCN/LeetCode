package question;

import static util.QuestionUtils.getIntegerLength;

/**
 * question
 * LeetCode
 * 2018.04.17.下午5:00
 * <p>
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * @author : rick
 */
class PalindromeNumber {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1001));

    }


    public static boolean isPalindrome(int x) {
        return isPalindromeWithoutConverteString(x, getIntegerLength(x));
    }


    public static boolean isPalindromeWithoutConverteString(int x, int length) {
        if (x < 0) {
            return false;
        }

        if (length == getIntegerLength(x)) {
            if (x > 100) {
                int left = x / ((int) Math.pow(10, (getIntegerLength(x) - 1)));
                int right = x % 10;

                int newNumber = x / 10;


                return left == right && isPalindromeWithoutConverteString(newNumber % ((int) Math.pow(10, (getIntegerLength(newNumber) - 1))), length - 2);
            }

            if (x == 10) {
                return false;
            } else if (x > 10) {
                return x % 11 == 0;
            } else {
                return true;
            }
        } else if (length > getIntegerLength(x)) {
            int right = x % 10;
            if (right == 0) {
                return isPalindromeWithoutConverteString(x / 10, length - 2);
            }

            return false;
        }

        return true;
    }



}
