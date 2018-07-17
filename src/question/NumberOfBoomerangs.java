package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.07.17.上午11:14
 *
 * 447. Number of Boomerangs
 * https://leetcode.com/problems/number-of-boomerangs/description/
 *
 * @author : rick
 */
class NumberOfBoomerangs {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[][] points = new int[][]{{0,0},{1,0},{2,0}};


        System.out.println(String.valueOf(numberOfBoomerangs(points)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;

        Map<Double,Integer> num = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0],y = points[i][1];

            num.clear();

            for (int j = 0;j < points.length ; j++){
                if(i == j) {
                    continue;
                }

                int a = points[j][0],b = points[j][1];

                double v = Math.sqrt( (a - x)*(a - x) + (b - y)*(b - y));
                if(num.containsKey(v)){
                    num.put(v,num.get(v) + 1);
                } else {
                    num.put(v,1);
                }
            }


            for (Double aDouble : num.keySet()) {
                int v = num.get(aDouble);
                result += (v - 1) * v;
            }
        }
        return result;

    }

}
