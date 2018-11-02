package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.11.02.15:04
 * <p>
 * 748. Shortest Completing Word
 * https://leetcode.com/problems/shortest-completing-word/
 *
 * @author : artairs
 */
class ShortestCompletingWord {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(shortestCompletingWord("Ar16259", new String[]{"nature", "though", "party", "food", "any", "democratic", "building", "eat", "structure", "our"}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> letterMap = calculateLetter(licensePlate);
        String result = null;

        for (String word : words) {
            Map<Character, Integer> wordLetter = calculateLetter(word);
            boolean find = true;
            for (Map.Entry<Character, Integer> characterIntegerEntry : letterMap.entrySet()) {
                if (!wordLetter.containsKey(characterIntegerEntry.getKey()) || wordLetter.get(characterIntegerEntry.getKey()) < characterIntegerEntry.getValue()) {
                    find = false;
                    break;
                }
            }

            if (!find) {
                continue;
            }

            if (result == null || result.length() > word.length()) {
                result = word;
            }
        }

        return result;
    }


    private static Map<Character, Integer> calculateLetter(String letter) {
        letter = letter.toUpperCase();
        char[] letters = letter.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : letters) {
            if (c >= 'A' && c <= 'Z') {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }

        return map;
    }

}
