package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午6:12
 *
 * 389. Find the Difference
 * https://leetcode.com/problems/find-the-difference/description/
 *
 * @author : rick
 */
class FindTheDifference {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findTheDifference("abcd","abcde"));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static char findTheDifference(String s, String t) {

        int[] letter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            letter[t.charAt(i) - 'a'] --;
        }

        for (int i = 0; i < letter.length; i++) {
            if(letter[i] != 0){
                return (char) ('a' + i);
            }
        }

        return 0;
    }

}
