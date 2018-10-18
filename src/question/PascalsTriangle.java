package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.10.18.10:31
 * <p>
 * 118.Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 *
 * @author : artairs
 */
class PascalsTriangle {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        for (List<Integer> integers : generate(1)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<List<Integer>> generate(int numRows) {

        List<Integer> start = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        start.add(1);

        result.add(start);
        numRows--;

        while (numRows > 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            for (int i = 0; i < start.size() - 1; i++) {
                temp.add(start.get(i) + start.get(i + 1));
            }
            temp.add(1);
            result.add(temp);
            start = temp;
            numRows--;
        }

        return result;

    }
}
