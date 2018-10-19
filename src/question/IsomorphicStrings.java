package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.10.19.14:53
 * <p>
 * 205. Isomorphic Strings
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 *
 * @author : artairs
 */
class IsomorphicStrings {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(isIsomorphic("ab","aa"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s == null && t == null){
            return true;
        }

        if((s == null || t == null) || (s.length() != t.length())){
            return false;
        }

        Map<Character, Character> mapA = new HashMap<>();
        Map<Character, Character> mapB = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mapA.get(s.charAt(i)) != null) {
                if (mapA.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }

            if (mapB.get(t.charAt(i)) != null) {
                if (mapB.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }

            mapA.put(s.charAt(i), t.charAt(i));
            mapB.put(t.charAt(i), s.charAt(i));

            char a = s.charAt(i), b = t.charAt(i);

            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == a && t.charAt(j) != b) {
                    return false;
                }
            }
        }

        return true;
    }

}
