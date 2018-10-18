package question;

/**
 * question
 * LeetCode
 * 2018.10.18.15:34
 * <p>
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author : artairs
 */
class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(maxProfit(new int[]{7,6,4,3,1}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {
                int min = prices[j] - prices[i];
                if (min > 0 && min > max) {
                    max = min;
                }
            }
        }
        return max;
    }

}
