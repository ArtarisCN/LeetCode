package question;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.10.18.14:37
 *
 * 119.Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * @author : artairs
 */
class PascalsTriangleII {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfArrayList(getRow2(13));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> start = new ArrayList<>();
        start.add(1);
        while (rowIndex > 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            for (int i = 0; i < start.size() - 1; i++) {
                temp.add(start.get(i) + start.get(i + 1));
            }
            temp.add(1);
            start = temp;
            rowIndex--;
        }

        return start;
    }


    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            double temp = 1;

            int x = i + 1,y = 1;
            while (x <= rowIndex || y<= (rowIndex - i)){
                if(x <= rowIndex) {
                    temp *= x;
                }
                if(y<= (rowIndex - i)) {
                    temp /= y;
                }
                x++;
                y++;
            }
            result.add((int) temp);
        }
        return result;
    }
}
