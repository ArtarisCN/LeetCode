package question;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.10.30.10:58
 * <p>
 * 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/
 *
 * @author : artairs
 */
class LetterCasePermutation {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfArrayList(letterCasePermutation("a1b2"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();


        if (S == null || S.length() == 0) {
            result.add("");
            return result;
        }
        S = S.toUpperCase();
        char[] chars = S.toCharArray();
        List<StringBuilder> temp = new ArrayList<>();
        temp.add(new StringBuilder());

        for (char aChar : chars) {
            if (aChar <= '9' && aChar >= '0') {
                for (StringBuilder stringBuilder : temp) {
                    stringBuilder.append(aChar);
                }
            } else if (aChar <= 'Z' && aChar >= 'A') {
                List<StringBuilder> otherList = new ArrayList<>();
                for (StringBuilder stringBuilder : temp) {
                    StringBuilder other = new StringBuilder(stringBuilder);
                    other.append((char) (aChar + ('a' - 'A')));
                    otherList.add(other);
                    stringBuilder.append(aChar);
                }
                temp.addAll(otherList);
            }
        }

        for (StringBuilder stringBuilder : temp) {
            result.add(stringBuilder.toString());
        }

        return result;
    }
}
