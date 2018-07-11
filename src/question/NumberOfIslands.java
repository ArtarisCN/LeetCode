package question;

/**
 * question
 * LeetCode
 * 2018.07.10.下午4:48
 * <p>
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * @author : rick
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        char[][] island = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(String.valueOf(numIslands(island)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count ++;
                }
            }
        }

        return count;

    }



    private static void dfs(char[][] grid,int i,int j){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid,i - 1,j);
            dfs(grid,i + 1,j);
            dfs(grid,i ,j - 1);
            dfs(grid, i, j + 1);
        }
    }

}
