package question;

/**
 * question
 * LeetCode
 * 2018.10.29.10:19
 *
 * 892. Surface Area of 3D Shapes
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 *
 * @author : artairs
 */
class SurfaceAreaOf3DShapes {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(surfaceArea(new int[][]{{}}));
        System.out.println(surfaceArea(new int[][]{{2}}));
        System.out.println(surfaceArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(surfaceArea(new int[][]{{1, 0}, {0, 2}}));
        System.out.println(surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        System.out.println(surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int surfaceArea(int[][] grid) {
        int surfaceArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int top = i == 0 ? 0 : grid[i - 1][j],
                        left = j == 0 ? 0 : grid[i][j - 1],
                        right = j == grid[i].length - 1 ? 0 : grid[i][j + 1],
                        bottom = i == grid.length - 1 ? 0 : grid[i + 1][j];
                int height = grid[i][j];
                surfaceArea += height == 0 ? 0 : 2 +
                        (height - top > 0 ? height - top : 0) +
                        (height - left > 0 ? height - left : 0) +
                        (height - right > 0 ? height - right : 0) +
                        (height - bottom > 0 ? height - bottom : 0);
            }
        }

        return surfaceArea;
    }

}
