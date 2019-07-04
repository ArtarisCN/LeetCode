package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.04.18.下午3:22
 *
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 * @author : rick
 */
class ValidPalindrome {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isPalindrome2(String s) {
        s = s.toUpperCase();
        int start = 0,end = s.length() - 1;
        boolean isPalindrome = true;
        while (start < end){
            while (invalid(s.charAt(start)) && start < end) {
                start++;
            }
            while (invalid(s.charAt(end)) && start < end) {
                end--;
            }
            if(s.charAt(start) != s.charAt(end) ){
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        return isPalindrome;
    }

    public static boolean invalid(char c){
        return (c < 'A' || c > 'Z') && (c < '0' || c > '9');
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        List<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            aChar = getCharacterType(aChar);

            if (aChar != '#') {
                characters.add(aChar);
            }
        }

        for (int i = 0; i < characters.size() / 2; i++) {
            if (!characters.get(i).equals(characters.get(characters.size() - 1 - i))) {
                return false;
            }
        }

        return true;
    }

    private static char getCharacterType(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
            return c;
        } else if (c >= 'a' && c <= 'z') {
            return (char) (c - ('a' - 'A'));
        } else {
            return '#';
        }
    }
}
