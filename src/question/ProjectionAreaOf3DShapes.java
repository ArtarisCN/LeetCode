package question;

/**
 * question
 * LeetCode
 * 2018.10.29.10:37
 *
 * 883. Projection Area of 3D Shapes
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
 *
 * @author : artairs
 */
class ProjectionAreaOf3DShapes {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(projectionArea(new int[][]{{}}));
        System.out.println(projectionArea(new int[][]{{2}}));
        System.out.println(projectionArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(projectionArea(new int[][]{{1, 0}, {0, 2}}));
        System.out.println(projectionArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int projectionArea(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int surfaceArea = 0;

        int[] across = new int[grid[0].length],vertical = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > across[j]){
                    across[j] = grid[i][j];
                }

                if(grid[i][j] > vertical[i]){
                    vertical[i] = grid[i][j];
                }

                surfaceArea += grid[i][j] > 0?1:0;
            }
        }

        for (int i : across) {
            surfaceArea += i;
        }

        for (int i : vertical) {
            surfaceArea += i;
        }

        return surfaceArea;
    }

}
