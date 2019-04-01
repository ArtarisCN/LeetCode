package question;

/**
 * question
 * LeetCode
 * 2019.03.29.16:26
 * <p>
 * 877. Stone Game
 * https://leetcode.com/problems/stone-game/
 *
 * @author : artairs
 */
class StoneGame {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length - 1;
        return dp(0,n,piles)> 0;
    }

    private static int dp(int i,int j,int[] piles){
        if(i == j){
            return piles[i];
        }

        return Math.max(dp(i+1,j,piles),dp(i,j-1,piles));
    }


}
