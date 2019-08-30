package question;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2019.05.08.10:19
 *
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 *
 * @author : artairs
 */
class ReverseString {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        char[] s =  new char[]{'a','b','c','d','e'};
        reverseString(s);
        PrintUtils.printf(s);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void reverseString(char[] s) {
        int start = 0,end = s.length- 1;
        while (start < end){
            s[start] = (char) (s[start] + s[end]);
            s[end] = (char) (s[start] - s[end]);
            s[start] = (char) (s[start] - s[end]);

            start ++;
            end --;
        }
    }

}
