package question;

import java.util.Stack;

/**
 * question
 * LeetCode
 * 2018.10.17.11:00
 * <p>
 * 20.Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author : artairs
 */
class ValidParentheses {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(isValid("{[]}"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }

            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    continue;
                case ']':
                    if (stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                        continue;
                    }
                case '}':
                    if (stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                        continue;
                    }
                case ')':
                    if (stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                        continue;
                    }
            }
        }

        return stack.empty();
    }
}
