package question;

/**
 * question
 * LeetCode
 * 2018.10.25.16:51
 * <p>
 * 917. Reverse Only Letters
 * https://leetcode.com/problems/reverse-only-letters/
 *
 * @author : artairs
 */
class ReverseOnlyLetters {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(reverseOnlyLetters("ab-cd"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String reverseOnlyLetters(String S) {

        char[] strings = S.toCharArray();
        int start = 0, end = strings.length - 1;

        while (start < end) {
            while (start < S.length() - 1 && !isLetter(strings[start])) {
                start++;
            }

            while (end > 0 && !isLetter(strings[end])) {
                end--;
            }


            if(start > end){
                break;
            }

            char ex = strings[start];
            strings[start] = strings[end];
            strings[end] = ex;

            start++;
            end--;
        }

        return new String(strings);
    }


    private static boolean isLetter(char c) {
        return (c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a');
    }

}
