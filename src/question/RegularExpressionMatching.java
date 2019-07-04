package question;

import java.util.LinkedList;
import java.util.Stack;

/**
 * question
 * LeetCode
 * 2019.05.13.17:03
 * <p>
 * 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * @author : artairs
 */
class RegularExpressionMatching {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(isMatch("aaa", "aaaa"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isMatch(String s, String p) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }

        int index = 0;
        while (index < p.length() && !stack.isEmpty()) {
            if (p.charAt(index) == '.') {
                if (index + 1 < p.length() && p.charAt(index + 1) == '*') {
                    return true;
                } else {
                    stack.pop();
                    index++;
                }
            } else {
                if (stack.peek() == p.charAt(index)) {
                    if (index + 1 < p.length() && p.charAt(index + 1) == '*') {
                        stack.pop();
                        while (!stack.isEmpty() &&  stack.peek() == p.charAt(index)) {
                            stack.pop();
                        }
                        index += 2;
                    } else {
                        stack.pop();
                        index++;
                    }
                } else {
                    if (index + 1 < p.length() && p.charAt(index + 1) == '*') {
                        index += 2;
                    } else {
                        return false;
                    }
                }
            }
        }

        return index >= p.length() && stack.isEmpty();
//
//        for (int i = 0; i < s.length(); i++) {
//            queue.isPoped(s.charAt())
//        }
//
//        int matchIndex = 0;
//        for (int i = 0; i < s.length(); i++) {
//            queue.addLast(s.charAt(i));
//            if (matchIndex < p.length() && p.charAt(matchIndex + 1) == '*') {
//                switch (match(queue, p.charAt(matchIndex), p.charAt(matchIndex + 1))) {
//                    case 0:
//                        matchIndex += 2;
//                        i--;
//                        continue;
//                    case 1:
//                        continue;
//                    case -1:
//                        return false;
//                }
//            } else {
//                switch (match(queue, p.charAt(matchIndex))) {
//                    case -1:
//                        return false;
//                    case 0:
//                        matchIndex++;
//                }
//            }
//        }
//        return true;
    }

    /**
     * @return -1:不匹配
     * 0：匹配
     * 1：匹配并可以继续匹配
     */
    public static int match(LinkedList<Character> queue, char c) {
        switch (c) {
            case '.':
                if (queue.size() > 0) {
                    queue.pollFirst();
                    return 0;
                } else {
                    return -1;
                }
            case '*':
                if (queue.size() > 0) {
                    char firstE = queue.peekFirst();
                    boolean success = true;
                    for (Character character : queue) {
                        success = character == firstE;
                        if (!success) {
                            break;
                        }
                    }
                    return success ? 1 : -1;
                } else {
                    return -1;
                }
            default:
                if (queue.size() > 0) {
                    boolean success = c == queue.pollFirst();
                    if (success) {
                        return 0;
                    }
                }
                return -1;
        }
    }

    public static int match(LinkedList<Character> queue, char c, char c2) {
        if (c2 != '*' || queue.size() == 0) {
            return -1;
        }

        char firstE = queue.peekFirst();
        if (firstE == c) {
            boolean clean = false;
            for (int i = 1; i < queue.size(); i++) {
                if (queue.get(i) != c) {
                    int j = i - 1;
                    while (j >= 0) {
                        queue.removeFirst();
                    }
                    clean = true;
                }
            }
            return clean ? 0 : 1;
        }
        return 0;
    }

}
