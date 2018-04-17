package question;

/**
 * question
 * LeetCode
 * 2018.04.17.下午5:00
 *
 * @author : rick
 */
class PalindromeNumber {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1001));

    }


    public static boolean isPalindrome(int x) {
        return isPalindromeWithoutConverteString(x, getIntegerLenght(x));
    }


    public static boolean isPalindromeWithoutConverteString(int x, int length) {
        if (x < 0) {
            return false;
        }

        if (length == getIntegerLenght(x)) {
            if (x > 100) {
                int left = x / ((int) Math.pow(10, (getIntegerLenght(x) - 1)));
                int right = x % 10;

                int newNumber = x / 10;


                return left == right && isPalindromeWithoutConverteString(newNumber % ((int) Math.pow(10, (getIntegerLenght(newNumber) - 1))), length - 2);
            }

            if (x == 10) {
                return false;
            } else if (x > 10) {
                return x % 11 == 0;
            } else {
                return true;
            }
        } else if (length > getIntegerLenght(x)) {
            int right = x % 10;
            if (right == 0) {
                return isPalindromeWithoutConverteString(x / 10, length - 2);
            }

            return false;
        }

        return true;
    }


    private static int getIntegerLenght(int x) {
        int v = Math.abs(x);
        if (v == 0) {
            return 0;
        }
        return (int) (Math.log(v) / Math.log(10)) + 1;
    }
}
