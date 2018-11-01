package question;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.11.01.16:20
 * <p>
 * 733. Flood Fill
 * https://leetcode.com/problems/flood-fill/
 *
 * @author : artairs
 */
class FloodFill {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        int[][] result = floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2);
        int[][] result = floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 2);
        PrintUtils.printf2DArray(result);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length) {
            return;
        }

        if (image[sr][sc] != oldColor || image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;

        if (sr != 0) {
            if (image[sr - 1][sc] == oldColor) {
                fill(image, sr - 1, sc, newColor, oldColor);
            }
        }

        if (sr != image.length - 1) {
            if (image[sr + 1][sc] == oldColor) {
                fill(image, sr + 1, sc, newColor, oldColor);
            }
        }

        if (sc != 0) {
            if (image[sr][sc - 1] == oldColor) {
                fill(image, sr, sc - 1, newColor, oldColor);
            }
        }

        if (sc != image[sr].length - 1) {
            if (image[sr][sc + 1] == oldColor) {
                fill(image, sr, sc + 1, newColor, oldColor);
            }
        }
    }
}
