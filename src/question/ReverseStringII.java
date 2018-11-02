package question;

/**
 * question
 * LeetCode
 * 2018.11.02.17:51
 * <p>
 * 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/
 *
 * @author : artairs
 */
class ReverseStringII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(reverseStr("abcabcabcabcabca", 3));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String reverseStr(String s, int k) {
        char[] letter = s.toCharArray();

        for (int i = 0; i < letter.length; i++) {
            if (i + k > letter.length) {
                for (int j = i; j < (letter.length - i) / 2 + i; j++) {
                    letter[letter.length - 1 - j + i] = (char) (letter[letter.length - 1 - j + i] + letter[j]);
                    letter[j] = (char) (letter[letter.length - 1 - j + i] - letter[j]);
                    letter[letter.length - 1 - j + i] = (char) (letter[letter.length - 1 - j + i] - letter[j]);
                }
                break;
            } else {
                for (int j = i; j < i + k / 2; j++) {
                    letter[2 * i + k - 1 - j] = (char) (letter[2 * i + k - 1 - j] + letter[j]);
                    letter[j] = (char) (letter[2 * i + k - 1 - j] - letter[j]);
                    letter[2 * i + k - 1 - j] = (char) (letter[2 * i + k - 1 - j] - letter[j]);
                }
                i += 2 * k - 1;
            }
        }

        return new String(letter);
    }
}
