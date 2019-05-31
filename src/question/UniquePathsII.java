package question;

/**
 * question
 * LeetCode
 * 2019.05.31.15:16
 *
 * 63. Unique Paths II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @author : artairs
 */
class UniquePathsII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        if(x == 0){
            return 0;
        }
        int y = obstacleGrid[0].length;
        if(y  == 0){
            return 0;
        }



    }

}
