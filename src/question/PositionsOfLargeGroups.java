package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.18.下午6:38
 * <p>
 * 830. Positions of Large Groups
 * https://leetcode.com/problems/positions-of-large-groups/description/
 *
 * @author : rick
 */
class PositionsOfLargeGroups {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<List<Integer>> result = largeGroupPositions("abbxxxxzzyyy");

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");


        for (List<Integer> integers : result) {
            System.out.println(integers.get(0) + " " + integers.get(1));
        }
    }


    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            int j = i + 1;

            while (j < S.length() && S.charAt(i) == S.charAt(j)) {
                j++;
            }

            if (j - i >= 3) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j - 1);
                result.add(temp);
            }

            i = j - 1;
        }

        return result;
    }
}
