package question;

/**
 * question
 * LeetCode
 * 2018.10.19.14:24
 * <p>
 * 122.Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author : artairs
 */
class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int current = prices[0], profit = 0;
        for (int price : prices) {
            if (price < current) {
                current = price;
            }

            if (current < price) {
                profit += price - current;
                current = price;
            }
        }

        return profit;

    }
}
