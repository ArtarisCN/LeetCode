package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.07.27.上午10:56
 *
 * 804. Unique Morse Code Words
 * https://leetcode.com/problems/unique-morse-code-words/description/
 *
 * @author : rick
 */
class UniqueMorseCodeWords {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int uniqueMorseRepresentations(String[] words) {

        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Map<String,Integer> result = new HashMap<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                sb.append(morse[word.charAt(i) - 'a']);
            }

            if (result.containsKey(sb.toString())){
                result.put(sb.toString(),result.get(sb.toString()) + 1);
            } else {
                result.put(sb.toString(), 1);
            }

        }

        return result.keySet().size();
    }

}
