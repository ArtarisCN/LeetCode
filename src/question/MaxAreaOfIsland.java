package question;

/**
 * question
 * LeetCode
 * 2018.04.20.下午4:50
 * <p>
 * 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * @author : rick
 */
class MaxAreaOfIsland {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[][] island = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(island));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea,dfs(grid,i,j));
                }
            }
        }


        return maxArea;
    }

    private static int dfs(int[][] grid,int i,int j){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if(grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + dfs(grid,i - 1,j) + dfs(grid,i + 1,j) + dfs(grid,i ,j - 1) + dfs(grid, i, j + 1);
        }

        return 0;

    }


}