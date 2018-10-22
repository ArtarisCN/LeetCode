package question;

/**
 * question
 * LeetCode
 * 2018.10.19.18:07
 * <p>
 * 345. Reverse Vowels of a String
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * @author : artairs
 */
class ReverseVowelsOfAString {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(reverseVowels("aA"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int start = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();

        while (start < end) {
            while (start < s.length() && !isAEIOU(chars[start])) {
                if (start == end) {
                    break;
                }
                start++;
            }

            if (start == end) {
                break;
            }

            while (end > 0 && !isAEIOU(chars[end])) {
                end--;
            }

            if(end < 0 || start >= chars.length || start == end){
                break;
            }

            chars[end] += chars[start];
            chars[start] = (char) (chars[end] - chars[start]);
            chars[end] -= chars[start];

            start++;
            end--;
        }
        return new String(chars);
    }

    private static boolean isAEIOU(char c) {
        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u' ||
                c == 'A' ||
                c == 'E' ||
                c == 'I' ||
                c == 'O' ||
                c == 'U';
    }

}
