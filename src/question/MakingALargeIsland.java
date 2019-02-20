package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2019.02.18.16:58
 * <p>
 * 827. Making A Large Island
 * https://leetcode.com/problems/making-a-large-island/
 *
 * @author : artairs
 */
class MakingALargeIsland {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        System.out.println(largestIsland(new int[][]{{1, 1}, {1, 0}}));
        System.out.println(largestIsland(new int[][]{{1, 1}, {1, 1}}));
        System.out.println(largestIsland(new int[][]{{0, 0}, {0, 0}}));
        System.out.println(largestIsland(new int[][]{{0},{1}}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int largestIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int width = grid[0].length, height = grid.length;

        int[][] islandNum = new int[grid.length][grid[0].length];
        int[] joinFind = new int[grid.length * grid[0].length];

        int[][] searchGrid = new int[grid.length][grid[0].length];

        for (int i = 0; i < joinFind.length; i++) {
            joinFind[i] = -1;
        }


        for (int i = 0; i < grid.length; i++) {
            if (grid[i].length >= 0) System.arraycopy(grid[i], 0, searchGrid[i], 0, grid[i].length);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (searchGrid[i][j] == 1) {
                    joinFind[i * width + j] = i * width + j;
                    islandNum[i][j] = joinFind(searchGrid, joinFind, i, j, i * width + j);
                }
            }
        }

        int result = 0;
        boolean find = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    find = true;
                    int temp = 1;
                    List<Integer> already = new ArrayList<>();

                    if (valid(width, height, i - 1, j) && grid[i - 1][j] == 1) {
                        already.add(joinFind[(i - 1) * width + j]);
                        int m = joinFind[(i - 1) * width + j] / width;
                        int n = joinFind[(i - 1) * width + j] % width;
                        temp += islandNum[m][n];
                    }

                    if (valid(width, height, i + 1, j)
                            && grid[i + 1][j] == 1
                            && !already.contains(joinFind[(i + 1) * width + j])) {
                        already.add(joinFind[(i + 1) * width + j]);
                        int m = joinFind[(i + 1) * width + j] / width;
                        int n = joinFind[(i + 1) * width + j] % width;
                        temp += islandNum[m][n];
                    }

                    if (valid(width, height, i, j + 1)
                            && grid[i][j + 1] == 1
                            && !already.contains(joinFind[(i) * width + j + 1])) {

                        already.add(joinFind[(i) * width + j + 1]);
                        int m = joinFind[(i) * width + j + 1] / width;
                        int n = joinFind[(i) * width + j + 1] % width;
                        temp += islandNum[m][n];
                    }

                    if (valid(width, height, i, j - 1)
                            && grid[i][j - 1] == 1
                            && !already.contains(joinFind[(i) * width + j - 1])) {
                        already.add(joinFind[(i) * width + j - 1]);
                        int m = joinFind[(i) * width + j - 1] / width;
                        int n = joinFind[(i) * width + j - 1] % width;
                        temp += islandNum[m][n];
                    }

                    result = Math.max(temp, result);
                }
            }
        }

        if(!find){
            return width*height;
        }

        return result;
    }

    private static boolean valid(int width, int height, int i, int j) {
        return i >= 0 && j >= 0 && i < height && j < width;
    }

    private static int joinFind(int[][] searchGrid, int[] joinFind, int i, int j, int v) {
        if (i < 0 || j < 0 || i >= searchGrid.length || j >= searchGrid[0].length) {
            return 0;
        }

        if (searchGrid[i][j] == 1) {
            searchGrid[i][j] = 0;
            joinFind[i * searchGrid[0].length + j] = v;

            int thisValue = i * searchGrid[0].length + j, index;
            while (thisValue != v) {
                index = joinFind[thisValue];
                joinFind[thisValue] = v;
                thisValue = index;
            }

            return 1 + joinFind(searchGrid, joinFind, i + 1, j, v) +
                    joinFind(searchGrid, joinFind, i - 1, j, v) +
                    joinFind(searchGrid, joinFind, i, j + 1, v) +
                    joinFind(searchGrid, joinFind, i, j - 1, v);
        }

        return 0;
    }


}
