package question;

/**
 * question
 * LeetCode
 * 2018.07.27.下午4:44
 *
 * 557. Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * @author : rick
 */
class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(reverseWords("Let's take LeetCode contest"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String reverseWords(String s) {

        String[] split = s.split(" ");

        StringBuilder result = new StringBuilder(split[0]);

        result.reverse();

        for (int i =1; i < split.length; i++) {
            result.append(" ");
            result.append(new StringBuilder(split[i]).reverse().toString());
        }

        return result.toString();
    }
}
