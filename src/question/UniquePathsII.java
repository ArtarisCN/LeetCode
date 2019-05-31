package question;

/**
 * question
 * LeetCode
 * 2019.05.31.15:16
 * <p>
 * 63. Unique Paths II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @author : artairs
 */
class UniquePathsII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[][] obstacleGrid = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        System.out.println(uniquePathsWithObstacles(obstacleGrid));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        if (x == 0) {
            return 0;
        }
        int y = obstacleGrid[0].length;
        if (y == 0) {
            return 0;
        }

        if(obstacleGrid[0][0] == 1 || obstacleGrid[x - 1][y -1] == 1){
            return 0;
        }

        int[][] matrix = new int[x][y];


        matrix[0][0] = 1;

        return resolvePathsMatrix(x - 1, y - 1, matrix, obstacleGrid);
    }


    private static int resolvePathsMatrix(int m, int n, int[][] matrix, int[][] obstacleGrid) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (matrix[m][n] > 0) {
            return matrix[m][n];
        }
        int result = 0;
        if (m - 1 >= 0 && obstacleGrid[m - 1][n] != 1) {
            if (matrix[m - 1][n] == 0) {
                matrix[m - 1][n] = resolvePathsMatrix(m - 1, n, matrix, obstacleGrid);
            }
            result += matrix[m - 1][n];
        }

        if (n - 1 >= 0 && obstacleGrid[m][n - 1] != 1) {
            if (matrix[m][n - 1] == 0) {
                matrix[m][n - 1] = resolvePathsMatrix(m, n - 1, matrix, obstacleGrid);
            }
            result += matrix[m][n - 1];
        }
        matrix[m][n] = result;

        return result;
    }

}
