package question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.10.29.18:22
 *
 * 819. Most Common Word
 * https://leetcode.com/problems/most-common-word/
 *
 * @author : artairs
 */
class MostCommonWord {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(mostCommonWord("Bob. hIt, baLl", new String[]{"hit", "bob"}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        paragraph = paragraph.replace("!", " ")
                .replace("?", " ")
                .replace(".", " ")
                .replace(";", " ")
                .replace(",", " ")
                .replace("'", " ").toLowerCase();

        String[] words = paragraph.split(" ");
        Map<String, Integer> times = new HashMap<>();
        int maxTimes = 0;
        String maxTimesWord = null;
        for (String word : words) {
            word = word.trim();
            if ("".equals(word) || bannedList.contains(word)) {
                continue;
            }

            int time;
            if (times.containsKey(word)) {
                time = times.get(word) + 1;
            } else {
                time = 1;
            }
            times.put(word, time);
            if (time > maxTimes) {
                maxTimes = time;
                maxTimesWord = word;
            }
        }
        return maxTimesWord;
    }
}
