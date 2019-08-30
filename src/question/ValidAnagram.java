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
            value.put(s.charAt(i), value.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (value.getOrDefault(t.charAt(i), 0) - 1 < 0) {
                return false;
            } else {
                value.put(t.charAt(i), value.get(t.charAt(i)) - 1);
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] value = new int[26];
        for (int i = 0; i < s.length(); i++) {
            value[s.charAt(i) - 'a'] ++;
            value[t.charAt(i) - 'a'] --;
        }

        for (int i : value) {
            if(i != 0){
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram3(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] value = new int[26];
        char chars[] = s.toCharArray();
        char chart[] = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            value[chars[i] - 'a'] ++;
            value[chart[i] - 'a'] --;
        }

        for (int i : value) {
            if(i != 0){
                return false;
            }
        }

        return true;
    }



}
