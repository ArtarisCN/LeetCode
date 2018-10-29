package question;

/**
 * question
 * LeetCode
 * 2018.10.29.17:08
 * <p>
 * 840. Magic Squares In Grid
 * https://leetcode.com/problems/magic-squares-in-grid/
 *
 * @author : artairs
 */
class MagicSquaresInGrid {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 5) {

                    if (grid[i + 1][j] + grid[i - 1][j] == 10 &&
                            grid[i][j + 1] + grid[i][j - 1] == 10 &&
                            grid[i + 1][j + 1] + grid[i - 1][j - 1] == 10 &&
                            grid[i + 1][j - 1] + grid[i - 1][j + 1] == 10 &&
                            grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] == 15 &&
                            grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] == 15 &&
                            grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] == 15 &&
                            grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1] == 15 &&
                            isRightNum(grid[i - 1][j - 1]) && isRightNum(grid[i - 1][j]) && isRightNum(grid[i - 1][j + 1]) &&
                            isRightNum(grid[i][j - 1]) && isRightNum(grid[i][j + 1]) &&
                            isRightNum(grid[i + 1][j - 1]) && isRightNum(grid[i + 1][j]) && isRightNum(grid[i + 1][j + 1])) {
                        result++;

                    }

                    j++;//亮点※
                }
            }
        }
        return result;
    }

    private static boolean isRightNum(int i) {
        return i < 10 && i > 0;
    }
}
