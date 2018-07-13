package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.07.13.下午6:03
 * <p>
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * @author : rick
 */
class ValidAnagram {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(isAnagram("aacc", "ccac")));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> value = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (value.containsKey(c)) {
                value.put(c, value.get(c) + 1);
            } else {
                value.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (value.containsKey(c)) {
                if (value.get(c) == 1) {
                    value.remove(c);
                } else {
                    value.put(c, value.get(c) - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
