package question;

import java.util.HashSet;
import java.util.Set;

/**
 * question
 * LeetCode
 * 2018.11.12.15:06
 *
 * 893. Groups of Special-Equivalent Strings
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/
 *
 * @author : artairs
 */
class GroupsOfSpecialEquivalentStrings {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int numSpecialEquivGroups(String[] A) {
        char[][] matrix = new char[A.length][26];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = '0';
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                if(j % 2== 0) {
                    matrix[i][A[i].charAt(j) - 'a']++;
                } else {

                }
            }
        }

        Set<String> temp = new HashSet<>();
        for (char[] chars : matrix) {
            temp.add(new String(chars));
        }

        return temp.size();
    }

}
