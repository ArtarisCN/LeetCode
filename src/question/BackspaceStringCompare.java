package question;

import java.util.Stack;

/**
 * question
 * LeetCode
 * 2018.10.29.16:47
 * <p>
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * @author : artairs
 */
class BackspaceStringCompare {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>(), tStack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (sStack.size() != 0) {
                    sStack.pop();
                }
            } else {
                sStack.push(c);
            }
        }

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if (tStack.size() != 0) {
                    tStack.pop();
                }
            } else {
                tStack.push(c);
            }
        }

        if (tStack.size() != sStack.size()) {
            return false;
        }

        while (sStack.size() != 0) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }

        return true;
    }
}
