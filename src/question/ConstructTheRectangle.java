package question;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.09.28.18:11
 *
 * 492. Construct the Rectangle
 * https://leetcode.com/problems/construct-the-rectangle/description/
 *
 * @author : artairs
 */
class ConstructTheRectangle {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfArray(constructRectangle(6));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] constructRectangle(int area) {
        int start = (int) Math.sqrt(area);
        int[] result = new int[2];
        while (start > 0){
            if(area % start == 0){
                result[1] = start;
                result[0] = area / start;
                break;
            }
            start --;
        }

        return result;
    }
}
