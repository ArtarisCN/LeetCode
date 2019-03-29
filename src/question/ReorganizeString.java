package question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * question
 * LeetCode
 * 2019.03.28.17:27
 * <p>
 * 767. Reorganize String
 * https://leetcode.com/problems/reorganize-string/
 *
 * @author : artairs
 */
class ReorganizeString {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(reorganizeString("vvvlo"));
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("abbabbaaab"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String reorganizeString(String S) {

        List<Entry> list = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            list.add(new Entry((char) ('a' + i)));
        }

        for (int i = 0; i < S.length(); i++) {
            list.get(S.charAt(i) - 'a').num++;
        }

        Collections.sort(list);

        if (S.length() % 2 == 0) {
            if (list.get(list.size() - 1).num > (S.length() / 2)) {
                return "";
            }
        } else {
            if (list.get(list.size() - 1).num > (S.length() / 2 + 1)) {
                return "";
            }
        }

        int index = 0;
        char[] result = new char[S.length()];

        for (int i = list.size() - 1; i >= 0; i--) {
            Entry e = list.get(i);
            int n = e.num;
            if (n == 0) {
                break;
            }
            while (n-- > 0) {
                result[index] = e.character;
                index += 2;
                if (index >= S.length()) {
                    index = 1;
                }
            }
        }

        return new String(result);

    }


    private static class Entry implements Comparable<Entry> {
        private char character;
        private int num;

        public Entry(char character) {
            this.character = character;
        }

        @Override
        public int compareTo(Entry o) {
            return this.num - o.num;
        }
    }


}
