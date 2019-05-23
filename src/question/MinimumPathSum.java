package question;

/**
 * question
 * LeetCode
 * 2019.05.23.11:35
 * <p>
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * @author : artairs
 */
class MinimumPathSum {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[][] gride = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(minPathSum(gride));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = -1;
            }
        }
        result[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        return calculate(0, 0, result, grid);
    }

    public static int calculate(int x, int y, int[][] result, int[][] grid) {
        if (x == grid.length - 1 && y < grid[0].length - 1) {
            if (result[x][y + 1] == -1) {
                result[x][y + 1] = calculate(x, y + 1, result, grid);
            }
            result[x][y] = grid[x][y] + result[x][y + 1];
        } else if (y == grid[0].length - 1 && x < grid.length - 1) {
            if (result[x + 1][y] == -1) {
                result[x + 1][y] = calculate(x + 1, y, result, grid);
            }
            result[x][y] = grid[x][y] + result[x + 1][y];
        } else if (x == grid.length - 1 && y == grid[0].length - 1) {
            result[x][y] = result[x][y];
        } else {
            if (result[x + 1][y] == -1) {
                result[x + 1][y] = calculate(x + 1, y, result, grid);
            }
            if (result[x][y + 1] == -1) {
                result[x][y + 1] = calculate(x, y + 1, result, grid);
            }
            result[x][y] = Math.min(grid[x][y] + result[x + 1][y], grid[x][y] + result[x][y + 1]);
        }
        return result[x][y];
    }
}
