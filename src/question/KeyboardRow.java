package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.27.下午6:29
 * <p>
 * 500. Keyboard Row
 * https://leetcode.com/problems/keyboard-row/description/
 *
 * @author : rick
 */
class KeyboardRow {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        String[] result = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});

        for (String s : result) {
            System.out.println(s);
        }


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String[] findWords(String[] words) {
        char[][] letter = new char[][]{{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'}, {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'}, {'z', 'x', 'c', 'v', 'b', 'n', 'm'}};

        List<Character> letter1 = new ArrayList<>();
        for (char c : letter[0]) {
            letter1.add(c);
        }

        List<Character> letter2 = new ArrayList<>();
        for (char c : letter[1]) {
            letter2.add(c);
        }

        List<Character> letter3 = new ArrayList<>();
        for (char c : letter[2]) {
            letter3.add(c);
        }

        List<String> result = new ArrayList<>();


        for (String word : words) {

            String newWord = word.toLowerCase();

            List<Character> currentLetter = null;

            if (letter1.contains(newWord.charAt(0))) {
                currentLetter = letter1;
            } else if (letter2.contains(newWord.charAt(0))) {
                currentLetter = letter2;
            } else if (letter3.contains(newWord.charAt(0))) {
                currentLetter = letter3;
            }

            boolean success = true;

            for (int i = 1; i < newWord.length(); i++) {
                if (!currentLetter.contains(newWord.charAt(i))) {
                    success = false;
                    break;
                }
            }

            if (success) {
                result.add(word);
            }
        }

        return result.toArray(new String[result.size()]);

    }
}
