package question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.27.下午5:43
 *
 * 821. Shortest Distance to a Character
 * https://leetcode.com/problems/shortest-distance-to-a-character/description/
 *
 * @author : rick
 */
class ShortestDistanceToACharacter {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        for (int i : shortestToChar("loveleetcode",'e')) {
            System.out.println(i);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] shortestToChar(String S, char C) {

        List<Integer> chars = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                chars.add(i);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            if (chars.contains(i)) {
                result.add(0);
            } else {
                chars.add(i);
                Collections.sort(chars);
                int index = chars.indexOf(i);
                int left, right;
                if (index == 0) {
                    left = -20000;
                    right = chars.get(index + 1);
                } else if (index == chars.size() - 1) {
                    left = chars.get(index - 1);
                    right = 20000;
                } else {
                    left = chars.get(index - 1);
                    right = chars.get(index + 1);
                }

                int distance = Math.min(i - left, right - i);

                result.add(distance);

                chars.remove((Integer)i);
            }
        }

        int[] d = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            d[i] = result.get(i);
        }
        return d;
    }

}
