package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.09.29.11:32
 * <p>
 * 884. Uncommon Words from Two Sentences
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 *
 * @author : artairs
 */
class UncommonWordsFromTwoSentences {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        QuestionUtils.printfArray(uncommonFromSentences("apple apple", "banana"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String[] uncommonFromSentences(String A, String B) {
        String[] aList = A.split(" ");
        String[] bList = B.split(" ");

        Map<String, Integer> result = new HashMap<>();
        for (String s : aList) {
            if (result.containsKey(s)) {
                result.put(s, result.get(s) + 1);
            } else {
                result.put(s, 1);
            }
        }
        for (String s : bList) {
            if (result.containsKey(s)) {
                result.put(s, result.get(s) + 1);
            } else {
                result.put(s, 1);
            }
        }

        List<String> ans = new ArrayList<>();

        result.forEach((key, value) -> {
            if (value == 1) {
                ans.add(key);
            }
        });

        return ans.toArray(new String[0]);
    }

}
