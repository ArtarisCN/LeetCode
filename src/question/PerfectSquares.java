package question;

/**
 * question
 * LeetCode
 * 2019.05.24.17:53
 * <p>
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/
 *
 * @author : artairs
 */
class PerfectSquares {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(numSquares(13));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int numSquares(int n) {
        int[] squaresCache = new int[n + 1];
        squaresCache[1] = 1;
        for (int i = 2; i < squaresCache.length; i++) {
            int maxSqrt = (int) Math.sqrt(i);
            if(maxSqrt * maxSqrt == i){
                squaresCache[i] = 1;
            } else {
                int minV = Integer.MAX_VALUE;
                for (int j = 1; j <= maxSqrt; j++) {
                    minV = Math.min(squaresCache[j * j] + squaresCache[i - j * j],minV);
                }
                squaresCache[i] = minV;
            }
        }

        return squaresCache[n];
    }


}
