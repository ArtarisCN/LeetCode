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

        //        int[] nums = new int[]{4,2,7,5,11,13,9,1};
        System.out.println(maxProfit(new int[]{2,9,1,5}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        int small;
        if (prices.length == 0) return 0;
        else small = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - small > result) result = prices[i] - small;
            if (prices[i] < small) small = prices[i];
        }
        return result;
    }



}
