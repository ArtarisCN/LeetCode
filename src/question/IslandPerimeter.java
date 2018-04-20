package question;

/**
 * question
 * LeetCode
 * 2018.04.20.下午4:01
 * <p>
 * 463. Island Perimeter
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * @author : rick
 */
class IslandPerimeter {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[][] a = {{1}};

        System.out.println(islandPerimeter(a));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int islandPerimeter(int[][] grid) {

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {

                    boolean left = true, top = true, bottom = true, right = true;

                    if (grid.length > 1) {

                        while (left) {
                            if (i == 0) {
                                perimeter++;
                                left = false;
                                continue;
                            }

                            if (grid[i - 1][j] != 1) {
                                perimeter++;
                                left = false;
                            } else {
                                left = false;
                            }
                        }

                        while (right) {
                            if (i == grid.length - 1) {
                                perimeter++;
                                right = false;
                                continue;
                            }

                            if (grid[i + 1][j] != 1) {
                                perimeter++;
                                right = false;
                            } else {
                                right = false;
                            }
                        }
                    } else {
                        perimeter += 2;
                        right = false;
                        left = false;
                    }

                    if (grid[i].length > 1) {

                        while (top) {
                            if (j == 0) {
                                perimeter++;
                                top = false;
                                continue;
                            }

                            if (grid[i][j - 1] != 1) {
                                perimeter++;
                                top = false;
                            } else {
                                top = false;
                            }
                        }

                        while (bottom) {
                            if (j == grid[i].length - 1) {
                                perimeter++;
                                bottom = false;
                                continue;
                            }

                            if (grid[i][j + 1] != 1) {
                                perimeter++;
                                bottom = false;
                            } else {
                                bottom = false;
                            }
                        }
                    } else {
                        perimeter += 2;
                        top = false;
                        bottom = false;
                    }
                }
            }
        }

        return perimeter;
    }
}
