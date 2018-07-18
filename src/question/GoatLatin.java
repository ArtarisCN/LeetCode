package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.18.下午6:10
 * <p>
 * 824. Goat Latin
 * https://leetcode.com/problems/goat-latin/description/
 *
 * @author : rick
 */
class GoatLatin {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(toGoatLatin("I speak Goat Latin"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String toGoatLatin(String S) {
        if (S == null || S.length() == 0){
            return S;
        }

        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        String ma = "ma";

        List<String> temp = Arrays.asList(S.split(" "));
        ArrayList<String> letters = new ArrayList<>(temp);


        for (int i = 0; i < letters.size(); i++) {

            StringBuilder sb = new StringBuilder(letters.get(i));

            if (vowels.contains(letters.get(i).charAt(0))) {
                sb.append(ma);
            } else {
                char c = letters.get(i).charAt(0);
                sb.deleteCharAt(0);
                sb.append(String.valueOf(c));
                sb.append(ma);
            }

            for (int j = 0; j < i + 1; j++) {
                sb.append("a");
            }

            letters.set(i, sb.toString());
        }

        StringBuilder sb = new StringBuilder(letters.get(0));

        for (int i = 1; i < letters.size(); i++) {
            sb.append(" ");
            sb.append(letters.get(i));
        }

        return sb.toString();

    }

}
