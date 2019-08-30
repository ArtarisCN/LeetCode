package question;

import java.util.HashSet;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2019.02.18.11:26
 * <p>
 * 803. Bricks Falling When Hit
 * https://leetcode.com/problems/bricks-falling-when-hit/
 *
 * @author : artairs
 */
class BricksFallingWhenHit {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printf(hitBricks(new int[][]{{1, 0, 1}, {0, 0, 1}}, new int[][]{{1, 0}, {0, 0}}));
//        PrintUtils.printfArray(hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 0}}, new int[][]{{1, 1}, {1, 0}}));
//        PrintUtils.printfArray(hitBricks(new int[][]{{1},{1},{1},{1},{1}}, new int[][]{{3, 0},{4, 0},{1, 0},{2, 0},{0, 0}}));
//        PrintUtils.printfArray(hitBricks(new int[][]{{1, 0, 1}, {1, 1, 1}}, new int[][]{{0, 0}, {0, 2},{1, 1}}));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] hitBricks(int[][] grid, int[][] hits) {
        HashSet<Integer> notDropBricks = new HashSet<>();
        int[] result = new int[hits.length];

        for (int[] hit : hits) {
            grid[hit[0]][hit[1]]--;
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                dfsNotDropBricks(grid, 0, i, notDropBricks);
            }
        }

        for (int i = hits.length - 1; i >= 0; i--) {
            int oldSize = notDropBricks.size();
            int x = hits[i][0], y = hits[i][1];

            if (++grid[x][y] == 1) {
                if ((x - 1 >= 0 && notDropBricks.contains((x - 1) * grid[0].length + y)) ||
                        (x + 1 < grid.length && notDropBricks.contains((x + 1) * grid[0].length + y)) ||
                        (y - 1 >= 0 && notDropBricks.contains(x * grid[0].length + y - 1)) ||
                        (y + 1 < grid[0].length && notDropBricks.contains(x * grid[0].length + y + 1)) ||
                        x == 0) {
                    dfsNotDropBricks(grid, x, y, notDropBricks);
                    result[i] = notDropBricks.size() - oldSize - 1;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static void dfsNotDropBricks(int[][] grid, int i, int j, HashSet<Integer> notDropBricks) {
        if (!valid(grid, i, j) || grid[i][j] != 1 || notDropBricks.contains(i * grid[0].length + j)) {
            return;
        }

        notDropBricks.add(i * grid[0].length + j);

        dfsNotDropBricks(grid, i + 1, j, notDropBricks);
        dfsNotDropBricks(grid, i - 1, j, notDropBricks);
        dfsNotDropBricks(grid, i, j + 1, notDropBricks);
        dfsNotDropBricks(grid, i, j - 1, notDropBricks);
    }

    public static boolean valid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }


//    public static int[] hitBricks(int[][] grid, int[][] hits) {
//        int[] result = new int[hits.length];
//
//        for (int i = 0; i < hits.length; i++) {
//            grid[hits[i][0]][hits[i][1]] = 0;
//            result[i] = searchConnectBricks(grid, hits[i][0], hits[i][1]);
//        }
//
//        return result;
//    }
//
//    private static int searchConnectBricks(int[][] grid, int row, int col) {
//        if (row == 0) {
//            int result = 0;
//
//            if (row != grid.length - 1) {
//                if (judgeBrickDrop(grid, row + 1, col) == 1) {
//                    grid[row + 1][col] = 0;
//                    result =  1 + searchConnectBricks(grid, row + 1, col);
//                }
//            }
//
//            return result;
//        } else if (row == grid.length - 1) {
//            int result = 0;
//
//            if (row - 1 != 0) {
//                if (judgeBrickDrop(grid, row - 1, col) == 1) {
//                    grid[row - 1][col] = 0;
//                    result = 1 + searchConnectBricks(grid, row - 1, col);
//                }
//            }
//
//            if (col - 1 >= 0) {
//                if (judgeBrickDrop(grid, row, col - 1) == 1) {
//                    grid[row][col - 1] = 0;
//                    result = result + 1 + searchConnectBricks(grid, row, col - 1);
//                }
//            }
//
//            if(col + 1 < grid[0].length){
//                if (judgeBrickDrop(grid, row, col + 1) == 1) {
//                    grid[row][col + 1] = 0;
//                    result = result + 1 + searchConnectBricks(grid, row, col + 1);
//                }
//            }
//
//            return result;
//        } else {
//            int result = 0;
//
//            if (row - 1 != 0) {
//                if (judgeBrickDrop(grid, row - 1, col) == 1) {
//                    grid[row - 1][col] = 0;
//                    result = 1 + searchConnectBricks(grid, row - 1, col);
//                }
//            }
//
//            if(row + 1 < grid.length){
//                if (judgeBrickDrop(grid, row + 1, col) == 1) {
//                    grid[row + 1][col] = 0;
//                    result = result + 1 + searchConnectBricks(grid, row + 1, col);
//                }
//            }
//
//            if (col - 1 >= 0) {
//                if (judgeBrickDrop(grid, row, col - 1) == 1) {
//                    grid[row][col - 1] = 0;
//                    result = result + 1 + searchConnectBricks(grid, row, col - 1);
//                }
//            }
//
//            if(col + 1 < grid[0].length){
//                if (judgeBrickDrop(grid, row, col + 1) == 1) {
//                    grid[row][col + 1] = 0;
//                    result = result + 1 + searchConnectBricks(grid, row, col + 1);
//                }
//            }
//
//            return result;
//        }
//    }
//
//    private static int judgeBrickDrop(int[][] grid, int row, int col) {
//        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
//            return 0;
//        }
//
//        if (row == 0) {
//            return 0;
//        }
//
//        if (row == grid.length - 1) {
//            if (col == 0) {
//                if (grid[row - 1][col] == 1 || grid[row][col + 1] == 1) {
//                    return 0;
//                }
//            } else if (col == grid[0].length - 1) {
//                if (grid[row - 1][col] == 1 || grid[row][col - 1] == 1) {
//                    return 0;
//                }
//            } else {
//                if (grid[row - 1][col] == 1 || grid[row][col - 1] == 1 || grid[row][col + 1] == 1) {
//                    return 0;
//                }
//            }
//        } else {
//            if (col == 0) {
//                if (grid[row - 1][col] == 1 || grid[row + 1][col] == 1 || grid[row][col + 1] == 1) {
//                    return 0;
//                }
//            } else if (col == grid[0].length - 1) {
//                if (grid[row - 1][col] == 1 || grid[row + 1][col] == 1 || grid[row][col - 1] == 1) {
//                    return 0;
//                }
//            } else {
//                if (grid[row - 1][col] == 1 || grid[row + 1][col] == 1 || grid[row][col - 1] == 1 || grid[row][col + 1] == 1) {
//                    return 0;
//                }
//            }
//        }
//
//        return 1;
//    }

}
