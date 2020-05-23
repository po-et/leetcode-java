package com.home.leetcode.cn;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * @author Poet
 * @date 2020/5/23
 */
public class Best_time_to_buy_and_sell_stock_ii_122 {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));

        int[] arr1 = {1,2,3,4,5};
        System.out.println(maxProfit(arr1));
    }


    // 滑动窗口
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        int l = 0, r = l+1;
        int ret = 0;

        while (r < prices.length) {
            if (prices[r-1] <= prices[r]) {
                ret += prices[r] - prices[r - 1];
                r++;
            } else { // prices[r-1] > prices[r]
                l = r;
                r++;
            }
        }
        return ret;
    }



    /**
     * 贪心算法：只要第二天的价格比今天高，就第一天买，第二天卖
     */
    public int maxProfix2(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i+1] - prices[i] > 0){
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }


    /**
     * 动态规划 （没看懂！！！）
     */
    public int maxProfix3(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -7;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
