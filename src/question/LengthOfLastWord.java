package question;

/**
 * question
 * LeetCode
 * 2018.07.13.上午9:51
 * <p>
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * @author : rick
 */
class LengthOfLastWord {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(lengthOfLastWord2("a ")));
        System.out.println(String.valueOf(lengthOfLastWord2(" world")));
        System.out.println(String.valueOf(lengthOfLastWord2("world ")));
        System.out.println(String.valueOf(lengthOfLastWord2("world")));
        System.out.println(String.valueOf(lengthOfLastWord2("hello world")));
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int lengthOfLastWord(String s) {
        if (s == null || " ".equals(s)) {
            return 0;
        }

        int start = -1, end = 0;

        char[] chars = s.trim().toCharArray();

        for (int i = 0; i < chars.length; i++, end++) {
            if (end == chars.length) {
                break;
            }

            if (chars[end] == ' ') {
                if (end + 1 == chars.length) {
                    return 0;
                } else if (chars[end + 1] != ' ') {
                    start = end;
                }
            }
        }

        if (start == -1) {
            return chars.length;
        } else {
            return chars.length - start - 1;
        }
    }

    public static int lengthOfLastWord2(String s) {
        if (s == null || " ".equals(s) || s.length() == 0) {
            return 0;
        }

        boolean findSpace = false;
        int result = 0;
        s = s.trim();
        for (int length = s.length() - 1; length >= 0; length--) {
            char c = s.charAt(length);
            result++;

            if (c == ' ') {
                if (length == s.length() - 1) {
                    return 0;
                }
                findSpace = true;
                break;
            }
        }

        return findSpace?result - 1:result;
    }


}
