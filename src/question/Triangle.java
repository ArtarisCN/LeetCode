package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2019.05.23.10:56
 * <p>
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 *
 * @author : artairs
 */
class Triangle {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        List<List<Integer>> triangle = new ArrayList<>();
//        triangle.add(Collections.singletonList(2));
//        triangle.add(Arrays.asList(3, 4));
//        triangle.add(Arrays.asList(6, 5, 7));
//        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }
        int[] result = new int[triangle.size()];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == triangle.size() - 1) {
                    result[j] = triangle.get(i).get(j);
                } else {
                    result[j] = Math.min(result[j] + triangle.get(i).get(j), result[j + 1] + triangle.get(i).get(j));
                }
            }
        }

        return result[0];
    }
}
