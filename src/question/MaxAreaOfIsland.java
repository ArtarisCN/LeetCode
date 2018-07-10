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

        int[][] island = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                          {0,0,0,0,0,0,0,1,1,1,0,0,0},
                          {0,1,1,0,1,0,0,0,0,0,0,0,0},
                          {0,1,0,0,1,1,0,0,1,0,1,0,0},
                          {0,1,0,0,1,1,0,0,1,1,1,0,0},
                          {0,0,0,0,0,0,0,0,0,0,1,0,0},
                          {0,0,0,0,0,0,0,1,1,1,0,0,0},
                          {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(island));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

    public static int maxAreaOfIsland(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int[][] flag = new int[grid.length][grid[0].length];

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if(grid[i][j] == 1){

                    int top = 0,bottom = 0,left = 0,right = 0;

                    if(flag[i][j] == 0){


                        if(i > 0){
                            top  = flag[i - 1][j];
                        }

                        if(i < flag.length - 1){
                            bottom  = flag[i + 1][j];
                        }

                        if(j > 0){
                            left = flag[i][j - 1];
                        }

                        if(j < flag.length - 1){
                            right = flag[i][j + 1];
                        }
                    }

                    flag[i][j] = Math.max(Math.max(Math.max(top,bottom),left),right) + 1;

                    if(left != 0){
                        if(j > 1){
                            flag[i][j - 1] = flag[i][j];
                        }
                    }

                    if(right != 0){
                        if(j < flag.length - 2){
                            flag[i][j + 1] = flag[i][j];
                        }
                    }

                    if(top != 0){
                        if(i > 1){
                            flag[i - 1][j] = flag[i][j];
                        }
                    }

                    if(bottom != 0){
                        if(i < flag.length - 2){
                            flag[i + 1][j] = flag[i][j];
                        }
                    }

                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(flag[i][j] > maxArea){
                    maxArea = flag[i][j];
                }
            }
        }

        return maxArea;
    }

}
