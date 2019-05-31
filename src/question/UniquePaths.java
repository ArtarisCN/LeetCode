package question;

/**
 * question
 * LeetCode
 * 2019.05.31.15:02
 * <p>
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 *
 * @author : artairs
 */
class UniquePaths {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(uniquePaths(1, 9));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] matrix = new int[m][n];

        matrix[0][0] = 1;

        return resolvePathsMatrix(m - 1, n - 1, matrix);
    }


    private static int resolvePathsMatrix(int m, int n, int[][] matrix) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (matrix[m][n] > 0) {
            return matrix[m][n];
        }
        int result = 0;
        if (m - 1 >= 0) {
            if (matrix[m - 1][n] == 0) {
                matrix[m - 1][n] = resolvePathsMatrix(m - 1, n, matrix);
            }
            result += matrix[m - 1][n];
        }

        if (n - 1 >= 0) {
            if (matrix[m][n - 1] == 0) {
                matrix[m][n - 1] = resolvePathsMatrix(m, n - 1, matrix);
            }
            result += matrix[m][n - 1];
        }
        matrix[m][n] = result;

        return result;
    }


}
