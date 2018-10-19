package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.10.19.17:15
 *
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/submissions/
 *
 * @author : artairs
 */
class WordPattern {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(wordPattern("abba", "dog dog dog dog"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }

        if (pattern == null || str == null) {
            return false;
        }

        char[] chars = pattern.toCharArray();
        String[] strList = str.split(" ");
        if (chars.length != strList.length) {
            return false;
        }

        Map<Character, String> mapA = new HashMap<>();
        Map<String, Character> mapB = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (mapA.containsKey(chars[i])) {
                if (!mapA.get(chars[i]).equals(strList[i])) {
                    return false;
                }
                continue;
            }

            if (mapB.containsKey(strList[i])) {
                if (!mapB.get(strList[i]).equals(chars[i])) {
                    return false;
                }
                continue;
            }

            mapA.put(chars[i], strList[i]);
            mapB.put(strList[i], chars[i]);
        }

        return true;
    }
}
